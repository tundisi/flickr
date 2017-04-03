package com.etermax.flickr.ui.modules.main;

import com.etermax.flickr.api.controllers.PhotosController;
import com.etermax.flickr.data.models.PhotosResponse;

/**
 * Created by Luis Tundisi on 02/04/2017.
 */

public class MainFragmentPresenter {

    private PhotosController photosController;

    MainFragmentView mainFragmentViewListener;

    public MainFragmentPresenter(MainFragmentView mainFragmentViewListener, PhotosController photosController) {
        this.mainFragmentViewListener = mainFragmentViewListener;
        this.photosController = photosController;
    }

    public void getPhotos(){
        photosController.getPhotos().subscribe(this::onSuccess , this::onFailure);
    }

    public void onSuccess(PhotosResponse photosResponse){
        mainFragmentViewListener.setPhotosAdapter(photosResponse.getPhotos().getPhoto());
    }

    public void onFailure(Throwable throwable){
        mainFragmentViewListener.onFailure();
    }
}
