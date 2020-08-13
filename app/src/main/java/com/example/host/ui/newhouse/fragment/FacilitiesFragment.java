package com.example.host.ui.newhouse.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.host.R;
import com.example.host.data.network.entity.House;
import com.example.host.data.network.request.HouseBody;
import com.example.host.di.component.ActivityComponent;
import com.example.host.ui.base.BaseFragment;
import com.example.host.utils.StringUtils;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FacilitiesFragment extends BaseFragment {

    @BindView(R.id.layout_facilities_wifi)
    MaterialCheckBox mWifiCheckbox;

    @BindView(R.id.layout_facilities_tv)
    MaterialCheckBox mTVCheckbox;

    @BindView(R.id.layout_facilities_air_condition)
    MaterialCheckBox mAirConditionCheckbox;

    @BindView(R.id.layout_facilities_washing_machine)
    MaterialCheckBox mWashingMachineCheckbox;

    @BindView(R.id.layout_facilities_shampoo)
    MaterialCheckBox mShampooCheckbox;

    @BindView(R.id.layout_facilities_tissue)
    MaterialCheckBox mTissueCheckbox;

    @BindView(R.id.layout_facilities_mineral_water)
    MaterialCheckBox mMineralWaterCheckbox;

    @BindView(R.id.layout_facilities_toothpaste)
    MaterialCheckBox mToothpasteCheckbox;

    @BindView(R.id.layout_facilities_soap)
    MaterialCheckBox mSoapCheckbox;

    @BindView(R.id.layout_facilities_towel)
    MaterialCheckBox mTowelCheckbox;

    @BindView(R.id.layout_facilities_dryer)
    MaterialCheckBox mDryerCheckbox;

    @BindView(R.id.layout_facilities_conditioner)
    MaterialCheckBox mConditionerCheckbox;

    @BindView(R.id.layout_facilities_free_breakfast)
    MaterialCheckBox mFreeBreakfastCheckbox;

    @BindView(R.id.layout_facilities_shower_gel)
    MaterialCheckBox mShowerGelCheckbox;

    @BindView(R.id.layout_facilities_window)
    MaterialCheckBox mWindowCheckbox;

    @BindView(R.id.layout_facilities_balcony)
    MaterialCheckBox mBalconyCheckbox;

    @BindView(R.id.layout_facilities_electric_stove)
    MaterialCheckBox mElectricStoveCheckbox;

    @BindView(R.id.layout_facilities_fridge)
    MaterialCheckBox mFridgeCheckbox;

    @BindView(R.id.layout_facilities_microwave)
    MaterialCheckBox mMicrowaveCheckbox;

    @BindView(R.id.layout_facilities_smart_TV)
    MaterialCheckBox mSmartTVCheckbox;

    @BindView(R.id.layout_facilities_landscape)
    MaterialCheckBox mLandscapeCheckbox;

    @BindView(R.id.layout_facilities_pool)
    MaterialCheckBox mPoolCheckbox;

    @BindView(R.id.layout_facilities_golf)
    MaterialCheckBox mGolfCheckbox;

    @BindView(R.id.layout_facilities_BBQ)
    MaterialCheckBox mBBQCheckbox;

    @BindView(R.id.layout_facilities_no_smoking)
    MaterialCheckBox mNoSmokingCheckbox;

    @BindView(R.id.layout_facilities_children)
    MaterialCheckBox mChildrenCheckbox;

    @BindView(R.id.layout_facilities_bathroom)
    EditText mBathroomEditText;

    @BindView(R.id.layout_facilities_bedroom)
    EditText mBedroomEditText;

    @BindView(R.id.layout_facilities_bed)
    EditText mBedEditText;

    private TabLayout tabLayout;
    private HouseBody mHouse;

    public FacilitiesFragment(HouseBody house, TabLayout tabLayout){
        this.mHouse = house;
        this.tabLayout = tabLayout;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_fac_new, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    protected void setUp(View view) {
        initData();
    }

    void initData(){
        mBedroomEditText.setText("1");
        mBathroomEditText.setText("1");
        mBedEditText.setText("1");
    }

    @OnClick(R.id.layout_facilities_bedroom_add)
    void onBedroomAdd(View view){
        int bedroom = Integer.parseInt(mBedroomEditText.getText().toString()) + 1;
        mBedroomEditText.setText(String.valueOf(bedroom));
    }

    @OnClick(R.id.layout_facilities_bedroom_minus)
    void onBedroomMinus(View view){
        int bedroom = Integer.parseInt(mBedroomEditText.getText().toString()) - 1;
        if(bedroom > 0) mBedroomEditText.setText(String.valueOf(bedroom));
    }

    @OnClick(R.id.layout_facilities_bathroom_add)
    void onBathRoomAdd(View view){
        int bathroom = Integer.parseInt(mBathroomEditText.getText().toString()) + 1;
        mBathroomEditText.setText(String.valueOf(bathroom));
    }

    @OnClick(R.id.layout_facilities_bathroom_minus)
    void onBathRoomMinus(View view){
        int bathroom = Integer.parseInt(mBathroomEditText.getText().toString()) - 1;
        if(bathroom > 0) mBathroomEditText.setText(String.valueOf(bathroom));
    }

    @OnClick(R.id.layout_facilities_bed_add)
    void onBedAdd(View view){
        int bed = Integer.parseInt(mBedEditText.getText().toString()) + 1;
        mBedEditText.setText(String.valueOf(bed));
    }

    @OnClick(R.id.layout_facilities_bed_minus)
    void onBedMinus(View view){
        int bed = Integer.parseInt(mBedEditText.getText().toString()) - 1;
        if(bed > 0) mBedEditText.setText(String.valueOf(bed));
    }

    @Override
    public void onPause() {
        Log.e("TAG", "onPause: fac");
        super.onPause();
    }

    @OnClick(R.id.layout_facilities_continue)
    void onContinueClick(View view){
        mHouse.setBedRoom(Integer.parseInt(mBedroomEditText.getText().toString()));
        mHouse.setBathRoom(Integer.parseInt(mBathroomEditText.getText().toString()));
        mHouse.setBed(Integer.parseInt(mBedEditText.getText().toString()));
        List<String> facilities = new ArrayList<>();
        List<String> roomFacilities = new ArrayList<>();
        List<String> kitchenFacilities = new ArrayList<>();
        List<String> specialFacilities = new ArrayList<>();
        List<String> entertainment = new ArrayList<>();
        List<String> families = new ArrayList<>();

        if(mWifiCheckbox.isChecked()) facilities.add(getString(R.string.wifi));
        if(mTVCheckbox.isChecked()) facilities.add(getString(R.string.tv));
        if(mAirConditionCheckbox.isChecked()) facilities.add(getString(R.string.air_condition));
        if(mWashingMachineCheckbox.isChecked()) facilities.add(getString(R.string.washing_machine));
        if(mShampooCheckbox.isChecked()) facilities.add(getString(R.string.shampoo));
        if(mTissueCheckbox.isChecked()) facilities.add(getString(R.string.tissue));
        if(mMineralWaterCheckbox.isChecked()) facilities.add(getString(R.string.mineral_water));
        if(mToothpasteCheckbox.isChecked()) facilities.add(getString(R.string.toothpaste));
        if(mSoapCheckbox.isChecked()) facilities.add(getString(R.string.soap));
        if(mTowelCheckbox.isChecked()) facilities.add(getString(R.string.towel));
        if(mDryerCheckbox.isChecked()) facilities.add(getString(R.string.dryer));
        if(mConditionerCheckbox.isChecked()) facilities.add(getString(R.string.conditioner));
        if(mFreeBreakfastCheckbox.isChecked()) facilities.add(getString(R.string.free_breakfast));
        if(mShowerGelCheckbox.isChecked()) facilities.add(getString(R.string.shower_gel));

        if(mWindowCheckbox.isChecked()) roomFacilities.add(getString(R.string.window));
        if(mBalconyCheckbox.isChecked()) roomFacilities.add(getString(R.string.balcony));

        if(mElectricStoveCheckbox.isChecked()) kitchenFacilities.add(getString(R.string.electric_stove));
        if(mMicrowaveCheckbox.isChecked()) kitchenFacilities.add(getString(R.string.microwave));
        if(mFridgeCheckbox.isChecked()) kitchenFacilities.add(getString(R.string.fridge));

        if(mSmartTVCheckbox.isChecked()) specialFacilities.add(getString(R.string.smart_TV));

        if(mLandscapeCheckbox.isChecked()) entertainment.add(getString(R.string.landscape));
        if(mPoolCheckbox.isChecked()) entertainment.add(getString(R.string.pool));
        if(mGolfCheckbox.isChecked()) entertainment.add(getString(R.string.golf));
        if(mBBQCheckbox.isChecked()) entertainment.add(getString(R.string.BBQ));

        if(mNoSmokingCheckbox.isChecked()) families.add(getString(R.string.no_smoking));
        if(mChildrenCheckbox.isChecked()) families.add(getString(R.string.children));

        mHouse.setFacilities(StringUtils.listToStr(facilities));
        mHouse.setRoomFacilities(StringUtils.listToStr(roomFacilities));
        mHouse.setKitchenFacilities(StringUtils.listToStr(kitchenFacilities));
        mHouse.setSpecialFacilities(StringUtils.listToStr(specialFacilities));
        mHouse.setEntertainment(StringUtils.listToStr(entertainment));
        mHouse.setFamilies(StringUtils.listToStr(families));
        TabLayout.Tab tab = tabLayout.getTabAt(2);
        tab.select();
    }
}
