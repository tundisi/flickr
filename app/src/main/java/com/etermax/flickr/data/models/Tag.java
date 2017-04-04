package com.etermax.flickr.data.models;

/**
 * Created by Ale on 03/04/2017.
 */

public class Tag {
    String id;
    String author;
    String authorname;
    String _content;

    public Tag(String id, String author, String authorname, String _content) {
        this.id = id;
        this.author = author;
        this.authorname = authorname;
        this._content = _content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String get_content() {
        return _content;
    }

    public void set_content(String _content) {
        this._content = _content;
    }
}
