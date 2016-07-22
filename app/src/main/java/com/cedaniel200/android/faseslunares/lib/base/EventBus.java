package com.cedaniel200.android.faseslunares.lib.base;

/**
 * Created by cedaniel200 on 06/07/2016.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
