package com.example.host.ui.base;


import com.androidnetworking.error.ANError;

public interface Presenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

    void handleApiError(ANError error);

    void setUserAsLoggedOut();
}
