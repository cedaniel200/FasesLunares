package com.cedaniel200.android.faseslunares.main;

import com.cedaniel200.android.faseslunares.main.events.MainEvent;

import java.util.Calendar;
/**
 * Created by cedaniel200 on 2016/07/11.
 */
public interface MainPresenter {
    void onCreate();
    void onDestroy();
    void calcularFaseLunar(Calendar fecha);
    void onEventMainThread(MainEvent event);
}
