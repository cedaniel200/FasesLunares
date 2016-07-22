package com.cedaniel200.android.faseslunares.lib.di;

import android.app.Activity;

import com.cedaniel200.android.faseslunares.lib.GreenRobotEventBus;
import com.cedaniel200.android.faseslunares.lib.Tools;
import com.cedaniel200.android.faseslunares.lib.base.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cedaniel200 on 06/07/2016.
 */
@Module
public class LibsModule {
    private Activity activity;

    public LibsModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @Singleton
    Activity providesActivity(){
        return this.activity;
    }

    @Provides
    @Singleton
    EventBus providesEventBus(org.greenrobot.eventbus.EventBus eventBus){
        return new GreenRobotEventBus(eventBus);
    }

    @Provides
    @Singleton
    org.greenrobot.eventbus.EventBus providesLibraryEventBus(){
        return org.greenrobot.eventbus.EventBus.getDefault();
    }

    @Provides
    @Singleton
    Tools providesTools(){
        return new Tools();
    }
}
