package com.example.host.di.component;

import android.app.Application;
import android.content.Context;

import com.example.host.App;
import com.example.host.data.DataManager;
import com.example.host.di.ApplicationContext;
import com.example.host.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(App app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
