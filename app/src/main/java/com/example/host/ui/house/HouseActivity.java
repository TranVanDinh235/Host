package com.example.host.ui.house;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aminography.primecalendar.PrimeCalendar;
import com.aminography.primecalendar.civil.CivilCalendar;
import com.aminography.primedatepicker.picker.PrimeDatePicker;
import com.aminography.primedatepicker.picker.callback.RangeDaysPickCallback;
import com.aminography.primedatepicker.picker.theme.LightThemeFactory;
import com.bumptech.glide.Glide;
import com.example.host.R;
import com.example.host.data.network.entity.House;
import com.example.host.ui.base.BaseActivity;
import com.example.host.ui.booking.BookingActivity;
import com.example.host.ui.house.adapter.HouseTabAdapter;
import com.example.host.ui.review.ReviewAdapter;
import com.example.host.utils.AppConstants;
import com.example.host.utils.CommonUtils;
import com.example.host.utils.StringUtils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.annotation.NotNull;

import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kotlin.jvm.functions.Function1;

public class HouseActivity extends BaseActivity implements HouseView, OnMapReadyCallback {

    @Inject
    HousePresenter<HouseView> mPresenter;

    @Inject
    ReviewAdapter mAdapter;

    @BindView(R.id.layout_house_type_house)
    TextView typeHouseTextView;

    @BindView(R.id.layout_house_title)
    TextView titleTextView;

    @BindView(R.id.layout_house_tab)
    TabLayout tabLayout;

    @BindView(R.id.layout_house_view_pager)
    WrapperViewPager viewPager;

    @BindView(R.id.layout_house_description)
    TextView descriptionTextView;

    @BindView(R.id.layout_house_rating)
    TextView ratingTextView;

    @BindView(R.id.layout_house_rating_container)
    CardView ratingContainerCardView;

    @BindView(R.id.layout_house_rating_bar)
    RatingBar ratingBar;

    @BindView(R.id.layout_house_address)
    TextView addressTextView;

    @BindView(R.id.layout_house_price)
    TextView mPriceTextView;

    @BindView(R.id.layout_house_old_price)
    TextView mOldPriceTextView;

    @BindView(R.id.layout_house_review_rv)
    RecyclerView mReviewRecyclerView;

    @BindView(R.id.layout_house_photos_label)
    TextView mPhotoLabelTextView;

    @BindView(R.id.layout_house_photos_more)
    TextView mPhotoMoreTextView;

    @BindView(R.id.layout_house_review_label)
    TextView mReviewLabelTextView;

    @BindView(R.id.layout_house_review_more)
    TextView mReviewMoreTextView;

    @BindView(R.id.layout_house_photo)
    ImageView mPhotoImageView;

    @BindView(R.id.layout_house_back_icon)
    ImageView mBackImageView;

    private PrimeDatePicker datePicker;

    private House house;

    private GoogleMap mMap;
    private Marker mMarker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_house);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(HouseActivity.this);
        setUp();
    }

    @Override
    protected void setUp() {
        if (getIntent() == null) return;
        String json = getIntent().getStringExtra(AppConstants.TAG_DATA_HOUSE);
        Type type = new TypeToken<House>() {
        }.getType();
        house = new Gson().fromJson(json, type);
        initData();
        setUpCalendar();
    }

    void setUpCalendar(){

        RangeDaysPickCallback callback = new RangeDaysPickCallback() {
            @Override
            public void onRangeDaysPicked(PrimeCalendar startDay, PrimeCalendar endDay) {

            }
        };

        LightThemeFactory themeFactory = new LightThemeFactory() {
            @Override
            public String getTypefacePath() {
                return "fonts/roboto_regular.ttf";
            }

            @Override
            public int getCalendarViewPickedDayInRangeBackgroundColor() {
                return R.color.colorPrimary;
            }

            @Override
            public int getCalendarViewPickedDayInRangeLabelTextColor() {
                return R.color.gray900;
            }

            @NotNull
            @Override
            public Function1<PrimeCalendar, String> getCalendarViewWeekLabelFormatter() {
                return super.getCalendarViewWeekLabelFormatter();
            }

        };
//
//            override val calendarViewPickedDayInRangeBackgroundColor: Int
//            get() = getColor(R.color.red100)
//
//            override val calendarViewPickedDayInRangeLabelTextColor: Int
//            get() = getColor(R.color.gray900)
//
//            override val calendarViewWeekLabelFormatter: LabelFormatter
//            get() = { primeCalendar ->
//                    when (primeCalendar[Calendar.DAY_OF_WEEK]) {
//                Calendar.SATURDAY,
//                        Calendar.SUNDAY -> String.format("%s😍", primeCalendar.weekDayNameShort)
//                else -> String.format("%s😁", primeCalendar.weekDayNameShort)
//            }
//
//
//            override val calendarViewWeekLabelTextColors: SparseIntArray
//            get() = SparseIntArray(7).apply {
//                val red = getColor(R.color.red300)
//                val green = getColor(R.color.green400)
//                put(Calendar.SATURDAY, red)
//                put(Calendar.SUNDAY, red)
//                put(Calendar.MONDAY, green)
//                put(Calendar.TUESDAY, green)
//                put(Calendar.WEDNESDAY, green)
//                put(Calendar.THURSDAY, green)
//                put(Calendar.FRIDAY, green)
//            }
//
//            // Other customizations...
//        }

        CivilCalendar today = new CivilCalendar();  // Causes a Civil date picker, also today as the starting date

        datePicker = PrimeDatePicker.Companion.bottomSheetWith(today) // or dialogWith(today)
                .pickRangeDays(callback)  // Passing callback is optional, can be set later using setDayPickCallback()
                .minPossibleDate(today)            // Optional
                .firstDayOfWeek(Calendar.MONDAY)// Optional
                .applyTheme(themeFactory)                    // Optional
                .build();
    }

    void initData(){
        if(house.getPhoto() != null && !house.getPhoto().equalsIgnoreCase("")){
            Glide.with(this)
                    .load(house.getPhoto())
                    .asBitmap()
                    .centerCrop()
                    .into(mPhotoImageView);
        }
        typeHouseTextView.setText(CommonUtils.getHouseType(house.getType()));
        titleTextView.setText(StringUtils.cutString(house.getTitle(), 50));
        addressTextView.setText(house.getAddress());
        HouseTabAdapter adapter = new HouseTabAdapter(getSupportFragmentManager() , house);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        descriptionTextView.setText(house.getDescription());
        if(house.getTotalReview() == 0){
            ratingContainerCardView.setVisibility(View.GONE);
        } else {
            ratingTextView.setText(String.valueOf(house.getRating()));
            ratingBar.setRating(house.getRating());
        }

        String reviewLabel = "Nhận xét " + "(" + house.getReviews().size() +")";
        mReviewLabelTextView.setText(reviewLabel);

        String photoLabel = "Hình ảnh " + "(" + house.getPhotos().size() +")";
        mPhotoLabelTextView.setText(photoLabel);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mReviewRecyclerView.setLayoutManager(layoutManager);
        mReviewRecyclerView.setItemAnimator(new DefaultItemAnimator());
        if(house.getReviews().size() > 2) {
            mReviewRecyclerView.setAdapter(new ReviewAdapter(house.getReviews().subList(0, 2)));
        } else
            mReviewRecyclerView.setAdapter(new ReviewAdapter(house.getReviews()));

        if(house.getPrice() != null) {
            if (house.getPromotion() == 0) {
                mPriceTextView.setText(StringUtils.toRate(house.getPrice()));

                mOldPriceTextView.setVisibility(View.GONE);
                mPriceTextView.setVisibility(View.VISIBLE);
            } else {
                mOldPriceTextView.setText(StringUtils.toRate(house.getPrice()));
                mPriceTextView.setText(StringUtils.toRate(house.getPrice(), house.getPromotion()));

                mOldPriceTextView.setVisibility(View.VISIBLE);
                mPriceTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    @OnClick(R.id.layout_house_back_icon)
    void onClickBackIcon(View view){
        finish();
    }

    @OnClick(R.id.layout_house_photos_more)
    void onClickPhotoLabel(View view){

    }

    @OnClick(R.id.layout_house_review_more)
    void onClickReviewLabel(View view){

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }

    private Marker createMarker (LatLng latLng){
        if (mMap == null) {
            return null;
        }
        if(mMarker != null) mMarker.remove();
        MarkerOptions mOptions = new MarkerOptions().position(latLng);
        mOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
        mMarker = mMap.addMarker(mOptions);
        return mMarker;
    }
}
