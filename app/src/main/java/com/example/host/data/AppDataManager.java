package com.example.host.data;

import android.content.Context;

import com.example.host.data.db.DbHelper;
import com.example.host.data.network.ApiHeader;
import com.example.host.data.network.ApiHelper;
import com.example.host.data.network.request.HouseBody;
import com.example.host.data.network.response.ApiResponse;
import com.example.host.data.network.response.AuthResponse;
import com.example.host.data.network.response.ListHouseResponse;
import com.example.host.data.network.response.UserResponse;
import com.example.host.data.prefs.PrefHelper;
import com.example.host.di.ApplicationContext;

import org.json.JSONObject;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PrefHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PrefHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferencesHelper.setAccessToken(accessToken);
//        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

    @Override
    public String getRefreshToken() {
        return mPreferencesHelper.getRefreshToken();
    }

    @Override
    public void setRefreshToken(String refreshToken) {
        mPreferencesHelper.setRefreshToken(refreshToken);
    }

    @Override
    public String getCurrentUsername() {
        return mPreferencesHelper.getCurrentUsername();
    }

    @Override
    public void setCurrentUsername(String username) {
        mPreferencesHelper.setCurrentUsername(username);
    }

    @Override
    public String getCurrentUserEmail() {
        return mPreferencesHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String email) {
        mPreferencesHelper.setCurrentUserEmail(email);
    }

    @Override
    public Boolean isUserLoggedInMode() {
        return mPreferencesHelper.isUserLoggedInMode();
    }

    @Override
    public void setUserLoggedInMode(Boolean isLogged) {
        mPreferencesHelper.setUserLoggedInMode(isLogged);
    }

    @Override
    public Integer getCurrentUserId() {
        return mPreferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Integer userId) {
        mPreferencesHelper.setCurrentUserId(userId);
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return mPreferencesHelper.getCurrentUserProfilePicUrl();
    }

    @Override
    public void setCurrentUserProfilePicUrl(String url) {
        mPreferencesHelper.setCurrentUserProfilePicUrl(url);
    }

    @Override
    public Single<AuthResponse> doServerApiLoginNativeCall(JSONObject body) {
        return mApiHelper.doServerApiLoginNativeCall(body);
    }

    @Override
    public Single<AuthResponse> doServerApiLoginGoogleCall(JSONObject body) {
        return mApiHelper.doServerApiLoginGoogleCall(body);
    }

    @Override
    public Single<AuthResponse> doServerApiLoginFacebookCall(JSONObject body) {
        return mApiHelper.doServerApiLoginFacebookCall(body);
    }

    @Override
    public Single<UserResponse> doServerApiGetUserInfoCall(String userId) {
        return mApiHelper.doServerApiGetUserInfoCall(userId);
    }

    @Override
    public Single<ListHouseResponse> doServerApiTripsUpcomingDataCall(String userId) {
        return mApiHelper.doServerApiTripsUpcomingDataCall(userId);
    }

    @Override
    public Single<ListHouseResponse> doServerApiTripsFinishDataCall(String userId) {
        return mApiHelper.doServerApiTripsFinishDataCall(userId);
    }

    @Override
    public Single<ListHouseResponse> doServerApiHouseListDataCall(String userId) {
        return mApiHelper.doServerApiHouseListDataCall(userId);
    }

    @Override
    public Single<ApiResponse> doServerApiNewHouseDataCall(String userId, HouseBody body, List<File> fileList) {
        return mApiHelper.doServerApiNewHouseDataCall(userId, body, fileList);
    }
}
