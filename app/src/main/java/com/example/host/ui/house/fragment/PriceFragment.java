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
import com.example.host.utils.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

@PerActivity
public class PriceFragment extends BaseFragment {

    @BindView(R.id.layout_rate)
    TextView priceTextView;

    @BindView(R.id.layout_rate_addition)
    TextView additionPriceTextView;

    @BindView(R.id.layout_rate_min_date)
    TextView minDateTextView;

    private final House mHouse;

    public PriceFragment(House house){
        this.mHouse = house;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_price, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    protected void setUp(View view) {
        priceTextView.setText(StringUtils.toRate(mHouse.getPrice()));
        String additionPrice = StringUtils.toRate(mHouse.getAdditionFee()) + " khi thêm khách";
        additionPriceTextView.setText(additionPrice);
        String minDate = mHouse.getMinimumStay() + " đêm";
        minDateTextView.setText(minDate);
    }
}
