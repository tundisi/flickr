package com.etermax.flickr.data.response;

import com.etermax.flickr.data.models.Person;

/**
 * Created by Ale on 04/04/2017.
 */

public class PersonResponse {
    Person person;

    public PersonResponse(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
