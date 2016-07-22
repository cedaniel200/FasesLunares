package com.cedaniel200.android.faseslunares.lib;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by cedaniel200 on 06/07/2016.
 */
public class GreenRobotEventBus implements com.cedaniel200.android.faseslunares.lib.base.EventBus{
    EventBus eventBus;

    public GreenRobotEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void register(Object subscriber) {
        eventBus.register(subscriber);
    }

    @Override
    public void unregister(Object subscriber) {
        eventBus.unregister(subscriber);
    }

    @Override
    public void post(Object event) {
        eventBus.post(event);
    }
}
