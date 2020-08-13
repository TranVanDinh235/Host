package com.example.host.ui.house.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.host.R;
import com.example.host.data.network.entity.House;
import com.example.host.di.PerActivity;
import com.example.host.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

@PerActivity
public class HouseRulesFragment extends BaseFragment {

    private final House mHouse;

    @BindView(R.id.layout_house_rules_tv)
    TextView mHouseRulesTextView;

    public HouseRulesFragment(House house){
        this.mHouse = house;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_house_rules, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    protected void setUp(View view) {
        mHouseRulesTextView.setText(mHouse.getHouseRules());
    }
}