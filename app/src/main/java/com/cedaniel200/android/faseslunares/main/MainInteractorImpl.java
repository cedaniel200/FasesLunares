package com.cedaniel200.android.faseslunares.main;

import java.util.Calendar;

/**
 * Created by cedaniel200 on 2016/07/11.
 */
public class MainInteractorImpl implements MainInteractor {

    private MainRepository repository;

    public MainInteractorImpl(MainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Calendar fecha) {
        repository.calcularFaseLunar(fecha);
    }
}
