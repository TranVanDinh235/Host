package com.example.host.ui.booking;

import com.example.host.di.PerActivity;
import com.example.host.ui.base.Presenter;

@PerActivity
public interface BookingPresenter <V extends BookingView> extends Presenter<V> {
}
