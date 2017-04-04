package com.etermax.flickr.api.controllers;

import com.etermax.flickr.api.services.PersonApi;
import com.etermax.flickr.data.response.PersonResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ale on 04/04/2017.
 */

public class PersonController {
    PersonApi personApi;

    public PersonController(PersonApi personApi) {
        this.personApi = personApi;
    }

    public Observable<PersonResponse> getProfileById(String id) {
        return personApi.getProfileById(id).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
