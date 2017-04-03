package com.etermax.flickr.api.services;


import com.etermax.flickr.data.models.PhotosResponse;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Luis Tundisi on 01/04/2017.
 */

public interface PhotosApi {

    @GET("services/rest/?method=flickr.photos.getRecent&api_key=ae8225a48bfe7ed6b3aafe65eb26ac41&per_page=10&format=json&nojsoncallback=1")
    Observable<PhotosResponse> getPhotosRecently();
}
