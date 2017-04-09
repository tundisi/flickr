package com.etermax.flickr.ui.base;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.ArrayRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.etermax.flickr.R;
import com.etermax.flickr.di.App;
import com.etermax.flickr.di.components.ApplicationComponent;

import java.util.ArrayList;

import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Luis Tundisi on 01/04/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private final String TAG = BaseActivity.class.getSimpleName();
    private boolean haveToolbar;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ProgressDialog progressDialog;
    private AlertDialog alertDialog = null;

    protected ArrayList<String> mTagFragments;
    protected FragmentManager fm;

    abstract public int getLayout();
    abstract public void onCreateView(Bundle savedInstanceState);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm = getSupportFragmentManager();
        mTagFragments = new ArrayList<>();
        setContentView(getLayout());
        ButterKnife.bind(this);
        onCreateView(savedInstanceState);
    }

    public ApplicationComponent getApplicationComponent() {
        return ((App) getApplication()).getApplicationComponent();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    // Add Fragment

    public void showFragment(Fragment fragment) {
        showFragment(fragment, R.id.container, true);
    }

    public void showFragment(Fragment fragment, boolean backStack) {
        showFragment(fragment, R.id.container, backStack);
    }

    public void showFragment(Fragment fragment, int container, boolean addBackStack) {
        FragmentTransaction transaction = fm.beginTransaction();
        String tag = fragment.getClass().getSimpleName();

        if (addBackStack) {
            transaction.addToBackStack(tag);
        }
        transaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
        transaction.add(container, fragment, tag);
        try {
            transaction.commit();
        } catch (Exception e) {
            return;
        }
        if((mTagFragments.size() == 0 )|| addBackStack){
            mTagFragments.add(tag);
        }
    }

    // End Add Fragment

    // Replace Fragment

    public void pushFragment(Fragment fragment) {
        pushFragment(fragment, R.id.container, true);
    }

    public void pushFragment(Fragment fragment, boolean backStack) {
        pushFragment(fragment, R.id.container, backStack);
    }

    public void pushFragment(Fragment fragment, int container, boolean addBackStack) {
        FragmentTransaction transaction = fm.beginTransaction();
        String tag = fragment.getClass().getSimpleName();

        if (addBackStack) {
            transaction.addToBackStack(tag);
        }
        transaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
        transaction.replace(container, fragment, tag);
        try {
            transaction.commit();
        } catch (Exception e) {
            return;
        }
        if((mTagFragments.size() == 0 )|| addBackStack){
            mTagFragments.add(tag);
        }
    }

    // End Replace Fragment

    // Push Dialogs

    public void pushFragment(DialogFragment dialogFragment){
        dialogFragment.show(getFragmentManager(),dialogFragment.getTag());
    }

    public void pushFragment(DialogFragment dialogFragment, boolean cancelable){
        dialogFragment.setCancelable(cancelable);
        dialogFragment.show(getFragmentManager(),dialogFragment.getTag());
    }


    public void setToolbar(Toolbar toolBar) {
        if (toolBar != null) {
            setSupportActionBar(toolBar);
            mToolbar = toolBar;
            haveToolbar = true;
        }
    }

    public void showToolbar() {
        if ((getSupportActionBar() != null) && haveToolbar) {
            setToolbar(mToolbar);
            mToolbar.setVisibility(View.VISIBLE);
        }
    }

    public void hideToolbar() {
        if ((getSupportActionBar() != null) && haveToolbar) {
            mToolbar.setVisibility(View.GONE);
        }
    }

    public void setDrawer(DrawerLayout mDrawerLayout, ListView mDrawerList) {
        this.mDrawerLayout = mDrawerLayout;
        this.mDrawerList = mDrawerList;
    }


    public void closeDrawer(){
        if(this.mDrawerLayout!=null&&isOpenDrawerLayout()){
            this.mDrawerLayout.closeDrawer(mDrawerList);
            this.mDrawerLayout.closeDrawers();
        }
    }

    public void openDrawer(){
        if(mDrawerLayout!=null&&!isOpenDrawerLayout())
            this.mDrawerLayout.openDrawer(this.mDrawerList);
    }

    public void simpleToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public boolean isOpenDrawerLayout(){
        return mDrawerLayout.isActivated();
    }

    public void goBack(int number) {
        if(number < 0){
            throw new RuntimeException("Error number back");
        }
        for (int i=0;i<number;i++){
            goBack();
        }
    }

    public void goBack() {
        if (mTagFragments.size() > 0) {
            mTagFragments.remove(mTagFragments.size() - 1);
            fm.popBackStackImmediate();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            if (mTagFragments.size() > 0) {
                Fragment fragment = fm.findFragmentByTag(mTagFragments.get(mTagFragments.size() - 1));
                if (fragment instanceof BaseFragment) {
                    BaseFragment base = (BaseFragment) fragment;
                    if (base.onBackToolbar()) {
                        return true;
                    }
                }
            }
            goBack();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public void onBackPressed() {
        if (mTagFragments.size() > 0) {
            Fragment fragment = fm.findFragmentByTag(mTagFragments.get(mTagFragments.size() - 1));
            if (fragment instanceof BaseFragment) {
                BaseFragment base = (BaseFragment) fragment;
                if (base.onBackPressed()) {
                    return;
                }
            }
            mTagFragments.remove(mTagFragments.size() - 1);
        }
        super.onBackPressed();
    }

    public String getLastTagFragment() {
        if (mTagFragments.size() == 0) {
            return "";
        } else {
            return mTagFragments.get(mTagFragments.size() - 1);
        }
    }

    public BaseFragment findFragmentByTag(String tag){
        try{
            return (BaseFragment) fm.findFragmentByTag(tag);
        }catch (Exception e){
            return null;
        }
    }

    public void showOptionDialog(@NonNull @StringRes int resTitle , @NonNull @ArrayRes int resArray,
                                 DialogInterface.OnClickListener listener) {
        final CharSequence[] items = getResources().getStringArray(resArray);
        showOptionDialog(getResources().getString(resTitle), items, listener);
    }

    public void showOptionDialog(String title , CharSequence[] items, final DialogInterface.OnClickListener listener) {
        try{
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this, R.style.MyDialogTheme);
            builder.setTitle(title);
            builder.setItems(items, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    listener.onClick(dialogInterface, i);
                    dialogInterface.dismiss();
                    alertDialog = null;
                }
            });
            alertDialog = builder.create();
            alertDialog.show();
        } catch(Exception e){

        }
    }

    public boolean hasPermissions(String... permissions) {
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(getApplicationContext(),
                    permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    public void showProgressDialog(int resMsg) {
        showProgressDialog(getString(R.string.app_name), getString(resMsg), false);
    }

    public void showProgressDialog(String msg) {
        showProgressDialog(getString(R.string.app_name), msg, false);
    }

    public void showProgressDialog(int resMsg, boolean cancelable) {
        showProgressDialog(getString(R.string.app_name), getString(resMsg), cancelable);
    }

    public void showProgressDialog(String msg, boolean cancelable) {
        showProgressDialog(getString(R.string.app_name), msg, cancelable);
    }

    public void showProgressDialog(String title, String msg, boolean cancelable) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this,R.style.MyDialogTheme);
            progressDialog.setProgressStyle(R.style.MyDialogTheme);
            progressDialog.setCancelable(cancelable);
            progressDialog.setTitle(title);
            progressDialog.setMessage(msg);
            progressDialog.show();
        }
    }

    public void dismissProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissProgressDialog();
    }
}
