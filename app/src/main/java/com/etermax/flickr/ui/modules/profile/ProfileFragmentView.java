package com.etermax.flickr.ui.modules.profile;

import com.etermax.flickr.data.models.Photo;
import com.etermax.flickr.data.models.PhotoDetail;

import java.util.ArrayList;

/**
 * Created by Ale on 04/04/2017.
 */

public interface ProfileFragmentView {
    void setPhotosAdapter(ArrayList<Photo> photos);
    void goToFragmentDetailPhoto(PhotoDetail photoDetail);
    void onFailure();
}
