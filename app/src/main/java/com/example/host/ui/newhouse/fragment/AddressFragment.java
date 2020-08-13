package com.example.host.ui.newhouse.fragment;

import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.aminography.primecalendar.PrimeCalendar;
import com.aminography.primecalendar.civil.CivilCalendar;
import com.aminography.primecalendar.common.CalendarFactory;
import com.aminography.primecalendar.common.CalendarType;
import com.aminography.primedatepicker.calendarview.PrimeCalendarView;
import com.aminography.primedatepicker.common.OnDayPickedListener;
import com.aminography.primedatepicker.common.PickType;
import com.example.host.R;
import com.example.host.data.network.request.HouseBody;
import com.example.host.di.component.ActivityComponent;
import com.example.host.ui.base.BaseFragment;
import com.example.host.utils.DateTimeUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.facebook.FacebookSdk.getApplicationContext;

public class AddressFragment extends BaseFragment{

    @BindView(R.id.primeCalendarView)
    PrimeCalendarView primeCalendarView;

    @BindView(R.id.layout_address_pick_all)
    TextView mPickAllTextView;

    @BindView(R.id.layout_address_check_in)
    TextView mCheckInEditText;

    @BindView(R.id.layout_address_check_out)
    TextView mCheckOutEditText;

    private HouseBody mHouse;
    private TabLayout tabLayout;

    private List<PrimeCalendar> selected = new ArrayList<>();
    private String city = "";
    private String address = "";
    private PrimeCalendar start;
    private PrimeCalendar end;

    public AddressFragment(HouseBody house, TabLayout tabLayout){
        this.mHouse = house;
        this.tabLayout = tabLayout;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_address, container, false);
        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), getString(R.string.api_key));
        }
        PlacesClient placesClient = Places.createClient(getApplicationContext());

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

        primeCalendarView.setTypeface(Typeface.DEFAULT);
        primeCalendarView.goTo(CalendarFactory.newInstance(CalendarType.CIVIL), false);
        primeCalendarView.setLocale(new Locale("vi", "VN"));
        primeCalendarView.setFlingOrientation(PrimeCalendarView.FlingOrientation.HORIZONTAL);
        primeCalendarView.setPickType(PickType.MULTIPLE);

        start = new CivilCalendar();
        end = new CivilCalendar();
        end.add(Calendar.MONTH, 6);

        primeCalendarView.setMinDateCalendar(start);
        primeCalendarView.setMaxDateCalendar(end);
        primeCalendarView.setOnDayPickedListener(new OnDayPickedListener() {
            @Override
            public void onDayPicked(PickType pickType, @Nullable PrimeCalendar singleDay, @Nullable PrimeCalendar startDay, @Nullable PrimeCalendar endDay, List<PrimeCalendar> multipleDays) {
                selected.clear();
                selected.addAll(multipleDays);
            }
        });
        setUpAutoCompleteText();

    }

    private void setUpAutoCompleteText(){
        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getChildFragmentManager().findFragmentById(R.id.autocomplete_fragment);

        // Specify the types of place data to return.
        if (autocompleteFragment != null) {
            autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG));
            // Set up a PlaceSelectionListener to handle the response.

            autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
                @Override
                public void onPlaceSelected(@NonNull Place place) {
                    // TODO: Get info about the selected place.
                    try {
                        Geocoder gcd = new Geocoder(getContext(), Locale.getDefault());
                        List<Address> addresses = gcd.getFromLocation(place.getLatLng().latitude, place.getLatLng().longitude, 1);
                        if (addresses.size() > 0) {
                            city = addresses.get(0).getAdminArea();
                            address = addresses.get(0).getAddressLine(0);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public void onError(@NonNull Status status) {
                    Log.i("dinh", "status" + status.getStatusMessage());
                }
            });
        }
    }

    @OnClick(R.id.layout_address_pick_all)
    void onPickAllClick(View view){
        PrimeCalendar calendar = primeCalendarView.getFirstDayOfMonthCalendar();
        if (calendar == null) return;
        for(int i = 0; i < selected.size(); i ++){
            if(selected.get(i).get(Calendar.YEAR) == calendar.get(Calendar.YEAR) && selected.get(i).get(Calendar.MONTH) == calendar.get(Calendar.MONTH)){
                selected.remove(i);
                i++;
            }
        }
        do{
            if (calendar.after(start) && calendar.before(end)) selected.add(calendar.clone());
            calendar.add(Calendar.DATE, 1);
        } while (calendar.getDayOfMonth() != 1);
        primeCalendarView.setPickedMultipleDaysList(selected);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("TAG", "onPause: add");
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @OnClick(R.id.layout_address_continue)
    void onContinueClick(View view){
        mHouse.setCity(city);
        mHouse.setAddress(address);
        mHouse.setCheckIn(mCheckInEditText.getText().toString());
        mHouse.setCheckOut(mCheckOutEditText.getText().toString());
//        List<Long> dates = DateTimeUtils.primeCalendarToHouseDate(selected);
//        mHouse.setDates(dates);
        TabLayout.Tab tab = tabLayout.getTabAt(3);
        tab.select();
    }
}
