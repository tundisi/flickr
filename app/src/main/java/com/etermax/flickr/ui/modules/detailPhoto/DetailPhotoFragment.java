package com.etermax.flickr.ui.modules.detailPhoto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.etermax.flickr.R;
import com.etermax.flickr.data.models.PhotoDetail;
import com.etermax.flickr.ui.base.BaseFragment;
import com.etermax.flickr.utils.DateUtils;
import com.etermax.flickr.utils.GlideUtils;

import butterknife.BindView;

/**
 * Created by Luis Tundisi on 02/04/2017.
 */

public class DetailPhotoFragment extends BaseFragment implements DetailPhotoView {

    @BindView(R.id.ivPhotoProfile)
    ImageView ivPhotoProfile;
    @BindView(R.id.ivPhoto)
    ImageView ivPhoto;
    @BindView(R.id.tvNameProfile)
    TextView tvNameProfile;
    @BindView(R.id.tvNamePhoto)
    TextView tvNamePhoto;
    @BindView(R.id.tvDescription)
    TextView tvDescription;
    @BindView(R.id.tvPublished)
    TextView tvPublished;
    @BindView(R.id.tvTaken)
    TextView tvTaken;
    @BindView(R.id.tvDowloaded)
    TextView tvDowloaded;
    @BindView(R.id.tvPrinted)
    TextView tvPrinted;
    @BindView(R.id.tvShared)
    TextView tvShared;
    @BindView(R.id.tvTakenBy)
    TextView tvTakenBy;
    @BindView(R.id.cvDescription)
    CardView cvDescription;



    PhotoDetail photoDetail;


    public static DetailPhotoFragment newInstance(PhotoDetail photoDetail) {
        DetailPhotoFragment fragment = new DetailPhotoFragment();
        fragment.photoDetail = photoDetail;
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHaveToolbar(true);
    }

    @Override
    public int getLayoutView() {
        return R.layout.fragment_detail_photo;
    }

    @Override
    public void onViewReady(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState, View view) {
        setEnableBackToolbar(true);
        GlideUtils.setPhotoFromApiInImageView(getContext(),photoDetail,ivPhoto);
        GlideUtils.setPhotoProfileFromApiInImageView(getContext(),photoDetail,ivPhotoProfile);
        tvNameProfile.setText(photoDetail.getOwner().getUsername());
        tvNamePhoto.setText(photoDetail.getTitle().get_content());
        if(photoDetail.getDescription().get_content().equals(""))
            cvDescription.setVisibility(View.GONE);
        else
            tvDescription.setText(photoDetail.getDescription().get_content());

        tvPublished.setText(DateUtils.getDateByTimeStamp(Long.parseLong(photoDetail.getDates().getPosted())));
        tvTaken.setText(photoDetail.getDates().getTaken());
        tvDowloaded.setText(String.valueOf(photoDetail.getUsage().getCandownload()));
        tvPrinted.setText(String.valueOf(photoDetail.getUsage().getCanprint()));
        tvShared.setText(String.valueOf(photoDetail.getUsage().getCanshare()));
        tvTakenBy.setText(photoDetail.getOwner().getUsername());
    }

    @Override
    public void setData() {

    }

    @Override
    public void onError(String error) {

    }
}
