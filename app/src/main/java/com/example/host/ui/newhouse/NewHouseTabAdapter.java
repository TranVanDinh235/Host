package com.example.host.ui.newhouse;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.host.data.network.request.HouseBody;
import com.example.host.ui.newhouse.fragment.AddressFragment;
import com.example.host.ui.newhouse.fragment.FacilitiesFragment;
import com.example.host.ui.newhouse.fragment.PhotoFragment;
import com.example.host.ui.newhouse.fragment.TitleFragment;
import com.example.host.utils.CommonUtils;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class NewHouseTabAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private int mCurrentPosition = -1;

//    public NewHouseTabAdapter(@NonNull FragmentManager fm) {
//        super(fm);
//        this.fragments = new ArrayList<Fragment>();
//        fragments.add(new TitleFragment());
//        fragments.add(new FacilitiesFragment());
//        fragments.add(new AddressFragment());
//        fragments.add(new PhotoFragment());
//    }

    public NewHouseTabAdapter(@NonNull FragmentManager fm, HouseBody house, TabLayout tabLayout, NewHousePresenter<NewHouseView> presenter) {
        super(fm);
        this.fragments = new ArrayList<Fragment>();
        fragments.add(new TitleFragment(house, tabLayout));
        fragments.add(new FacilitiesFragment(house, tabLayout));
        fragments.add(new AddressFragment(house, tabLayout));
        fragments.add(new PhotoFragment(house, presenter));
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return CommonUtils.getNewHouseTabTitle(position);
    }
}
