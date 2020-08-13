package com.example.host.ui.profile;

import com.example.host.data.DataManager;
import com.example.host.ui.base.BasePresenter;
import com.example.host.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class ProfilePresenterImpl<V extends ProfileView> extends BasePresenter<V>
        implements ProfilePresenter<V> {

    @Inject
    public ProfilePresenterImpl(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }


    @Override
    public void getUserData() {
        String userId = String.valueOf(getDataManager().getCurrentUserId());
        getCompositeDisposable().add(getDataManager()
                .doServerApiGetUserInfoCall(userId)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(authResponse -> {
                    getView().loadData(authResponse.getUser());
                }, throwable -> {
                    getView().hideLoading();
                }));
    }
}
