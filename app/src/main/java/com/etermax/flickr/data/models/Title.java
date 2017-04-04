package com.etermax.flickr.data.models;

/**
 * Created by Ale on 03/04/2017.
 */

public class Title {
    String _content;

    public Title(String _content) {
        this._content = _content;
    }

    public String get_content() {
        return _content;
    }

    public void set_content(String _content) {
        this._content = _content;
    }
}
