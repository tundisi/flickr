package com.etermax.flickr.di;

import com.etermax.flickr.di.component.DaggerTestApplicationComponent;
import com.etermax.flickr.di.component.TestApplicationComponent;
import com.etermax.flickr.di.components.ApplicationComponent;
import com.etermax.flickr.di.components.DaggerApplicationComponent;
import com.etermax.flickr.di.modules.ApplicationModule;
import com.etermax.flickr.di.modules.MockControllerModule;
import com.etermax.flickr.di.modules.TestAndroidModule;

/**
 * Created by Luis Tundisi on 08/04/2017.
 */

public class AppTest extends App {

    private TestApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
        component = DaggerTestApplicationComponent.builder().mockControllerModule(new MockControllerModule())
                .testAndroidModule(new TestAndroidModule(this))
                .build();
    }

    @Override
    protected void initializeInjector() {
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getAppTest() {
        return component;
    }

    public TestApplicationComponent getTestComponent() {
        if (component == null) {
            component = DaggerTestApplicationComponent.builder()
                    .testAndroidModule(new TestAndroidModule(this))
                    .mockControllerModule(new MockControllerModule()).build();

        }
        return component;
    }
}
