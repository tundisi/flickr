package com.etermax.flickr.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.etermax.flickr.R;
import com.etermax.flickr.data.models.Photo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Luis Tundisi on 01/04/2017.
 */

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.ViewHolder> {
    private final Context context;
    private ArrayList<Photo> photos;
    PhotosAdapterView photosAdapterViewListener;
    Photo photo;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivPhoto)
        ImageView ivPhoto;

        public ViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void addNewArrayListPhotos(ArrayList<Photo> photos){
        this.photos.addAll(photos);
        notifyDataSetChanged();
    }

    public PhotosAdapter(ArrayList<Photo> photos, Context context, PhotosAdapterView photosAdapterViewListener) {
        this.photos = photos;
        this.context = context;
        this.photosAdapterViewListener = photosAdapterViewListener;
    }

    @Override
    public PhotosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photos_adapter, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.anim_interpolar));
        Photo photo = photos.get(position);
        Glide.with(context).load("https://farm"+photo.getFarm()+".staticflickr.com/"+photo.getServer()+"/"+photo.getId()+"_"+photo.getSecret()+".jpg").centerCrop().crossFade().into(holder.ivPhoto);
        holder.ivPhoto.setOnClickListener((View view)-> {
            photosAdapterViewListener.itemSelected(photo);
        });
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }


}

