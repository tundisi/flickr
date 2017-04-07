package com.etermax.flickr.ui.modules.splash;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Luis Tundisi on 01/04/2017.
 */

public class SplashPresenter {

    private static final long SPLASH_SCREEN_DELAY = 3000;
    SplashView splashViewListener;

    public SplashPresenter(SplashView splashViewListener){
        this.splashViewListener = splashViewListener;
    }

    public void startTimer(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                splashViewListener.goToMainActivity();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
}
