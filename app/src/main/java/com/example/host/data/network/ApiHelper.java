package com.example.host.data.network;

import com.example.host.data.network.request.HouseBody;
import com.example.host.data.network.response.ApiResponse;
import com.example.host.data.network.response.AuthResponse;
import com.example.host.data.network.response.ListHouseResponse;
import com.example.host.data.network.response.UserResponse;

import org.json.JSONObject;

import java.io.File;
import java.util.List;

import io.reactivex.Single;

public interface ApiHelper {
    ApiHeader getApiHeader();

    Single<AuthResponse> doServerApiLoginNativeCall(JSONObject body);

    Single<AuthResponse> doServerApiLoginGoogleCall(JSONObject body);

    Single<AuthResponse> doServerApiLoginFacebookCall(JSONObject body);

    Single<UserResponse> doServerApiGetUserInfoCall(String userId);

    Single<ListHouseResponse> doServerApiTripsUpcomingDataCall(String userId);

    Single<ListHouseResponse> doServerApiTripsFinishDataCall(String userId);

    Single<ListHouseResponse> doServerApiHouseListDataCall(String userId);

    Single<ApiResponse> doServerApiNewHouseDataCall(String userId, HouseBody body, List<File> fileList);
}
