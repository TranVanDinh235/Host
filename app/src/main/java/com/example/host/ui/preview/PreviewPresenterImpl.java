package com.example.host.ui.preview;

import com.example.host.data.DataManager;
import com.example.host.ui.base.BasePresenter;
import com.example.host.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class PreviewPresenterImpl<V extends PreviewView> extends BasePresenter<V> implements PreviewPresenter<V> {

    @Inject
    public PreviewPresenterImpl(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
