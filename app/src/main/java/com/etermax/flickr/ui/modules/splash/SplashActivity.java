package com.etermax.flickr.ui.modules.splash;

import android.content.Intent;
import android.os.Bundle;
import com.etermax.flickr.R;
import com.etermax.flickr.ui.base.BaseActivity;
import com.etermax.flickr.ui.modules.main.MainActivity;

public class SplashActivity extends BaseActivity implements SplashView {

    SplashPresenter splashPresenter;

    @Override
    public int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        splashPresenter = new SplashPresenter(this);
        splashPresenter.startTimer();
        showProgressDialog(R.string.loading);
    }

    @Override
    public void goToLoginActivity() {
        dismissProgressDialog();
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void goToMainActivity() {
        dismissProgressDialog();
    }
}
