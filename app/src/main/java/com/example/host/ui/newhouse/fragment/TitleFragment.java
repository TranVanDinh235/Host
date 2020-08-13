package com.example.host.ui.newhouse.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.host.R;
import com.example.host.data.eventbus.HouseTypeEvent;
import com.example.host.data.network.request.HouseBody;
import com.example.host.di.component.ActivityComponent;
import com.example.host.ui.base.BaseFragment;
import com.example.host.ui.newhouse.TypeDialog;
import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TitleFragment extends BaseFragment {

    @BindView(R.id.layout_title_edt)
    EditText mTitleEditText;

    @BindView(R.id.layout_title_description_edt)
    EditText mDescriptionEditText;

    @BindView(R.id.layout_title_house_rule_edt)
    EditText mHouseRuleEditText;

    @BindView(R.id.layout_title_price)
    EditText mPriceEditText;

    @BindView(R.id.layout_title_addition)
    EditText mAdditionEditText;

    @BindView(R.id.layout_title_promotion)
    EditText mPromotionEditText;

    @BindView(R.id.layout_title_type)
    TextView mTypeTextView;

    @BindView(R.id.layout_title_num_guest)
    EditText mGuestEditText;

    @BindView(R.id.layout_title_num_guest_max)
    EditText mMaxGuestEditText;

    private HouseBody mHouse;
    private int type = -1;
    private int price;
    private int addition;
    private int promotion;
    private TabLayout tabLayout;

    public TitleFragment(HouseBody house, TabLayout tabLayout){
        this.mHouse = house;
        this.tabLayout = tabLayout;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_title, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, root));
//            mPresenter.onAttach(this);
        }
        return root;
    }

    @Override
    protected void setUp(View view) {
        mGuestEditText.setText("1");
        mMaxGuestEditText.setText("1");
        mPromotionEditText.setText("0");
    }

    @OnClick(R.id.layout_title_num_guest_plus)
    void onGuestAdd(View view){
        int guest = Integer.parseInt(mGuestEditText.getText().toString()) + 1;
        mGuestEditText.setText(String.valueOf(guest));
    }

    @OnClick(R.id.layout_title_num_guest_minus)
    void onGuestMinus(View view){
        int guest = Integer.parseInt(mGuestEditText.getText().toString()) - 1;
        if(guest > 0) mGuestEditText.setText(String.valueOf(guest));
    }

    @OnClick(R.id.layout_title_num_guest_max_plus)
    void onMacGuestAdd(View view){
        int maxGuest = Integer.parseInt(mMaxGuestEditText.getText().toString()) + 1;
        mMaxGuestEditText.setText(String.valueOf(maxGuest));
    }

    @OnClick(R.id.layout_title_num_guest_max_minus)
    void onMacGuestMinus(View view){
        int maxGuest = Integer.parseInt(mMaxGuestEditText.getText().toString()) - 1;
        if(maxGuest > 0) mMaxGuestEditText.setText(String.valueOf(maxGuest));
    }

    @OnClick(R.id.layout_title_continue)
    void onContinueClick(View view){
        mHouse.setTitle(mTitleEditText.getText().toString());
        mHouse.setPrice(Integer.parseInt(mPriceEditText.getText().toString()));
        mHouse.setGuest(Integer.parseInt(mGuestEditText.getText().toString()));
        mHouse.setMaxGuest(Integer.parseInt(mMaxGuestEditText.getText().toString()));
        mHouse.setAddition_fee(Integer.parseInt(mAdditionEditText.getText().toString()));
        mHouse.setPromotion(Integer.parseInt(mPromotionEditText.getText().toString()));
        mHouse.setDescription(mDescriptionEditText.getText().toString());
        mHouse.setHouseRule(mHouseRuleEditText.getText().toString());
        TabLayout.Tab tab = tabLayout.getTabAt(1);
        tab.select();
    }

    @OnClick(R.id.layout_title_type)
    void onTypeClick(View view){
        TypeDialog dialog = new TypeDialog(getBaseActivity());
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    @Override
    public void onPause() {
        Log.e("TAG", "onPause: title");
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }



    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(HouseTypeEvent event) {
        mTypeTextView.setText(event.getTypeHouse());
        mHouse.setType(event.getType());
    }
}
