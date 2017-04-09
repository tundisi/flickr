package com.etermax.flickr.di.modules;

import android.content.Context;

import com.etermax.flickr.di.AppTest;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ale on 08/04/2017.
 */

@Module
public class TestAndroidModule {

    private final AppTest application;

    public TestAndroidModule(AppTest application) {
        this.application = application;
    }

    @Singleton
    @Provides
    public Context providesContext(){
        return application;
    }

}
