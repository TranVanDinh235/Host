package com.example.host.ui.house;

import com.example.host.di.PerActivity;
import com.example.host.ui.base.Presenter;

@PerActivity
public interface HousePresenter<V extends HouseView> extends Presenter<V> {
}
