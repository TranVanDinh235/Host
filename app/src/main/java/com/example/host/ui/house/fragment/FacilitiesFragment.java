package com.example.host.ui.house.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.host.R;
import com.example.host.data.network.entity.House;
import com.example.host.di.PerActivity;
import com.example.host.ui.base.BaseFragment;
import com.example.host.ui.house.adapter.FacilitiesAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

@PerActivity
public class FacilitiesFragment extends BaseFragment {

    @BindView(R.id.layout_facilities_label)
    TextView facilitiesTextView;

    @BindView(R.id.layout_facilities_room_label)
    TextView roomTextView;

    @BindView(R.id.layout_facilities_kitchen_label)
    TextView kitchenTextView;

    @BindView(R.id.layout_facilities_special_label)
    TextView specialTextView;

    @BindView(R.id.layout_facilities_families_label)
    TextView familiesTextView;

    @BindView(R.id.layout_facilities_entertainment_label)
    TextView entertainmentTextView;

    @BindView(R.id.layout_facilities_rv)
    RecyclerView facilitiesRecyclerView;

    @BindView(R.id.layout_facilities_room_rv)
    RecyclerView roomRecyclerView;

    @BindView(R.id.layout_facilities_kitchen_rv)
    RecyclerView kitchenRecyclerView;

    @BindView(R.id.layout_facilities_families_rv)
    RecyclerView familiesRecyclerView;

    @BindView(R.id.layout_facilities_special_rv)
    RecyclerView specialRecyclerView;

    @BindView(R.id.layout_facilities_entertainment_rv)
    RecyclerView entertainmentRecyclerView;

    private final House mHouse;

    public FacilitiesFragment(House house){
        this.mHouse = house;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_facilities, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    protected void setUp(View view) {
        initData();
    }

    void initData(){
        if(mHouse.getFacilities() == null || mHouse.getFacilities().equalsIgnoreCase("")){
            facilitiesRecyclerView.setVisibility(View.GONE);
            facilitiesTextView.setVisibility(View.GONE);
        } else {
            FacilitiesAdapter adapter = new FacilitiesAdapter(mHouse, 0);
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            facilitiesRecyclerView.setLayoutManager(mLayoutManager);
            facilitiesRecyclerView.setAdapter(adapter);
            facilitiesTextView.setVisibility(View.VISIBLE);
            facilitiesRecyclerView.setVisibility(View.VISIBLE);
        }

        if(mHouse.getRoomFacilities() == null || mHouse.getRoomFacilities().equalsIgnoreCase("")){
            roomRecyclerView.setVisibility(View.GONE);
            roomTextView.setVisibility(View.GONE);
        } else {
            FacilitiesAdapter adapter = new FacilitiesAdapter(mHouse, 0);
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            roomRecyclerView.setLayoutManager(mLayoutManager);
            roomRecyclerView.setAdapter(adapter);
            roomTextView.setVisibility(View.VISIBLE);
            roomTextView.setVisibility(View.VISIBLE);
        }

        if(mHouse.getKitchenFacilities() == null || mHouse.getKitchenFacilities().equalsIgnoreCase("")){
            kitchenRecyclerView.setVisibility(View.GONE);
            kitchenTextView.setVisibility(View.GONE);
        } else {
            FacilitiesAdapter adapter = new FacilitiesAdapter(mHouse, 0);
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            kitchenRecyclerView.setLayoutManager(mLayoutManager);
            kitchenRecyclerView.setAdapter(adapter);
            kitchenTextView.setVisibility(View.VISIBLE);
            kitchenRecyclerView.setVisibility(View.VISIBLE);
        }

        if(mHouse.getSpecialFacilities() == null || mHouse.getSpecialFacilities().equalsIgnoreCase("")){
            specialRecyclerView.setVisibility(View.GONE);
            specialTextView.setVisibility(View.GONE);
        } else {
            FacilitiesAdapter adapter = new FacilitiesAdapter(mHouse, 0);
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            specialRecyclerView.setLayoutManager(mLayoutManager);
            specialRecyclerView.setAdapter(adapter);
            specialTextView.setVisibility(View.VISIBLE);
            specialRecyclerView.setVisibility(View.VISIBLE);
        }

        if(mHouse.getFamilies() == null || mHouse.getFamilies().equalsIgnoreCase("")){
            familiesTextView.setVisibility(View.GONE);
            facilitiesRecyclerView.setVisibility(View.GONE);
        } else {
            FacilitiesAdapter adapter = new FacilitiesAdapter(mHouse, 0);
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            familiesRecyclerView.setLayoutManager(mLayoutManager);
            familiesRecyclerView.setAdapter(adapter);
            familiesTextView.setVisibility(View.VISIBLE);
            familiesRecyclerView.setVisibility(View.VISIBLE);
        }

        if(mHouse.getEntertainment() == null || mHouse.getEntertainment().equalsIgnoreCase("")){
            entertainmentRecyclerView.setVisibility(View.GONE);
            entertainmentTextView.setVisibility(View.GONE);
        } else {
            FacilitiesAdapter adapter = new FacilitiesAdapter(mHouse, 0);
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            entertainmentRecyclerView.setLayoutManager(mLayoutManager);
            entertainmentRecyclerView.setAdapter(adapter);
            entertainmentTextView.setVisibility(View.VISIBLE);
            entertainmentRecyclerView.setVisibility(View.VISIBLE);
        }

        if(mHouse.getFacilities() == null || mHouse.getFacilities().equalsIgnoreCase("")){
            facilitiesRecyclerView.setVisibility(View.GONE);
            facilitiesTextView.setVisibility(View.GONE);
        } else {
            FacilitiesAdapter adapter = new FacilitiesAdapter(mHouse, 0);
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            facilitiesRecyclerView.setLayoutManager(mLayoutManager);
            facilitiesRecyclerView.setAdapter(adapter);
            facilitiesTextView.setVisibility(View.VISIBLE);
            facilitiesRecyclerView.setVisibility(View.VISIBLE);
        }
    }
}
