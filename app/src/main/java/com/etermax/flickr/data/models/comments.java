package com.etermax.flickr.data.models;

/**
 * Created by Ale on 03/04/2017.
 */

public class Comments {
    int _content;

    public Comments(int _content) {
        this._content = _content;
    }

    public Comments() {
    }

    public int get_content() {
        return _content;
    }

    public void set_content(int _content) {
        this._content = _content;
    }
}
