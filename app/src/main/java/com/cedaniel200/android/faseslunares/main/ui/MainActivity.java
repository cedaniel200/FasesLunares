package com.cedaniel200.android.faseslunares.main.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cedaniel200.android.faseslunares.FasesLunaresApp;
import com.cedaniel200.android.faseslunares.R;
import com.cedaniel200.android.faseslunares.main.MainPresenter;
import com.cedaniel200.android.faseslunares.entities.FaseLunar;
import com.cedaniel200.android.faseslunares.main.di.MainComponent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements MainView {

    private ImageView imgFaseLunar;
    private ImageView imgSignoZodiacal;
    private TextView txtNombreFaseLunar;
    private TextView txtSignoZodiacal;
    private TextView txtPeriodoSignoZodiacal;
    private CalendarView calendarView;
    private RelativeLayout container;
    private MainPresenter presenter;
    private Calendar fechaActual;
    private FaseLunar faseLunarActual;
    private MainComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (RelativeLayout) findViewById(R.id.container);
        imgFaseLunar = (ImageView) findViewById(R.id.imgFaseLunar) ;
        txtNombreFaseLunar = (TextView) findViewById(R.id.txtNombreFaseLunar);
        imgSignoZodiacal = (ImageView) findViewById(R.id.imgSignoZodiacal) ;
        txtSignoZodiacal = (TextView) findViewById(R.id.txtSignoZodiacal);
        txtPeriodoSignoZodiacal = (TextView) findViewById(R.id.txtPeriodoSignoZodiacal);
        calendarView = (CalendarView) findViewById(R.id.calendarView);

        setupInjection();
        presenter.onCreate();
        setupCalendar(savedInstanceState);
    }

    private void setupInjection() {
        FasesLunaresApp app = (FasesLunaresApp) getApplication();
        component = app.getMainComponent(this, this);
        presenter = getPresenter();
    }

    private void setupCalendar(Bundle savedInstanceState) {
        calendarView.setShowWeekNumber(false);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int anio, int mes, int dia) {
                Calendar fecha = Calendar.getInstance();
                fecha.set(anio, mes, dia);
                fechaActual = fecha;
                calcularFaseLunar(fechaActual);
            }
        });

        if(savedInstanceState != null && savedInstanceState.containsKey(FECHA_ACTUAL)){
            fechaActual =  (Calendar) savedInstanceState.getSerializable(FECHA_ACTUAL);
            irFecha(fechaActual);
        }else {

            Intent intent = getIntent();
            if(intent != null && intent.hasExtra(FECHA_ACTUAL)){
                fechaActual = (Calendar) intent.getSerializableExtra(FECHA_ACTUAL);
                irFecha(fechaActual);
            }else{
                fechaActual = Calendar.getInstance();
            }
        }

        calcularFaseLunar(fechaActual);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(FECHA_ACTUAL, fechaActual);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_share) {
            compartirInformacion();
        } else if (id == R.id.action_current_Date){
            irFecha(Calendar.getInstance());
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void calcularFaseLunar(Calendar fecha) {
        presenter.calcularFaseLunar(fecha);
    }

    @Override
    public void cambiarFaseLunar(FaseLunar faseLunar) {
        faseLunarActual = faseLunar;
    }

    @Override
    public void actualizarVista() {
        imgFaseLunar.setImageDrawable(ResourcesCompat.getDrawable(getResources(), faseLunarActual.getIdImagen(), null));
        txtNombreFaseLunar.setText(getString(faseLunarActual.getIdNombre()));
        if(imgSignoZodiacal != null){
            imgSignoZodiacal.setImageDrawable(ResourcesCompat.getDrawable(getResources(), faseLunarActual.getIdImagenSignoZodiacal(), null));
        }
        if(txtPeriodoSignoZodiacal != null){
            txtSignoZodiacal.setText(getString(faseLunarActual.getIdNombreSignoZodiacal()));
            txtPeriodoSignoZodiacal.setText(getString(faseLunarActual.getIdPeriodoSignoZodiacal()));
        }else{
            String descripcionSigno = getString(faseLunarActual.getIdNombreSignoZodiacal())+" "+getString(faseLunarActual.getIdPeriodoSignoZodiacal());
            txtSignoZodiacal.setText(descripcionSigno);
        }
    }

    @Override
    public void irFecha(Calendar fecha) {
        calendarView.setDate(fecha.getTimeInMillis());
    }

    @Override
    public void error(String error) {
        Snackbar.make(container, error, Snackbar.LENGTH_SHORT).show();
    }

    private void compartirInformacion() {

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/png");

        Date fecha = faseLunarActual.getFecha().getTime();
        String fechaStr = new SimpleDateFormat(getString(R.string.format_date)).format(fecha);
        String textoCompartir = String.format(getString(R.string.global_txt_share), fechaStr, getString(faseLunarActual.getIdNombre()).toLowerCase());

        shareIntent.putExtra(Intent.EXTRA_EMAIL, textoCompartir);
        shareIntent.putExtra(Intent.EXTRA_TEXT, textoCompartir);
        shareIntent.putExtra(Intent.EXTRA_STREAM,
                Uri.parse("android.resource://com.cedaniel200.android.faseslunares/drawable/" +
                                getResources().getResourceEntryName(faseLunarActual.getIdImagen())
                        ));

        startActivity(Intent.createChooser(shareIntent, getString(R.string.global_title_share_phase)));
    }

    private MainPresenter getPresenter(){
        return component.getPresenter();
    }

}
