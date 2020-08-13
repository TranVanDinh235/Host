package com.example.host.data.network;

import com.example.host.data.network.request.HouseBody;
import com.example.host.data.network.response.ApiResponse;
import com.example.host.data.network.response.AuthResponse;
import com.example.host.data.network.response.ListHouseResponse;
import com.example.host.data.network.response.UserResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import org.json.JSONObject;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class AppApiHelper implements ApiHelper{
    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public Single<AuthResponse> doServerApiLoginNativeCall(JSONObject body) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGIN_NATIVE)
                .addHeaders("Content-Type", "application/json")
                .addHeaders("Accept", "application/json")
                .addJSONObjectBody(body)
                .build()
                .getObjectSingle(AuthResponse.class);
    }

    @Override
    public Single<AuthResponse> doServerApiLoginGoogleCall(JSONObject body) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGIN_GOOGLE)
                .addHeaders("Content-Type", "application/json")
                .addHeaders("Accept", "application/json")
                .addJSONObjectBody(body)
                .build()
                .getObjectSingle(AuthResponse.class);
    }

    @Override
    public Single<AuthResponse> doServerApiLoginFacebookCall(JSONObject body) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGIN_FACEBOOK)
                .addHeaders("Content-Type", "application/json")
                .addHeaders("Accept", "application/json")
                .addJSONObjectBody(body)
                .build()
                .getObjectSingle(AuthResponse.class);
    }

    @Override
    public Single<UserResponse> doServerApiGetUserInfoCall(String id) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_USER_INFO)
                .addHeaders("Content-Type", "application/json")
                .addHeaders("Accept", "application/json")
                .addHeaders("x-access-token", mApiHeader.getProtectedApiHeader().getAccessToken())
                .addPathParameter("id", id)
                .build()
                .getObjectSingle(UserResponse.class);
    }

    @Override
    public Single<ListHouseResponse> doServerApiTripsUpcomingDataCall(String userId) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_TRIPS_UPCOMING_DATA)
                .addHeaders("Content-Type", "application/json")
                .addHeaders("Accept", "application/json")
                .addPathParameter("id", userId)
                .build()
                .getObjectSingle(ListHouseResponse.class);
    }

    @Override
    public Single<ListHouseResponse> doServerApiTripsFinishDataCall(String userId) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_TRIPS_FINISH_DATA)
                .addHeaders("Content-Type", "application/json")
                .addHeaders("Accept", "application/json")
                .addPathParameter("id", userId)
                .build()
                .getObjectSingle(ListHouseResponse.class);
    }

    @Override
    public Single<ListHouseResponse> doServerApiHouseListDataCall(String userId) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_HOUSE_DATA)
                .addHeaders("Content-Type", "application/json")
                .addHeaders("Accept", "application/json")
                .addPathParameter("id", userId)
                .build()
                .getObjectSingle(ListHouseResponse.class);
    }

    @Override
    public Single<ApiResponse> doServerApiNewHouseDataCall(String userId, HouseBody body, List<File> fileList) {
        return Rx2AndroidNetworking.upload(ApiEndPoint.ENDPOINT_NEW_HOUSE)
                .addHeaders("Content-Type", "application/json")
                .addHeaders("Accept", "application/json")
                .addPathParameter("id", userId)
                .addMultipartFileList("upload", fileList)
                .addMultipartParameter(body)
                .build()
                .getObjectSingle(ApiResponse.class);
    }

}
