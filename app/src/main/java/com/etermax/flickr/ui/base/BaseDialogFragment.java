package com.etermax.flickr.ui.base;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.etermax.flickr.R;
import com.etermax.flickr.di.components.ApplicationComponent;

import butterknife.ButterKnife;

/**
 * Created by Luis Tundisi on 06/04/2017.
 */

public abstract class BaseDialogFragment extends DialogFragment {

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
        ButterKnife.bind(this, view);
        onViewReady(inflater, container, savedInstanceState, view);
        return view;
    }

    public ApplicationComponent getApplicationComponent() {
        return this.activity.getApplicationComponent();
    }

    protected void showProgressDialog(String msg) {
        activity.showProgressDialog(msg);
    }

    protected void showProgressDialog(int resMsg) {
        activity.showProgressDialog(getString(resMsg));
    }

    public void simpleToast(String msg){
        activity.simpleToast(msg);
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

    // Push Dialog
    public void pushFragment(DialogFragment dialogFragment){
        activity.pushFragment(dialogFragment);
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

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
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
        return context;
    }
}
