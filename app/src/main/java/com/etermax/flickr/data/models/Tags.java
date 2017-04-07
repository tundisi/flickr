package com.etermax.flickr.data.models;

import java.util.ArrayList;

/**
 * Created by Ale on 03/04/2017.
 */

public class Tags {
    ArrayList<Tag> tag;

    public Tags(ArrayList<Tag> tags) {
        this.tag = tags;
    }

    public ArrayList<Tag> getTags() {
        return tag;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tag = tags;
    }
}
