package com.etermax.flickr.ui.modules.profile;

import com.etermax.flickr.api.controllers.PhotosController;
import com.etermax.flickr.data.response.PhotoDetailResponse;
import com.etermax.flickr.data.response.PhotosResponse;

/**
 * Created by Ale on 04/04/2017.
 */

public class ProfileFragmentPresenter {

    PhotosController photosController;

    ProfileFragmentView profileFragmentViewListener;

    public ProfileFragmentPresenter(PhotosController photosController, ProfileFragmentView profileFragmentViewListener) {
        this.photosController = photosController;
        this.profileFragmentViewListener = profileFragmentViewListener;
    }

    public void getPhotosByIdPerson(String id,int page){
        photosController.getPhotosByIdPerson(id,page).subscribe(this::onSuccessPhotosPerson , this::onFailure);
    }


    public void getPhotosById(String id){
        photosController.getPhotoById(id).subscribe(this::onSuccessPhoto , this::onFailure);
    }

    public void onSuccessPhoto(PhotoDetailResponse photoDetailResponse){
        profileFragmentViewListener.goToFragmentDetailPhoto(photoDetailResponse.getPhoto());
    }

    public void onSuccessPhotosPerson(PhotosResponse photosResponse){
        profileFragmentViewListener.setPhotosAdapter(photosResponse.getPhotos().getPhoto());
    }

    public void onFailure(Throwable throwable){
        profileFragmentViewListener.onFailure();
    }
}
