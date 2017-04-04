package com.etermax.flickr.data.response;

import com.etermax.flickr.data.models.Photos;

/**
 * Created by Ale on 01/04/2017.
 */

public class PhotosResponse {
    Photos photos;

    public PhotosResponse(Photos photos) {
        this.photos = photos;
    }

    public PhotosResponse() {
    }

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }
}
