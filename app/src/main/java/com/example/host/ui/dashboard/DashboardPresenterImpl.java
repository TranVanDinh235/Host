package com.example.host.ui.dashboard;

import com.example.host.data.DataManager;
import com.example.host.ui.base.BasePresenter;
import com.example.host.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class DashboardPresenterImpl<V extends DashboardView> extends BasePresenter<V> implements DashboardPresenter<V> {

    @Inject
    public DashboardPresenterImpl(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void getHouseList() {
        if(getDataManager().getCurrentUserId() == null) return;

        getCompositeDisposable().add(getDataManager().doServerApiHouseListDataCall(String.valueOf(getDataManager().getCurrentUserId()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    getView().showData(response);
                }, throwable -> {

                }));
    }
}
