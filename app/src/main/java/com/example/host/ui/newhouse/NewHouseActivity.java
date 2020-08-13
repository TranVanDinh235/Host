package com.example.host.ui.newhouse;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.aminography.primecalendar.PrimeCalendar;
import com.aminography.primedatepicker.common.OnDayPickedListener;
import com.aminography.primedatepicker.common.PickType;
import com.example.host.R;
import com.example.host.data.network.request.HouseBody;
import com.example.host.ui.base.BaseActivity;
import com.example.host.utils.AppConstants;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewHouseActivity extends BaseActivity implements NewHouseView, OnDayPickedListener {

    @Inject
    NewHousePresenter<NewHouseView> mPresenter;

    @BindView(R.id.layout_new_house_tab_bar)
    TabLayout tabLayout;

    @BindView(R.id.layout_new_house_vp)
    ViewPager viewPager;

    private HouseBody mHouse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_house);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(NewHouseActivity.this);
        setUp();
    }

    @Override
    protected void setUp() {
        mHouse = new HouseBody();
        NewHouseTabAdapter adapter = new NewHouseTabAdapter(getSupportFragmentManager(), mHouse, tabLayout, mPresenter);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        if(hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) && hasPermission(Manifest.permission.CAMERA)){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                AppConstants.REQUEST_PERMISSION);
            }
        }
    }

    @Override
    public void onDayPicked(PickType pickType, @Nullable PrimeCalendar singleDay, @Nullable PrimeCalendar startDay, @Nullable PrimeCalendar endDay, List<PrimeCalendar> multipleDays) {
        Log.e("dinh", "onClick1: " + multipleDays.size());
    }

    @OnClick(R.id.layout_new_house_back_icon)
    void onBackIconClick(View view){
        finish();
    }

    @Override
    public void onSuccess() {
        finish();
    }
}
