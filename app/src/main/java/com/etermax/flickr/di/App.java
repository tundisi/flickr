package com.etermax.flickr.di;

import android.app.Application;

import com.etermax.flickr.di.modules.ApplicationModule;

/**
 * Created by Luis Tundisi on 01/04/2017.
 */

public class App extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
