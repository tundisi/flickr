package com.etermax.flickr.ui.modules.detailPhoto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.etermax.flickr.R;
import com.etermax.flickr.api.controllers.PersonController;
import com.etermax.flickr.data.models.Person;
import com.etermax.flickr.data.models.PhotoDetail;
import com.etermax.flickr.ui.base.BaseFragment;
import com.etermax.flickr.ui.dialogs.DetailPhotoFragmentDialog;
import com.etermax.flickr.ui.modules.profile.ProfileFragment;
import com.etermax.flickr.utils.Constant;
import com.etermax.flickr.utils.DateUtils;
import com.etermax.flickr.utils.GlideUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import me.gujun.android.taggroup.TagGroup;

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
    @BindView(R.id.cvTags)
    CardView cvTags;

    @BindView(R.id.tag_group)
    TagGroup tagGroup;

    PhotoDetail photoDetail;

    @Inject
    PersonController personController;

    DetailPhotoPresenter detailPhotoPresenter;

    public static DetailPhotoFragment newInstance(PhotoDetail photoDetail) {
        DetailPhotoFragment fragment = new DetailPhotoFragment();
        fragment.photoDetail = photoDetail;
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHaveToolbar(true, Constant.TOOLBAR_DETAIL);
        setHasOptionsMenu(true);
    }

    @Override
    public int getLayoutView() {
        return R.layout.fragment_detail_photo;
    }

    @Override
    public void onViewReady(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState, View view) {
        setEnableBackToolbar(true);
        getApplicationComponent().inject(this);
        detailPhotoPresenter = new DetailPhotoPresenter(personController,this);
        inicialize();
    }

    public void inicialize(){
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


        if(photoDetail.getTags().getTags()!=null) {
            if(photoDetail.getTags().getTags().size()!=0) {
                String[] tags = new String[photoDetail.getTags().getTags().size()];
                for (int i = 0; i < photoDetail.getTags().getTags().size(); i++)
                    tags[i] = photoDetail.getTags().getTags().get(i).get_content();
                tagGroup.setTags(tags);
            }else
                cvTags.setVisibility(View.GONE);
        }else
            cvTags.setVisibility(View.GONE);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }

    @OnClick({R.id.ivPhotoProfile, R.id.tvNameProfile, R.id.ivPhoto})
    public void onClick(View view){
        if(view.getId()!=R.id.ivPhoto) {
            showProgressDialog(R.string.loading);
            goBack();
            detailPhotoPresenter.getProfileById(photoDetail.getOwner().getNsid());
        }else{
            pushFragment(DetailPhotoFragmentDialog.newInstance(photoDetail));
        }
    }

    @Override
    public void goToProfile(Person person) {
        dismissProgressDialog();
        showFragment(ProfileFragment.newInstance(person), true);
    }

    @Override
    public void onError() {
        dismissProgressDialog();
        simpleToast(getString(R.string.network_error));
    }
}
