package com.example.host.ui.upcoming;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.host.R;
import com.example.host.data.network.entity.Booking;
import com.example.host.data.network.response.ListHouseResponse;
import com.example.host.di.component.ActivityComponent;
import com.example.host.ui.base.BaseFragment;
import com.example.host.ui.booking.BookingActivity;
import com.example.host.utils.AppConstants;
import com.google.gson.Gson;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UpcomingFragment extends BaseFragment implements UpcomingView, UpcomingAdapter.Callback{

    @Inject
    UpcomingPresenter<UpcomingView> mPresenter;

    @Inject
    UpcomingAdapter mAdapter;

    @BindView(R.id.layout_upcoming_rv)
    RecyclerView mUpcomingRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_upcoming, container, false);
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

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mUpcomingRecyclerView.setLayoutManager(layoutManager);
        mUpcomingRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mUpcomingRecyclerView.setAdapter(mAdapter);

        mPresenter.getTripsUpcomingData();
    }

    @Override
    public void onItemClick(Booking house) {
        Intent intent = new Intent(getActivity(), BookingActivity.class);
        intent.putExtra(AppConstants.TAG_DATA_BOOKING, new Gson().toJson(house));
        startActivity(intent);
    }

    @Override
    public void showData(ListHouseResponse response) {
        mAdapter.addItem(response.getHouseList().getBookings());
    }
}

