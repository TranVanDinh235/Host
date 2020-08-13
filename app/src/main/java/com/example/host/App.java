package com.example.host;

import android.app.Application;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.BuildConfig;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.example.host.data.DataManager;
import com.example.host.data.network.ApiHeader;
import com.example.host.data.network.TokenAuthenticator;
import com.example.host.di.component.ApplicationComponent;
import com.example.host.di.component.DaggerApplicationComponent;
import com.example.host.di.module.ApplicationModule;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import javax.inject.Inject;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

public class App extends Application {
    @Inject
    DataManager mDataManager;

    @Inject
    ApiHeader mApiHeader;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(1);

//        AppLogger.init();
        OkHttpClient okClient = new OkHttpClient.Builder()
                .authenticator(new TokenAuthenticator(mDataManager, mApiHeader))
                .dispatcher(dispatcher)
                .build();

        AndroidNetworking.initialize(getApplicationContext(), okClient);
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BASIC);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
