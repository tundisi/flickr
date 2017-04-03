package com.etermax.flickr.data.models;

import java.util.ArrayList;

/**
 * Created by Luis Tundisi on 01/04/2017.
 */

public class Photos {
    int page;
    int pages;
    int perpage;
    int total;
    ArrayList<Photo> photo;

    public Photos(int page, int pages, int perpage, int total, ArrayList<Photo> photo) {
        this.page = page;
        this.pages = pages;
        this.perpage = perpage;
        this.total = total;
        this.photo = photo;
    }

    public Photos() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPerpage() {
        return perpage;
    }

    public void setPerpage(int perpage) {
        this.perpage = perpage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(ArrayList<Photo> photo) {
        this.photo = photo;
    }
}
