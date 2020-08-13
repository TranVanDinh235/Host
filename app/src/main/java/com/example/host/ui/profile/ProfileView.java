package com.example.host.ui.profile;

import com.example.host.data.network.entity.User;
import com.example.host.ui.base.MvpView;

public interface ProfileView extends MvpView {
    void loadData(User user);
}
