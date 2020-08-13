package com.example.host.ui.splash;

import com.example.host.di.PerActivity;
import com.example.host.ui.base.Presenter;

@PerActivity
public interface SplashPresenter<V extends SplashView> extends Presenter<V> {
    boolean isUserLogin();
}