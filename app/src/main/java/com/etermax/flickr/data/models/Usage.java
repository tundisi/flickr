package com.etermax.flickr.data.models;

/**
 * Created by Ale on 03/04/2017.
 */

public class Usage {
    int candownload;
    int canprint;
    int canshare;

    public Usage(int candownload, int canprint, int canshare) {
        this.candownload = candownload;
        this.canprint = canprint;
        this.canshare = canshare;
    }

    public Usage() {
    }

    public int getCandownload() {
        return candownload;
    }

    public void setCandownload(int candownload) {
        this.candownload = candownload;
    }

    public int getCanprint() {
        return canprint;
    }

    public void setCanprint(int canprint) {
        this.canprint = canprint;
    }

    public int getCanshare() {
        return canshare;
    }

    public void setCanshare(int canshare) {
        this.canshare = canshare;
    }
}
