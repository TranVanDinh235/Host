package com.example.host.ui.profile;

import com.example.host.di.PerActivity;
import com.example.host.ui.base.MvpView;
import com.example.host.ui.base.Presenter;

@PerActivity
public interface ProfilePresenter<V extends MvpView> extends Presenter<V> {
    void getUserData();
}