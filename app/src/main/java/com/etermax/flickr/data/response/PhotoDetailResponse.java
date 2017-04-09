package com.etermax.flickr.data.response;

import com.etermax.flickr.data.models.PhotoDetail;

/**
 * Created by Ale on 03/04/2017.
 */

public class PhotoDetailResponse {
    PhotoDetail photo;

    public PhotoDetailResponse(PhotoDetail photo) {
        this.photo = photo;
    }

    public PhotoDetailResponse() {
    }

    public PhotoDetail getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoDetail photo) {
        this.photo = photo;
    }
}
