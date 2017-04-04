package com.etermax.flickr.api.services;

import com.etermax.flickr.data.response.PersonResponse;
import com.etermax.flickr.utils.Constant;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Ale on 04/04/2017.
 */

public interface PersonApi {

    @GET("services/rest/?method=flickr.people.getInfo&api_key="+ Constant.API_KEY+"&format=json&nojsoncallback=1")
    Observable<PersonResponse> getProfileById(@Query("user_id") String user_id);
}
