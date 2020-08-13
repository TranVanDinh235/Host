package com.example.host.utils;

public class AppConstants {

    public static final String IP_ADDRESS = "http://192.168.43.126:3060/host/v1/api";
//    public static final String IP_ADDRESS = "http://10.1.60.57:3060/host/v1/api";
//    public static final String IP_ADDRESS = "http://10.0.2.2:3060/host/v1/api";
//    public static final String IP_ADDRESS = "http://192.168.43.126:3060/host/v1/api";
//    public static final String IP_ADDRESS = "http://192.168.1.10:3060/host/v1/api";

    public static final String STATUS_CODE_SUCCESS = "success";
    public static final String STATUS_CODE_FAILED = "failed";

    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;

    public static final String DB_NAME = "homestay_mvp.db";
    public static final String PREF_NAME = "homestay_pref";

    public static final int NULL_INDEX = -1;

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    public static final String ENTIRE_HOUSE = "NHÀ RIÊNG";
    public static final String CONDOMINIUM = "CĂN HỘ CHUNG CƯ";
    public static final String SERVICE_APARTMENT = "CĂN HỘ DỊCH VỤ";
    public static final String STUDIO_APARTMENT = "CĂN HỘ STUDIO";
    public static final String OTHER = "KHÁC";

    public static final String FACILITIES = "Tiện nghi";
    public static final String PRICE = "Giá phòng";
    public static final String REVIEW = "Bình luận";
    public static final String DETAIL = "Chi tiết";
    public static final String CANCELLATION_POLICY = "Chính sách huỷ";
    public static final String HOUSE_RULES = "Quy tắc chỗ ở";

    public static final String TAG_LIST_HOUSE_TYPE = "list house type";
    public static final String TAG_TOPIC_ITEM = "topic item";
    public static final String TAG_CITY = "city";
    public static final String TAG_LIST_HOUSE_SUB_TITLE = "list house sub title";
    public static final String TAG_TOPIC_ITEM_ID = "tag topic item id";
    public static final String TAG_SEARCH_STRING = "tag search string";

    public static final String VERY_GOOD = "Rất tốt";
    public static final String GOOD = "Tốt";
    public static final String NORMAL = "Bình thường";
    public static final String BAD = "Khá tệ";

    public static final String UPCOMING = "Đang diễn ra";
    public static final String FINISH = "Kết thúc";
    public static final int LAUNCH_SIGN_UP_ACTIVITY = 25;
    public static final CharSequence TITLE = "Tiêu đề";
    public static final CharSequence ADDRESS = "Địa chỉ";
    public static final CharSequence PHOTO = "Hình ảnh";
    public static final String TAG_BOTTOM_SHEET_PHOTO = "bottom sheet photo";
    public static final int REQUEST_IMAGE_CAPTURE = 26;
    public static final int REQUEST_PERMISSION = 27;
    public static final int REQUEST_IMAGE_GALLEY = 28;
    public static final String TAG_DATA_BOOKING = "tag data booking";
    public static final int SCANNING_REQUEST_CODE = 29;
    public static final int NEW_HOUSE_REQUEST_CODE = 30;
    public static final String TAG_DATA_HOUSE = "tag data house";


    private AppConstants() {
        // This utility class is not publicly instantiable
    }
}
