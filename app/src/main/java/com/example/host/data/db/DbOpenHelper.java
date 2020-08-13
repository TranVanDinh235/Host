package com.example.host.data.db;

import android.content.Context;

import com.example.host.di.ApplicationContext;
import com.example.host.di.DatabaseInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DbOpenHelper {
    @Inject
    public DbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String name) {
//        super(context, name);
    }
}
