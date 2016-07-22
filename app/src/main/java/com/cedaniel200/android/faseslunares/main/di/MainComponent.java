package com.cedaniel200.android.faseslunares.main.di;

import com.cedaniel200.android.faseslunares.lib.di.LibsModule;
import com.cedaniel200.android.faseslunares.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by cedaniel200 on 2016/07/11.
 */
@Singleton
@Component(modules = {MainModule.class, LibsModule.class})
public interface MainComponent {
    //void inject(MainActivity activity);
    MainPresenter getPresenter();
}
