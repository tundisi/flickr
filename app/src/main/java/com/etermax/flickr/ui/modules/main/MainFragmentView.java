package com.etermax.flickr.ui.modules.main;

import com.etermax.flickr.data.models.Photo;
import com.etermax.flickr.data.models.PhotoDetail;

import java.util.ArrayList;

/**
 * Created by Ale on 01/04/2017.
 */

public interface MainFragmentView {
    void setPhotosAdapter(ArrayList<Photo> photos);
    void onFailure();
    void goToFragmentDetailPhoto(PhotoDetail photoDetail);
}
