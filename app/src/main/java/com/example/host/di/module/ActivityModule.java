package com.example.host.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.host.di.ActivityContext;
import com.example.host.ui.booking.BookingPresenter;
import com.example.host.ui.booking.BookingPresenterImpl;
import com.example.host.ui.booking.BookingView;
import com.example.host.ui.dashboard.DashboardAdapter;
import com.example.host.ui.dashboard.DashboardPresenter;
import com.example.host.ui.dashboard.DashboardPresenterImpl;
import com.example.host.ui.dashboard.DashboardView;
import com.example.host.ui.house.HousePresenter;
import com.example.host.ui.house.HousePresenterImpl;
import com.example.host.ui.house.HouseView;
import com.example.host.ui.finish.FinishAdapter;
import com.example.host.ui.finish.FinishPresenter;
import com.example.host.ui.finish.FinishPresenterImpl;
import com.example.host.ui.finish.FinishView;
import com.example.host.ui.home.HomePresenter;
import com.example.host.ui.home.HomePresenterImpl;
import com.example.host.ui.home.HomeView;
import com.example.host.ui.login.LoginPresenter;
import com.example.host.ui.login.LoginPresenterImpl;
import com.example.host.ui.login.LoginView;
import com.example.host.ui.main.MainPresenter;
import com.example.host.ui.main.MainPresenterImpl;
import com.example.host.ui.main.MainView;
import com.example.host.ui.newhouse.NewHousePresenter;
import com.example.host.ui.newhouse.NewHousePresenterImpl;
import com.example.host.ui.newhouse.NewHouseView;
import com.example.host.ui.preview.PreviewPresenter;
import com.example.host.ui.preview.PreviewPresenterImpl;
import com.example.host.ui.preview.PreviewView;
import com.example.host.ui.profile.ProfilePresenter;
import com.example.host.ui.profile.ProfilePresenterImpl;
import com.example.host.ui.profile.ProfileView;
import com.example.host.ui.review.ReviewAdapter;
import com.example.host.ui.splash.SplashPresenter;
import com.example.host.ui.splash.SplashPresenterImpl;
import com.example.host.ui.splash.SplashView;
import com.example.host.ui.upcoming.UpcomingAdapter;
import com.example.host.ui.upcoming.UpcomingPresenter;
import com.example.host.ui.upcoming.UpcomingPresenterImpl;
import com.example.host.ui.upcoming.UpcomingView;
import com.example.host.utils.rx.AppSchedulerProvider;
import com.example.host.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    HomePresenter<HomeView> provideHomePresenter(
            HomePresenterImpl<HomeView> presenter) {
        return presenter;
    }

    @Provides
    DashboardPresenter<DashboardView> provideDashboardPresenter(
            DashboardPresenterImpl<DashboardView> presenter) {
        return presenter;
    }

    @Provides
    MainPresenter<MainView> provideMainPresenter(
            MainPresenterImpl<MainView> presenter) {
        return presenter;
    }

    @Provides
    LoginPresenter<LoginView> provideLoginPresenter(
            LoginPresenterImpl<LoginView> presenter) {
        return presenter;
    }

    @Provides
    SplashPresenter<SplashView> provideSplashPresenter(
            SplashPresenterImpl<SplashView> presenter) {
        return presenter;
    }

    @Provides
    UpcomingPresenter<UpcomingView> provideUpcomingPresenter(
            UpcomingPresenterImpl<UpcomingView> presenter) {
        return presenter;
    }

    @Provides
    ProfilePresenter<ProfileView> provideProfilePresenter(
            ProfilePresenterImpl<ProfileView> presenter) {
        return presenter;
    }

    @Provides
    BookingPresenter<BookingView> provideBookingPresenter(
            BookingPresenterImpl<BookingView> presenter) {
        return presenter;
    }

    @Provides
    NewHousePresenter<NewHouseView> provideNewHousePresenter(
            NewHousePresenterImpl<NewHouseView> presenter) {
        return presenter;
    }

    @Provides
    FinishPresenter<FinishView> provideFinishPresenter(
            FinishPresenterImpl<FinishView> presenter) {
        return presenter;
    }

    @Provides
    PreviewPresenter<PreviewView> providePreviewPresenter(
            PreviewPresenterImpl<PreviewView> presenter) {
        return presenter;
    }

    @Provides
    HousePresenter<HouseView> provideDetailPresenter(
            HousePresenterImpl<HouseView> presenter) {
        return presenter;
    }

    @Provides
    UpcomingAdapter provideUpcomingAdapter() {
        return new UpcomingAdapter(new ArrayList<>());
    }

    @Provides
    FinishAdapter provideFinishAdapter() {
        return new FinishAdapter(new ArrayList<>());
    }

    @Provides
    DashboardAdapter provideHouseAdapter() {
        return new DashboardAdapter(new ArrayList<>());
    }

    @Provides
    ReviewAdapter provideReviewAdapter() {
        return new ReviewAdapter(new ArrayList<>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity){
        return new LinearLayoutManager(activity){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
    }
}
