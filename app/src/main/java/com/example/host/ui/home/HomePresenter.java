package com.example.host.ui.home;

import com.example.host.di.PerActivity;
import com.example.host.ui.base.Presenter;

@PerActivity
public interface HomePresenter<V extends HomeView> extends Presenter<V> {
}
