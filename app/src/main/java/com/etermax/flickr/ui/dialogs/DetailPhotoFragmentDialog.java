package com.etermax.flickr.ui.dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.etermax.flickr.R;
import com.etermax.flickr.data.models.PhotoDetail;
import com.etermax.flickr.ui.base.BaseDialogFragment;
import com.etermax.flickr.utils.GlideUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Luis Tundisi on 06/04/2017.
 */

public class DetailPhotoFragmentDialog extends BaseDialogFragment{

    @BindView(R.id.ivPhoto)
    ImageView ivPhoto;
    private PhotoDetail photoDetail;

    public static DetailPhotoFragmentDialog newInstance(PhotoDetail photoDetail) {
        DetailPhotoFragmentDialog fragment = new DetailPhotoFragmentDialog();
        fragment.photoDetail = photoDetail;
        return fragment;
    }

    @Override
    public int getLayoutView() {
        return R.layout.fragment_dialog_detail_photo;
    }

    @Override
    public void onViewReady(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState, View view) {
        GlideUtils.setPhotoFromApiInImageView(getContext(),photoDetail,ivPhoto);
    }

    @OnClick(R.id.ivClose)
    public void closeDialog(){
        dismissAllowingStateLoss();
    }
}
