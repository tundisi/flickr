package com.etermax.flickr.di.component;

import com.etermax.flickr.BaseTest;
import com.etermax.flickr.di.components.ApplicationComponent;
import com.etermax.flickr.di.modules.ApiModule;
import com.etermax.flickr.di.modules.ApplicationModule;
import com.etermax.flickr.di.modules.MockControllerModule;
import com.etermax.flickr.di.modules.TestAndroidModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Ale on 08/04/2017.
 */

@Singleton
@Component(
        modules = {
                TestAndroidModule.class,
                ApplicationModule.class,
                ApiModule.class,
                MockControllerModule.class,
        })

public interface TestApplicationComponent extends ApplicationComponent {

    void inject(BaseTest baseTest);

}
