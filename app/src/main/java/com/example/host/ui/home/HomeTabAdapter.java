package com.example.host.ui.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.host.ui.finish.FinishFragment;
import com.example.host.ui.upcoming.UpcomingFragment;
import com.example.host.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class HomeTabAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private int mCurrentPosition = -1;

    public HomeTabAdapter(@NonNull FragmentManager fm) {
        super(fm);
        this.fragments = new ArrayList<Fragment>();
        fragments.add(new UpcomingFragment());
        fragments.add(new FinishFragment());
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
        return CommonUtils.getHomeTabTitle(position);
    }
}
