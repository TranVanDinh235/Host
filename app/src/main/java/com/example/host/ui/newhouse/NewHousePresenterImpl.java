package com.example.host.ui.newhouse;

import com.example.host.data.DataManager;
import com.example.host.data.network.request.HouseBody;
import com.example.host.ui.base.BasePresenter;
import com.example.host.utils.rx.SchedulerProvider;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class NewHousePresenterImpl<V extends NewHouseView> extends BasePresenter<V> implements NewHousePresenter<V> {

    @Inject
    public NewHousePresenterImpl(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void newHouse(HouseBody body, List<File> fileList) {
        String userId = getDataManager().getCurrentUserId() + "";
        body.setHostId(getDataManager().getCurrentUserId());
        try {
            getCompositeDisposable().add(getDataManager().doServerApiNewHouseDataCall(userId,body, fileList)
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(response -> {
                        getView().onSuccess();
                    }, Throwable::printStackTrace));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
