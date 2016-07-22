package com.cedaniel200.android.faseslunares.main.ui;

import com.cedaniel200.android.faseslunares.entities.FaseLunar;

import java.util.Calendar;

/**
 * Created by cedaniel200 on 2016/07/11.
 */
public interface MainView {

    public static final String FECHA_ACTUAL = "fecha";

    void calcularFaseLunar(Calendar fecha);
    void cambiarFaseLunar(FaseLunar faseLunar);
    void actualizarVista();
    void irFecha(Calendar fecha);
    void error(String error);
}
