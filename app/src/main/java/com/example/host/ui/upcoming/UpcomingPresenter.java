package com.example.host.ui.upcoming;

import com.example.host.ui.base.Presenter;

public interface UpcomingPresenter<V extends UpcomingView> extends Presenter<V> {
    void getTripsUpcomingData();
}
