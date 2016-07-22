package com.cedaniel200.android.faseslunares.main.di;

import com.cedaniel200.android.faseslunares.lib.Tools;
import com.cedaniel200.android.faseslunares.lib.base.EventBus;
import com.cedaniel200.android.faseslunares.main.MainInteractor;
import com.cedaniel200.android.faseslunares.main.MainInteractorImpl;
import com.cedaniel200.android.faseslunares.main.MainPresenter;
import com.cedaniel200.android.faseslunares.main.MainPresenterImpl;
import com.cedaniel200.android.faseslunares.main.MainRepository;
import com.cedaniel200.android.faseslunares.main.MainRepositoryImpl;
import com.cedaniel200.android.faseslunares.main.ui.MainView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cedaniel200 on 2016/07/11.
 */
@Module
public class MainModule {
    private MainView view;

    public MainModule(MainView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    MainView providesMainView(){
        return this.view;
    }

    @Provides
    @Singleton
    MainPresenter providesMainPresenter(MainView view, EventBus eventBus, MainInteractor interactor){
        return new MainPresenterImpl(view, eventBus, interactor);
    }

    @Provides
    @Singleton
    MainInteractor providesMainInteractor(MainRepository repository){
        return new MainInteractorImpl(repository);
    }

    @Provides
    @Singleton
    MainRepository providesMainRepository(EventBus eventBus, Tools tools){
        return new MainRepositoryImpl(eventBus, tools);
    }

}
