package com.etermax.flickr.data.models;

/**
 * Created by Ale on 03/04/2017.
 */

public class Owner {
    String nsid;
    String username;
    String realname;
    String location;
    String iconserver;
    int iconfarm;

    public Owner(String nsid, String username, String realname, String location, String iconserver, int iconfarm) {
        this.nsid = nsid;
        this.username = username;
        this.realname = realname;
        this.location = location;
        this.iconserver = iconserver;
        this.iconfarm = iconfarm;
    }

    public Owner() {
    }

    public String getNsid() {
        return nsid;
    }

    public void setNsid(String nsid) {
        this.nsid = nsid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIconserver() {
        return iconserver;
    }

    public void setIconserver(String iconserver) {
        this.iconserver = iconserver;
    }

    public int getIconfarm() {
        return iconfarm;
    }

    public void setIconfarm(int iconfarm) {
        this.iconfarm = iconfarm;
    }
}
