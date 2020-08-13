package com.example.host.ui.dashboard;

import com.example.host.data.network.response.ListHouseResponse;
import com.example.host.ui.base.MvpView;

public interface DashboardView extends MvpView {
    void showData(ListHouseResponse response);
}
