package com.cedaniel200.android.faseslunares.main;

import com.cedaniel200.android.faseslunares.lib.base.EventBus;
import com.cedaniel200.android.faseslunares.main.events.MainEvent;
import com.cedaniel200.android.faseslunares.main.ui.MainView;

import org.greenrobot.eventbus.Subscribe;

import java.util.Calendar;

/**
 * Created by cedaniel200 on 2016/07/11.
 */
public class MainPresenterImpl implements MainPresenter {

    private MainView view;
    private EventBus eventBus;
    private MainInteractor interactor;

    public MainPresenterImpl(MainView view, EventBus eventBus, MainInteractor interactor) {
        this.eventBus = eventBus;
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
        view = null;
    }

    @Override
    public void calcularFaseLunar(Calendar fecha) {
        interactor.execute(fecha);
    }

    @Override
    @Subscribe
    public void onEventMainThread(MainEvent event) {
        if(view != null){
            String error = event.getError();
            if(error != null){
                view.error(error);;
            }else{
                if(event.getType() == MainEvent.OBTENER_FASE_LUNAR){
                    view.cambiarFaseLunar(event.getFaseLunar());
                    view.actualizarVista();
                }
            }
        }
    }

    // Metodo utilizado a la hora de hacer pruebas unitarias
    public MainView getView(){
        return this.view;
    }

}
