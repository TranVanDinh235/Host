package com.example.host.ui.booking;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.host.R;
import com.example.host.data.network.entity.Booking;
import com.example.host.ui.base.BaseActivity;
import com.example.host.utils.AppConstants;
import com.example.host.utils.DateTimeUtils;
import com.example.host.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class BookingActivity extends BaseActivity implements BookingView{

    @Inject
    BookingPresenter<BookingView> mPresenter;

    @BindView(R.id.layout_booking_guest_name)
    TextView mGuestNameTextView;

    @BindView(R.id.layout_booking_guest_photo)
    CircleImageView mGuestPhotoImageView;

    @BindView(R.id.layout_booking_title_house)
    TextView mHouseTitleTextView;

    @BindView(R.id.layout_booking_date_start)
    TextView mDateStartTextView;

    @BindView(R.id.layout_booking_date_end)
    TextView mDateEndTextView;

    @BindView(R.id.layout_booking_num_guest)
    TextView mNumGuestTextView;

    @BindView(R.id.layout_booking_price_one)
    TextView mPriceOneTextView;

    @BindView(R.id.layout_booking_num)
    TextView mNumTextView;

    @BindView(R.id.layout_booking_total)
    TextView mTotalTextView;

    @BindView(R.id.layout_booking_additional)
    TextView mAdditionalTextView;

    @BindView(R.id.layout_booking_promotion)
    TextView mPromotionTextView;

    @BindView(R.id.layout_booking_price_final)
    TextView mPriceFinalTextView;

    @BindView(R.id.layout_booking_photo)
    ImageView mPhotoImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(BookingActivity.this);

        setUp();
    }

    @Override
    protected void setUp() {
        if (getIntent() == null) return;
        String json = getIntent().getStringExtra(AppConstants.TAG_DATA_BOOKING);
        Type type = new TypeToken<Booking>() {
        }.getType();
        Booking data = new Gson().fromJson(json, type);
        initData(data);
    }

    void initData(Booking booking){
        mGuestNameTextView.setText(booking.getUserName());
        if(booking.getPicUrl() != null) {
            Glide.with(this)
                    .load(booking.getPicUrl())
                    .asBitmap()
                    .centerCrop()
                    .into(mGuestPhotoImageView);
        }

        mHouseTitleTextView.setText(StringUtils.cutString(booking.getTitle(), 40));
        if(booking.getPhoto() != null) {
            Glide.with(this)
                    .load(booking.getPhoto())
                    .asBitmap()
                    .centerCrop()
                    .into(mPhotoImageView);
        }

        String startDate = DateTimeUtils.houseDateToString(booking.getStartDate());
        mDateStartTextView.setText(startDate);
        String endDate = "- " + DateTimeUtils.houseDateToString(booking.getStartDate());
        mDateEndTextView.setText(endDate);

        String numGuest = booking.getNumGuest() + " khách: " + booking.getAdult() + " người lớn - " + booking.getChild() + " trẻ em";
        mNumGuestTextView.setText(numGuest);

        mPriceOneTextView.setText(StringUtils.toRate(booking.getPrice()));
        mNumTextView.setText(String.valueOf(booking.getNumOfDay()));
        int total = Integer.parseInt(booking.getPrice()) * booking.getNumOfDay();
        mTotalTextView.setText(String.valueOf(total));
        mPromotionTextView.setText(String.valueOf(booking.getPromotion()));
        mPriceFinalTextView.setText(String.valueOf(booking.getCost()));
    }
}
