package com.example.host.di.component;

import com.example.host.di.PerActivity;
import com.example.host.di.module.ActivityModule;
import com.example.host.ui.booking.BookingActivity;
import com.example.host.ui.house.HouseActivity;
import com.example.host.ui.dashboard.DashboardFragment;
import com.example.host.ui.finish.FinishFragment;
import com.example.host.ui.home.HomeFragment;
import com.example.host.ui.login.LoginActivity;
import com.example.host.ui.main.MainActivity;
import com.example.host.ui.newhouse.NewHouseActivity;
import com.example.host.ui.newhouse.fragment.AddressFragment;
import com.example.host.ui.newhouse.fragment.FacilitiesFragment;
import com.example.host.ui.newhouse.fragment.PhotoFragment;
import com.example.host.ui.newhouse.fragment.TitleFragment;
import com.example.host.ui.preview.PreviewActivity;
import com.example.host.ui.profile.ProfileFragment;
import com.example.host.ui.splash.SplashActivity;
import com.example.host.ui.upcoming.UpcomingFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);

    void inject(LoginActivity loginActivity);

    void inject(SplashActivity splashActivity);

    void inject(ProfileFragment profileFragment);

    void inject(DashboardFragment dashboardFragment);

    void inject(HomeFragment homeFragment);

    void inject(UpcomingFragment upcomingFragment);

    void inject(FinishFragment finishFragment);

    void inject(NewHouseActivity newHouseActivity);

    void inject(TitleFragment titleFragment);

    void inject(FacilitiesFragment facilitiesFragment);

    void inject(AddressFragment addressFragment);

    void inject(PhotoFragment photoFragment);

    void inject(BookingActivity bookingActivity);

    void inject(PreviewActivity previewActivity);

    void inject(HouseActivity houseActivity);
}
