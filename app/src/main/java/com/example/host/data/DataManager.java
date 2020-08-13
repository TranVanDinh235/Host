package com.example.host.data;

import com.example.host.data.db.DbHelper;
import com.example.host.data.network.ApiHelper;
import com.example.host.data.prefs.PrefHelper;

public interface DataManager extends DbHelper, ApiHelper, PrefHelper {
}
