package com.etermax.flickr;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;

import com.etermax.flickr.api.controllers.PersonController;
import com.etermax.flickr.api.controllers.PhotosController;
import com.etermax.flickr.di.AppTest;
import com.etermax.flickr.di.component.TestApplicationComponent;

import org.junit.Before;
import org.junit.Rule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import javax.inject.Inject;

/**
 * Created by Ale on 08/04/2017.
 */

public abstract class BaseTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Inject
    public PersonController personController;

    @Inject
    public PhotosController photosController;


    @Before
    public void setUp() throws Exception {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        AppTest app = (AppTest) instrumentation.getTargetContext().getApplicationContext();
        TestApplicationComponent component = app.getTestComponent();
        component.inject(this);
        setMocks();
    }

    public void setMocks(){}
}
