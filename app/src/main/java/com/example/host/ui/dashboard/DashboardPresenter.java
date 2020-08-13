package com.example.host.ui.dashboard;

import com.example.host.di.PerActivity;
import com.example.host.ui.base.Presenter;

@PerActivity
public interface DashboardPresenter<V extends DashboardView> extends Presenter<V> {
    void getHouseList();
}
