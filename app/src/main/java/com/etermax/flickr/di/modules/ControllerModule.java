package com.etermax.flickr.di.modules;

import com.etermax.flickr.api.controllers.PhotosController;
import com.etermax.flickr.api.services.PhotosApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Luis Tundisi on 01/04/2017.
 */

@Module
public class ControllerModule {

    @Provides
    @Singleton
    PhotosController photosController(PhotosApi photosApi) {
        return new PhotosController(photosApi);
    }

}
