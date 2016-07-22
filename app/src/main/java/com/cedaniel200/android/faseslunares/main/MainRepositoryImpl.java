package com.cedaniel200.android.faseslunares.main;

import com.cedaniel200.android.faseslunares.R;
import com.cedaniel200.android.faseslunares.entities.FaseLunar;
import com.cedaniel200.android.faseslunares.lib.Tools;
import com.cedaniel200.android.faseslunares.lib.base.EventBus;
import com.cedaniel200.android.faseslunares.main.events.MainEvent;

import java.util.Calendar;

/**
 * Created by cedaniel200 on 2016/07/11.
 */
public class MainRepositoryImpl implements MainRepository {

    private EventBus eventBus;
    private Tools tools;

    public MainRepositoryImpl(EventBus eventBus, Tools tools) {
        this.eventBus = eventBus;
        this.tools = tools;
    }

    @Override
    public void calcularFaseLunar(Calendar fecha) {

        FaseLunar faseLunar = new FaseLunar();
        faseLunar.setFecha(fecha);

        int fase = tools.obtenerFaseLunar(fecha);

        switch (fase){
            case Tools.LUNA_NUEVA:
                faseLunar.setIdImagen(R.drawable.luna_nueva);
                faseLunar.setIdNombre(R.string.luna_nueva);
                break;
            case Tools.LUNA_POCO_CRECIENTE:
                faseLunar.setIdImagen(R.drawable.luna_poco_creciente);
                faseLunar.setIdNombre(R.string.luna_poco_creciente);
                break;
            case Tools.LUNA_CUARTO_CRECIENTE:
                faseLunar.setIdImagen(R.drawable.luna_cuarto_creciente);
                faseLunar.setIdNombre(R.string.luna_cuarto_creciente);
                break;
            case Tools.LUNA_MUY_CRECIENTE:
                faseLunar.setIdImagen(R.drawable.luna_muy_creciente);
                faseLunar.setIdNombre(R.string.luna_muy_creciente);
                break;
            case Tools.LUNA_LLENA:
                faseLunar.setIdImagen(R.drawable.luna_llena);
                faseLunar.setIdNombre(R.string.luna_llena);
                break;
            case Tools.LUNA_POCO_MENGUANTE:
                faseLunar.setIdImagen(R.drawable.luna_poco_menguante);
                faseLunar.setIdNombre(R.string.luna_poco_menguante);
                break;
            case Tools.LUNA_CUARTO_MENGUANTE:
                faseLunar.setIdImagen(R.drawable.luna_cuarto_menguante);
                faseLunar.setIdNombre(R.string.luna_cuarto_menguante);
                break;
            case Tools.LUNA_MUY_MENGUANTE:
                faseLunar.setIdImagen(R.drawable.luna_muy_menguante);
                faseLunar.setIdNombre(R.string.luna_muy_menguante);
                break;
        }

        int signoZodiacal = tools.obtenerSignozodiacal(fecha);

        switch (signoZodiacal){
            case Tools.ACUARIO:
                faseLunar.setIdImagenSignoZodiacal(R.drawable.acuario);
                faseLunar.setIdNombreSignoZodiacal(R.string.acuario);
                faseLunar.setIdPeriodoSignoZodiacal(R.string.periodo_acuario);
                break;
            case Tools.ARIES:
                faseLunar.setIdImagenSignoZodiacal(R.drawable.aries);
                faseLunar.setIdNombreSignoZodiacal(R.string.aries);
                faseLunar.setIdPeriodoSignoZodiacal(R.string.periodo_aries);
                break;
            case Tools.CANCER:
                faseLunar.setIdImagenSignoZodiacal(R.drawable.cancer);
                faseLunar.setIdNombreSignoZodiacal(R.string.cancer);
                faseLunar.setIdPeriodoSignoZodiacal(R.string.periodo_cancer);
                break;
            case Tools.CAPRICORNIO:
                faseLunar.setIdImagenSignoZodiacal(R.drawable.capricornio);
                faseLunar.setIdNombreSignoZodiacal(R.string.capricornio);
                faseLunar.setIdPeriodoSignoZodiacal(R.string.periodo_capricornio);
                break;
            case Tools.ESCORPIO:
                faseLunar.setIdImagenSignoZodiacal(R.drawable.escorpio);
                faseLunar.setIdNombreSignoZodiacal(R.string.escorpio);
                faseLunar.setIdPeriodoSignoZodiacal(R.string.periodo_escorpio);
                break;
            case Tools.GEMINIS:
                faseLunar.setIdImagenSignoZodiacal(R.drawable.geminis);
                faseLunar.setIdNombreSignoZodiacal(R.string.geminis);
                faseLunar.setIdPeriodoSignoZodiacal(R.string.periodo_geminis);
                break;
            case Tools.LEO:
                faseLunar.setIdImagenSignoZodiacal(R.drawable.leo);
                faseLunar.setIdNombreSignoZodiacal(R.string.leo);
                faseLunar.setIdPeriodoSignoZodiacal(R.string.periodo_leo);
                break;
            case Tools.LIBRA:
                faseLunar.setIdImagenSignoZodiacal(R.drawable.libra);
                faseLunar.setIdNombreSignoZodiacal(R.string.libra);
                faseLunar.setIdPeriodoSignoZodiacal(R.string.periodo_libra);
                break;
            case Tools.PISCIS:
                faseLunar.setIdImagenSignoZodiacal(R.drawable.piscis);
                faseLunar.setIdNombreSignoZodiacal(R.string.piscis);
                faseLunar.setIdPeriodoSignoZodiacal(R.string.periodo_piscis);
                break;
            case Tools.SAGITARIO:
                faseLunar.setIdImagenSignoZodiacal(R.drawable.sagitario);
                faseLunar.setIdNombreSignoZodiacal(R.string.sagitario);
                faseLunar.setIdPeriodoSignoZodiacal(R.string.periodo_sagitario);
                break;
            case Tools.TAURO:
                faseLunar.setIdImagenSignoZodiacal(R.drawable.tauro);
                faseLunar.setIdNombreSignoZodiacal(R.string.tauro);
                faseLunar.setIdPeriodoSignoZodiacal(R.string.periodo_tauro);
                break;
            case Tools.VIRGO:
                faseLunar.setIdImagenSignoZodiacal(R.drawable.virgo);
                faseLunar.setIdNombreSignoZodiacal(R.string.virgo);
                faseLunar.setIdPeriodoSignoZodiacal(R.string.periodo_virgo);
                break;
        }

        post(null, MainEvent.OBTENER_FASE_LUNAR, faseLunar);

    }

    private void post(String error, int type, FaseLunar faseLunar){
        MainEvent event = new MainEvent();
        event.setType(type);
        event.setError(error);
        event.setFaseLunar(faseLunar);
        eventBus.post(event);
    }

}
