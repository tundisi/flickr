package com.etermax.flickr.ui.modules.splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.etermax.flickr.R;
import com.etermax.flickr.ui.base.BaseActivity;
import com.etermax.flickr.ui.modules.main.MainActivity;

import butterknife.BindView;

public class SplashActivity extends BaseActivity implements SplashView {

    @BindView(R.id.ivPinBlue)
    ImageView ivPinBlue;
    @BindView(R.id.ivPinPink)
    ImageView ivPinPink;

    SplashPresenter splashPresenter;

    @Override
    public int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        splashPresenter = new SplashPresenter(this);
        splashPresenter.startTimer();
        ivPinBlue.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_left_pin));
        ivPinPink.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_right_pin));
    }

    @Override
    public void goToMainActivity() {
        dismissProgressDialog();
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }
}
