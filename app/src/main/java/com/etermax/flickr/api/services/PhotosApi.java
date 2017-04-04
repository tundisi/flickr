package com.etermax.flickr.api.services;


import com.etermax.flickr.data.models.PhotosResponse;
import com.etermax.flickr.utils.Constant;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Luis Tundisi on 01/04/2017.
 */

public interface PhotosApi {

    @GET("services/rest/?method=flickr.photos.getRecent&api_key=" + Constant.API_KEY + "&per_page=" + Constant.PER_PAGE + "&format=json&nojsoncallback=1")
    Observable<PhotosResponse> getPhotosRecently();

    @GET("services/rest/?method=flickr.photos.search&api_key=" + Constant.API_KEY + "&per_page="+Constant.PER_PAGE+"&format=json&nojsoncallback=1")
    Observable<PhotosResponse> getPhotosByText(@Query("text") String text, @Query("page") int page);
}
