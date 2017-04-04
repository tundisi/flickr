package com.etermax.flickr.di;

import com.etermax.flickr.di.modules.ApiModule;
import com.etermax.flickr.di.modules.ApplicationModule;
import com.etermax.flickr.di.modules.ControllerModule;
import com.etermax.flickr.ui.base.BaseActivity;
import com.etermax.flickr.ui.base.BaseFragment;
import com.etermax.flickr.ui.modules.detailPhoto.DetailPhotoFragment;
import com.etermax.flickr.ui.modules.main.MainActivity;
import com.etermax.flickr.ui.modules.main.MainFragment;
import com.etermax.flickr.ui.modules.profile.ProfileFragment;
import com.etermax.flickr.ui.modules.splash.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Luis Tundisi on 01/04/2017.
 */

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                ApiModule.class,
                ControllerModule.class
        }
)

public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    void inject(BaseFragment baseFragment);

    void inject(SplashActivity splashActivity);

    void inject(MainActivity mainActivity);

    void inject(MainFragment mainFragment);

    void inject(DetailPhotoFragment detailPhotoFragment);

    void inject(ProfileFragment profileFragment);
}
