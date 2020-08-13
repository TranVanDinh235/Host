package com.example.host.ui.newhouse;

import com.example.host.data.network.request.HouseBody;
import com.example.host.di.PerActivity;
import com.example.host.ui.base.Presenter;

import java.io.File;
import java.util.List;

@PerActivity
public interface NewHousePresenter<V extends NewHouseView> extends Presenter<V> {
    void newHouse(HouseBody body, List<File> fileList);
}
