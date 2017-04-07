package com.etermax.flickr.ui.modules.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.etermax.flickr.R;
import com.etermax.flickr.api.controllers.PhotosController;
import com.etermax.flickr.data.models.Person;
import com.etermax.flickr.data.models.Photo;
import com.etermax.flickr.data.models.PhotoDetail;
import com.etermax.flickr.ui.adapters.PhotosAdapter;
import com.etermax.flickr.ui.adapters.PhotosAdapterView;
import com.etermax.flickr.ui.base.BaseFragment;
import com.etermax.flickr.ui.modules.detailPhoto.DetailPhotoFragment;
import com.etermax.flickr.utils.Constant;
import com.etermax.flickr.utils.GlideUtils;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Luis Tundisi on 04/04/2017.
 */

public class ProfileFragment extends BaseFragment implements ProfileFragmentView, PhotosAdapterView {
    public static String TAG = ProfileFragment.class.getSimpleName();
    private Person person;

    @BindView(R.id.ivPhotoProfile)
    ImageView ivPhotoProfile;

    @BindView(R.id.tvNameProfile)
    TextView tvNameProfile;
    @BindView(R.id.tvDescription)
    TextView tvDescription;
    @BindView(R.id.tvCountPicture)
    TextView tvCountPicture;
    @BindView(R.id.tvDateFirstPicture)
    TextView tvDateFirstPicture;

    @BindView(R.id.rvPhotos)
    RecyclerView rvPhotos;

    @Inject
    PhotosController photosController;

    ProfileFragmentPresenter profileFragmentPresenter;
    private PhotosAdapter mAdapter;
    private GridLayoutManager gridLayoutManager;

    public static ProfileFragment newInstance(Person person) {
        ProfileFragment fragment = new ProfileFragment();
        fragment.person = person;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHaveToolbar(true);
        setHasOptionsMenu(true);
    }

    @Override
    public int getLayoutView() {
        return R.layout.fragment_profile;
    }

    @Override
    public void onViewReady(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState, View view) {
        initializeView();
        showProgressDialog(R.string.loading);
        profileFragmentPresenter = new ProfileFragmentPresenter(photosController,this);
        profileFragmentPresenter.getPhotosByIdPerson(person.getNsid(), Constant.DEFAULT_PAGE);
    }

    public void initializeView(){
        setEnableBackToolbar(true);
        getApplicationComponent().inject(this);
        setTitle(R.string.profile);
        gridLayoutManager = new GridLayoutManager(getContext(), 3);
        rvPhotos.setLayoutManager(gridLayoutManager);
        GlideUtils.setPhotoProfileFromApiInImageView(getContext(),person,ivPhotoProfile);
        tvNameProfile.setText(person.getRealname().get_content().isEmpty() ? person.getUsername().get_content() : person.getRealname().get_content());
        if(person.getDescription().get_content()!=null)
            tvDescription.setText(person.getDescription().get_content());
        else
            tvDescription.setVisibility(View.GONE);

        tvCountPicture.setText(String.valueOf(person.getPhotos().getCount().get_content()));;
        tvDateFirstPicture.setText(person.getPhotos().getFirstdatetaken().get_content());
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }


    @Override
    public void setPhotosAdapter(ArrayList<Photo> photos) {
        dismissProgressDialog();
        mAdapter = new PhotosAdapter(photos, getContext(),this);
        rvPhotos.setAdapter(mAdapter);
    }

    @Override
    public void goToFragmentDetailPhoto(PhotoDetail photoDetail) {
        dismissProgressDialog();
        showFragment(DetailPhotoFragment.newInstance(photoDetail),true);
    }

    @Override
    public void onFailure() {
        dismissProgressDialog();
        simpleToast(getString(R.string.network_error));
    }

    @Override
    public void itemSelected(Photo photo) {
        showProgressDialog(R.string.loading);
        goBack();
        profileFragmentPresenter.getPhotosById(photo.getId());
    }
}
