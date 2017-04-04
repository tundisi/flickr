package com.etermax.flickr.data.models;

/**
 * Created by Ale on 03/04/2017.
 */

public class Dates {
    String posted;
    String taken;
    String lastupdate;

    public Dates(String posted, String taken, String lastupdate) {
        this.posted = posted;
        this.taken = taken;
        this.lastupdate = lastupdate;
    }

    public Dates() {
    }

    public String getPosted() {
        return posted;
    }

    public void setPosted(String posted) {
        this.posted = posted;
    }

    public String getTaken() {
        return taken;
    }

    public void setTaken(String taken) {
        this.taken = taken;
    }

    public String getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(String lastupdate) {
        this.lastupdate = lastupdate;
    }
}
