package com.etermax.flickr.ui.modules.main;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.etermax.flickr.R;
import com.etermax.flickr.api.controllers.PhotosController;
import com.etermax.flickr.data.models.Photo;
import com.etermax.flickr.data.models.PhotoDetail;
import com.etermax.flickr.ui.adapters.PhotosAdapter;
import com.etermax.flickr.ui.base.BaseFragment;
import com.etermax.flickr.ui.modules.detailPhoto.DetailPhotoFragment;
import com.etermax.flickr.utils.Constant;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Luis Tundisi on 01/04/2017.
 */

public class MainFragment extends BaseFragment implements MainFragmentView, SearchView.OnQueryTextListener {

    @Inject
    PhotosController photosController;

    @BindView(R.id.rvPhotos)
    RecyclerView mRecyclerView;

    GridLayoutManager gridLayoutManager;
    PhotosAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    Menu menu;
    SearchView searchView;

    boolean isViewWithCatalog = true;

    MainFragmentPresenter mainFragmentPresenter;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
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
        return R.layout.fragment_main;
    }

    @Override
    public void onViewReady(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState, View view) {
        initialize();
        showProgressDialog(R.string.loading);
        mainFragmentPresenter.getPhotosRecently();
    }

    public void initialize(){
        getApplicationComponent().inject(this);
        mainFragmentPresenter = new MainFragmentPresenter(this , photosController);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        gridLayoutManager = new GridLayoutManager(getContext(), 3);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void setPhotosAdapter(ArrayList<Photo> photos) {
        dismissProgressDialog();
        mAdapter = new PhotosAdapter(photos,getContext(),this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onFailure() {
        dismissProgressDialog();
        simpleToast(getString(R.string.network_error));
    }

    @Override
    public void itemSelected(Photo photo) {
        showProgressDialog(R.string.loading);
        mainFragmentPresenter.getPhotoById(photo.getId());
        photosController.getPhotoById(photo.getId());
    }

    @Override
    public void goToFragmentDetailPhoto(PhotoDetail photoDetail) {
        dismissProgressDialog();
        pushFragment(DetailPhotoFragment.newInstance(photoDetail));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        inflater.inflate(R.menu.menu_home, menu);
        this.menu = menu;
        SearchManager searchManager = (SearchManager) getContext().getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setOnQueryTextListener(this);
        return;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.change_recycle) {
                isViewWithCatalog = !isViewWithCatalog;
                mRecyclerView.setLayoutManager(isViewWithCatalog ? mLayoutManager : gridLayoutManager);
                mRecyclerView.setAdapter(mAdapter);
                if(isViewWithCatalog)
                    menu.findItem(R.id.change_recycle).setIcon(ContextCompat.getDrawable(getContext(),R.drawable.ic_list));
                else
                    menu.findItem(R.id.change_recycle).setIcon(ContextCompat.getDrawable(getContext(),R.drawable.ic_grid_on));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        menu.findItem(R.id.search).collapseActionView();
        showProgressDialog(R.string.loading);
        mainFragmentPresenter.getPhotosSearch(query , Constant.DEFAULT_PAGE);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
