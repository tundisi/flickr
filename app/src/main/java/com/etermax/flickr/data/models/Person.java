package com.etermax.flickr.data.models;

/**
 * Created by Luis Tundisi on 04/04/2017.
 */

public class Person {

    String id;
    String nsid;
    int ispro;
    int can_buy_pro;
    String iconserver;
    int iconfarm;
    String has_stats;
    Username username;
    Realname realname;
    Description description;
    DatePhotos photos;

    public Person(String id, String nsid, int ispro, int can_buy_pro, String iconserver, int iconfarm, String has_stats, Username username, Realname realname, Description description, DatePhotos photos) {
        this.id = id;
        this.nsid = nsid;
        this.ispro = ispro;
        this.can_buy_pro = can_buy_pro;
        this.iconserver = iconserver;
        this.iconfarm = iconfarm;
        this.has_stats = has_stats;
        this.username = username;
        this.realname = realname;
        this.description = description;
        this.photos = photos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNsid() {
        return nsid;
    }

    public void setNsid(String nsid) {
        this.nsid = nsid;
    }

    public int getIspro() {
        return ispro;
    }

    public void setIspro(int ispro) {
        this.ispro = ispro;
    }

    public int getCan_buy_pro() {
        return can_buy_pro;
    }

    public void setCan_buy_pro(int can_buy_pro) {
        this.can_buy_pro = can_buy_pro;
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

    public String getHas_stats() {
        return has_stats;
    }

    public void setHas_stats(String has_stats) {
        this.has_stats = has_stats;
    }

    public Username getUsername() {
        return username;
    }

    public void setUsername(Username username) {
        this.username = username;
    }

    public Realname getRealname() {
        return realname;
    }

    public void setRealname(Realname realname) {
        this.realname = realname;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public DatePhotos getPhotos() {
        return photos;
    }

    public void setPhotos(DatePhotos photos) {
        this.photos = photos;
    }
}
