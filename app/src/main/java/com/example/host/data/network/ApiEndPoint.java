package com.example.host.data.network;

import com.example.host.utils.AppConstants;

public final class ApiEndPoint {

    // auth
    public static final String ENDPOINT_REFRESH_TOKEN = AppConstants.IP_ADDRESS
            + "/auth/refresh-token";

    // login
    public static final String ENDPOINT_LOGIN_NATIVE = AppConstants.IP_ADDRESS
            + "/auth/native";
    public static final String ENDPOINT_LOGIN_GOOGLE = AppConstants.IP_ADDRESS
            + "/auth/social/google";
    public static final String ENDPOINT_LOGIN_FACEBOOK = AppConstants.IP_ADDRESS
            + "/auth/social/facebook";

    // house
    public static final String ENDPOINT_HOUSE_DATA = AppConstants.IP_ADDRESS
            + "/house/host/{id}";

    public static final String ENDPOINT_NEW_HOUSE = AppConstants.IP_ADDRESS
            + "/house/new/{id}";

    // profile
    public static final String ENDPOINT_USER_INFO = AppConstants.IP_ADDRESS
            + "/user/{id}";

    public static final String ENDPOINT_TRIPS_UPCOMING_DATA = AppConstants.IP_ADDRESS
            + "/trips/upcoming/{id}";

    public static final String ENDPOINT_TRIPS_FINISH_DATA = AppConstants.IP_ADDRESS
            + "/trips/finish/{id}";
}
