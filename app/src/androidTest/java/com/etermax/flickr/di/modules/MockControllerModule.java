package com.etermax.flickr.di.modules;

import com.etermax.flickr.api.controllers.PersonController;
import com.etermax.flickr.api.controllers.PhotosController;
import com.etermax.flickr.api.services.PersonApi;
import com.etermax.flickr.api.services.PhotosApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.spy;

/**
 * Created by Luis Tundisi on 08/04/2017.
 */

@Module
public class MockControllerModule {

    @Provides
    @Singleton
    PhotosController photosController(PhotosApi photosApi) {
        return spy(new PhotosController(photosApi));
    }


    @Provides
    @Singleton
    PersonController personController(PersonApi personApi) {
        return spy(new PersonController(personApi));
    }
}
