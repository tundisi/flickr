package com.etermax.flickr.data.models;

/**
 * Created by Ale on 04/04/2017.
 */

public class DatePhotos {
    FirsDateTaken firstdatetaken;
    Count count;

    public DatePhotos(FirsDateTaken firstdatetaken) {
        this.firstdatetaken = firstdatetaken;
    }

    public FirsDateTaken getFirstdatetaken() {
        return firstdatetaken;
    }

    public void setFirstdatetaken(FirsDateTaken firstdatetaken) {
        this.firstdatetaken = firstdatetaken;
    }

    public Count getCount() {
        return count;
    }

    public void setCount(Count count) {
        this.count = count;
    }
}
