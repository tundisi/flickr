package com.etermax.flickr.api.controllers;

import com.etermax.flickr.api.services.PhotosApi;
import com.etermax.flickr.data.models.PhotosResponse;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Luis Tundisi on 01/04/2017.
 */

public class PhotosController {
    PhotosApi photosApi;

    public PhotosController(PhotosApi photosApi){
        this.photosApi = photosApi;
    }


    public Observable<PhotosResponse> getPhotos() {
        return photosApi.getPhotosRecently().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<PhotosResponse> getPhotosSearch(String text, int page) {
        return photosApi.getPhotosByText(text, page).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
