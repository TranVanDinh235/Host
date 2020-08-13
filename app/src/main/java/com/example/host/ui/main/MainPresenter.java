package com.example.host.ui.main;

import com.example.host.di.PerActivity;
import com.example.host.ui.base.MvpView;
import com.example.host.ui.base.Presenter;

@PerActivity
public interface MainPresenter<V extends MvpView> extends Presenter<V> {

}