package com.etermax.flickr.ui.modules.main;

import android.content.Context;
import android.os.Bundle;

import com.etermax.flickr.R;
import com.etermax.flickr.ui.base.BaseActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends BaseActivity {

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        pushFragment(MainFragment.newInstance());
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
