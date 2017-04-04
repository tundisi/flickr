package com.etermax.flickr.ui.modules.main;

import com.etermax.flickr.api.controllers.PhotosController;
import com.etermax.flickr.data.response.PhotoDetailResponse;
import com.etermax.flickr.data.response.PhotosResponse;

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

    public void getPhotosRecently(){
        photosController.getPhotos().subscribe(this::onSuccess , this::onFailure);
    }

    public void getPhotosSearch(String text,int page){
        photosController.getPhotosSearch(text,page).subscribe(this::onSuccess , this::onFailure);
    }

    public void onSuccess(PhotosResponse photosResponse){
        mainFragmentViewListener.setPhotosAdapter(photosResponse.getPhotos().getPhoto());
    }

    public void onFailure(Throwable throwable){
        mainFragmentViewListener.onFailure();
    }

    public void getPhotoById(String id){
        photosController.getPhotoById(id).subscribe(this::onSuccessDetail , this::onFailure);
    }

    public void onSuccessDetail(PhotoDetailResponse photoDetailResponse){
        mainFragmentViewListener.goToFragmentDetailPhoto(photoDetailResponse.getPhoto());
    }

}
