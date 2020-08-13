package com.example.host.ui.login;

import com.example.host.di.PerActivity;
import com.example.host.ui.base.Presenter;

@PerActivity
public interface LoginPresenter<V extends LoginView> extends Presenter<V> {

    void onLoginClick(String email, String password);

    void onGoogleLoginClick(String token);

    void onFacebookLoginClick(String token);
}
