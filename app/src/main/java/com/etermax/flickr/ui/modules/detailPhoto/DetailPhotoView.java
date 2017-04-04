package com.etermax.flickr.ui.modules.detailPhoto;

import com.etermax.flickr.data.models.Person;

/**
 * Created by Ale on 03/04/2017.
 */

public interface DetailPhotoView {
    void goToProfile(Person person);
    void onError();
}
