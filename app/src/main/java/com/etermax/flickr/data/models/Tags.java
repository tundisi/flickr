package com.etermax.flickr.data.models;

import java.util.ArrayList;

/**
 * Created by Ale on 03/04/2017.
 */

public class Tags {
    ArrayList<Tag> tags;

    public Tags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }
}
