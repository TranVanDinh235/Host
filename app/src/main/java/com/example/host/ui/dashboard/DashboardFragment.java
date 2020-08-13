package com.example.host.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.host.R;
import com.example.host.data.network.entity.House;
import com.example.host.data.network.response.ListHouseResponse;
import com.example.host.di.component.ActivityComponent;
import com.example.host.ui.base.BaseFragment;
import com.example.host.ui.house.HouseActivity;
import com.example.host.ui.newhouse.NewHouseActivity;
import com.example.host.utils.AppConstants;
import com.google.gson.Gson;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashboardFragment extends BaseFragment implements DashboardView, DashboardAdapter.Callback {

    @Inject
    DashboardPresenter<DashboardView> mPresenter;

    @Inject
    DashboardAdapter mAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.layout_dashboard_rv)
    RecyclerView mHouseRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);


        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, root));
            mPresenter.onAttach(this);
        }

        return root;
    }


    @Override
    protected void setUp(View view) {
        mAdapter.setCallback(this);

        mHouseRecyclerView.setLayoutManager(mLayoutManager);
        mHouseRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mHouseRecyclerView.setAdapter(mAdapter);

        mPresenter.getHouseList();
    }

    @Override
    public void onItemClick(House house) {
        Intent intent = new Intent(getActivity(), HouseActivity.class);
        intent.putExtra(AppConstants.TAG_DATA_HOUSE, new Gson().toJson(house));
        startActivity(intent);
    }

    @Override
    public void showData(ListHouseResponse response) {
        mAdapter.addItem(response.getHouseList().getHouses());
    }

    @OnClick(R.id.layout_dashboard_add)
    void onAddHouseClick(View view){
        Intent intent = new Intent(getActivity(), NewHouseActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(intent, AppConstants.NEW_HOUSE_REQUEST_CODE);
    }
}
