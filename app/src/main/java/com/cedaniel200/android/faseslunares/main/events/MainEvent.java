package com.cedaniel200.android.faseslunares.main.events;

import com.cedaniel200.android.faseslunares.entities.FaseLunar;

/**
 * Created by cedaniel200 on 12/07/2016.
 */
public class MainEvent {
    private int type;
    private String error;
    private FaseLunar faseLunar;

    public final static int OBTENER_FASE_LUNAR = 0;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public FaseLunar getFaseLunar() {
        return faseLunar;
    }

    public void setFaseLunar(FaseLunar faseLunar) {
        this.faseLunar = faseLunar;
    }
}
