package com.example.host.di.module;

import android.app.Application;
import android.content.Context;

import com.example.host.data.AppDataManager;
import com.example.host.data.DataManager;
import com.example.host.data.db.AppDbHelper;
import com.example.host.data.db.DbHelper;
import com.example.host.data.network.ApiHeader;
import com.example.host.data.network.ApiHelper;
import com.example.host.data.network.AppApiHelper;
import com.example.host.data.prefs.AppPrefHelper;
import com.example.host.data.prefs.PrefHelper;
import com.example.host.di.ApiInfo;
import com.example.host.di.ApplicationContext;
import com.example.host.di.DatabaseInfo;
import com.example.host.di.PreferenceInfo;
import com.example.host.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return "";
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PrefHelper providePreferencesHelper(AppPrefHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(PrefHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                preferencesHelper.getAccessToken());
    }
}
