package com.example.host.ui.splash;

import com.example.host.data.DataManager;
import com.example.host.ui.base.BasePresenter;
import com.example.host.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class SplashPresenterImpl<V extends SplashView> extends BasePresenter<V> implements SplashPresenter<V> {
    @Inject
    public SplashPresenterImpl(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public boolean isUserLogin() {
        if(getDataManager().getCurrentUserId() != null && getDataManager().getCurrentUserId() != 0) return true;
        return false;
    }
}
