package com.etermax.flickr.data.models;

/**
 * Created by Ale on 03/04/2017.
 */

public class PhotoDetail {
    String id;
    String secret;
    String server;
    int farm;
    int isfavorite;
    Owner owner;
    Title title;
    Description description;
    Dates dates;
    String views;
    Usage usage;
    Comments comments;
    Tags tags;

    public PhotoDetail(String id, String secret, String server, int farm, int isfavorite, Owner owner, Title title, Description description, Dates dates, String views, Usage usage, Comments comments, Tags tags) {
        this.id = id;
        this.secret = secret;
        this.server = server;
        this.farm = farm;
        this.isfavorite = isfavorite;
        this.owner = owner;
        this.title = title;
        this.description = description;
        this.dates = dates;
        this.views = views;
        this.usage = usage;
        this.comments = comments;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getFarm() {
        return farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    public int getIsfavorite() {
        return isfavorite;
    }

    public void setIsfavorite(int isfavorite) {
        this.isfavorite = isfavorite;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }
}
