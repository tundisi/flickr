package com.etermax.flickr.ui.modules.detailPhoto;

import com.etermax.flickr.api.controllers.PersonController;
import com.etermax.flickr.data.response.PersonResponse;

/**
 * Created by Luis Tundisi on 04/04/2017.
 */

public class DetailPhotoPresenter {

    PersonController personController;
    DetailPhotoView detailPhotoViewListener;

    public DetailPhotoPresenter(PersonController personController, DetailPhotoView detailPhotoViewListener) {
        this.personController = personController;
        this.detailPhotoViewListener = detailPhotoViewListener;
    }

    public void getProfileById(String id){
        personController.getProfileById(id).subscribe(this::onSuccessProfile , this::onFailure);
    }

    public void onSuccessProfile(PersonResponse person){
        detailPhotoViewListener.goToProfile(person.getPerson());
    }

    public void onFailure(Throwable throwable){
        detailPhotoViewListener.onError();
    }

}
