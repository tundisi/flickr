package com.etermax.flickr.ui.modules.detailPhoto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.etermax.flickr.R;
import com.etermax.flickr.ui.base.BaseFragment;

/**
 * Created by Luis Tundisi on 02/04/2017.
 */

public class DetailPhotoFragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHaveToolbar(true);
        setEnableBackToolbar(true);
    }

    @Override
    public int getLayoutView() {
        return R.layout.fragment_detail_photo;
    }

    @Override
    public void onViewReady(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState, View view) {

    }
}
