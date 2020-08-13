package com.example.host.ui.upcoming;

import com.example.host.data.network.response.ListHouseResponse;
import com.example.host.ui.base.MvpView;

public interface UpcomingView extends MvpView {
    void showData(ListHouseResponse response);
}
