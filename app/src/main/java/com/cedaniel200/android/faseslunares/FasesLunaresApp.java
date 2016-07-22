package com.cedaniel200.android.faseslunares;

import android.app.Application;

import com.cedaniel200.android.faseslunares.lib.di.LibsModule;
import com.cedaniel200.android.faseslunares.main.di.DaggerMainComponent;
import com.cedaniel200.android.faseslunares.main.di.MainComponent;
import com.cedaniel200.android.faseslunares.main.di.MainModule;
import com.cedaniel200.android.faseslunares.main.ui.MainActivity;
import com.cedaniel200.android.faseslunares.main.ui.MainView;

/**
 * Created by cedaniel200 on 2016/07/11.
 */
public class FasesLunaresApp extends Application {

    public MainComponent getMainComponent(MainActivity activity, MainView view){
        return DaggerMainComponent
                .builder()
                .libsModule(new LibsModule(activity))
                .mainModule(new MainModule(view))
                .build();
    }
}
