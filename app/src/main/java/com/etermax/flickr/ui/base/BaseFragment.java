package com.etermax.flickr.ui.base;

import android.app.DialogFragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ArrayRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.etermax.flickr.R;
import com.etermax.flickr.di.components.ApplicationComponent;
import com.etermax.flickr.utils.Constant;

import butterknife.ButterKnife;

/**
 * Created by Luis Tundisi on 01/04/2017.
 */

public abstract class BaseFragment extends Fragment {
    private static final String TAG = BaseFragment.class.getSimpleName();
    private boolean haveToolbar;
    private Toolbar mToolbar;
    private int typeToolbar = Constant.TOOLBAR_STANDARD;
    private TextView tvTitle;
    private BaseActivity activity;
    private Context context;

    abstract public int getLayoutView();

    abstract public void onViewReady(LayoutInflater inflater, @Nullable ViewGroup container,
                                     @Nullable Bundle savedInstanceState, View view);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (BaseActivity) getActivity();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setHasOptionsMenu(true);
        View view = inflater.inflate(getLayoutView(), container, false);
        ((BaseActivity) getActivity()).getApplicationComponent().inject(this);
        if (haveToolbar) {
            onCreateToolbar(view , typeToolbar);
        }
        ButterKnife.bind(this, view);
        onViewReady(inflater, container, savedInstanceState, view);
        return view;
    }

    public ApplicationComponent getApplicationComponent() {
        return this.activity.getApplicationComponent();
    }

    protected void setTitle(int resId) {
        setTitle(getContext().getString(resId));
    }

    protected void setTitle(String title) {
        if (haveToolbar) {
            mToolbar.setTitle("");
            mToolbar.setSubtitle("");
            tvTitle.setText(title);
        } else {
            activity.setTitle(title);
        }
    }

    // Add Fragment
    protected void showFragment(Fragment fragment) {
        activity.showFragment(fragment, false);
    }

    // Add Fragment
    protected void showFragment(Fragment fragment, boolean backstag) {
        activity.showFragment(fragment, backstag);
    }

    // Replace Fragment
    protected void pushFragment(Fragment fragment) {
        activity.pushFragment(fragment, R.id.container, true);
    }

    // Replace Fragment
    protected void pushFragment(Fragment fragment, boolean b) {
        activity.pushFragment(fragment, R.id.container, b);
    }

    public void pushFragment(DialogFragment dialogFragment){
        activity.pushFragment(dialogFragment);
    }

    public void pushFragment(DialogFragment dialogFragment, boolean cancelable){
        activity.pushFragment(dialogFragment,cancelable);
    }

    public void onCreateToolbar(View view, int typeToolbar) {
        try {
            switch (typeToolbar){
                case Constant.TOOLBAR_STANDARD:
                    Log.d("-->","standar");
                    mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
                    break;
                case Constant.TOOLBAR_DETAIL:
                    Log.d("-->","detail");
                    mToolbar = (Toolbar) view.findViewById(R.id.toolbar_detail);;
                    break;
            }
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            setToolBar(mToolbar);
        } catch (Exception e) {
            haveToolbar = false;
        }
    }

    public boolean onBackToolbar() {
        return false;
    }

    public boolean onBackPressed() {
        return false;
    }

    public void closeDrawer() {
        activity.closeDrawer();
    }

    public void openDrawer() {
        activity.openDrawer();
    }

    public boolean isOpenDrawerLayout() {
        return activity.isOpenDrawerLayout();
    }

    protected void showProgressDialog(String msg) {
        activity.showProgressDialog(msg);
    }

    public void dismissProgressDialog() {
        activity.dismissProgressDialog();
    }

    protected void showProgressDialog(int resMsg) {
        activity.showProgressDialog(getString(resMsg));
    }

    public void setHaveToolbar(boolean haveToolbar, int typeToolbar) {
        setHaveToolbar(haveToolbar);
        this.typeToolbar = typeToolbar;
    }

    public void setHaveToolbar(boolean haveToolbar) {
        this.haveToolbar = haveToolbar;
    }

    public void setToolBar(Toolbar toolBar) {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity != null) {
            mToolbar = toolBar;
            ((BaseActivity) getActivity()).setSupportActionBar(toolBar);
            activity.hideToolbar();
            setHaveToolbar(true);
        }
    }

    public void setEnableBackToolbar(boolean enable) {
        if (activity.getSupportActionBar() != null) {
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(enable);
            activity.getSupportActionBar().setDisplayShowHomeEnabled(enable);
            if (mToolbar != null && enable)
                mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        }
    }

    public void simpleToast(String msg) {
        activity.simpleToast(msg);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (haveToolbar) {
            activity.hideToolbar();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (haveToolbar && !haveToolbarLastFragment()) {
            activity.showToolbar();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.context = null;
    }

    @Override
    public Context getContext() {
        return this.context;
    }

    public String getLastTagFragment() {
        return activity.getLastTagFragment();
    }

    public boolean haveToolbarLastFragment() {
        String tag = getLastTagFragment();
        BaseFragment baseFragment = activity.findFragmentByTag(tag);
        return baseFragment != null && (!tag.isEmpty() && baseFragment.haveToolbar);
    }

    protected void goBack(int number) {
        activity.goBack(number);
    }

    protected void goBack() {
        activity.goBack();
    }

    public void finishActivity() {
        activity.finish();
    }


    public void showOptionDialog(@NonNull @StringRes int resTitle, @NonNull @ArrayRes int resArray,
                                 DialogInterface.OnClickListener listener) {
        if (activity != null) {
            activity.showOptionDialog(resTitle, resArray, listener);
        }
    }

    public ComponentName startService(Intent intent){
        return activity.startService(intent);
    }


}
