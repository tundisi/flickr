package com.etermax.flickr.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.etermax.flickr.R;
import com.etermax.flickr.data.models.PhotoDetail;

/**
 * Created by Ale on 03/04/2017.
 */

public class GlideUtils {

    public static void setPhotoFromApiInImageView(Context context, PhotoDetail photoDetail, ImageView imageView){
        Glide.with(context).load("https://farm"+photoDetail.getFarm()+".staticflickr.com/"+photoDetail.getServer()+"/"+photoDetail.getId()+"_"+photoDetail.getSecret()+".jpg").centerCrop().crossFade().into(imageView);
    }

    public static void setPhotoProfileFromApiInImageView(Context context, PhotoDetail photoDetail, ImageView imageView){
        Glide.with(context).load("https://farm"+photoDetail.getOwner().getIconfarm()+".staticflickr.com/"+photoDetail.getOwner().getIconserver()+"/buddyicons/"+photoDetail.getOwner().getNsid()+".jpg").asBitmap().centerCrop().error(ContextCompat.getDrawable(context, R.drawable.ic_account_circle)).into(new BitmapImageViewTarget(imageView) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                imageView.setImageDrawable(circularBitmapDrawable);
            }
        });
    }
}
