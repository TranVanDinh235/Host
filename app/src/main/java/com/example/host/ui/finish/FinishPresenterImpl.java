package com.example.host.ui.finish;

import com.example.host.data.DataManager;
import com.example.host.ui.base.BasePresenter;
import com.example.host.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class FinishPresenterImpl<V extends FinishView> extends BasePresenter<V> implements FinishPresenter<V> {

    @Inject
    public FinishPresenterImpl(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
