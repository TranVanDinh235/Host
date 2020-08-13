package com.example.host.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.host.R;
import com.example.host.di.component.ActivityComponent;
import com.example.host.ui.base.BaseFragment;
import com.example.host.ui.newhouse.NewHouseTabAdapter;
import com.example.host.ui.zxing.CaptureActivity;
import com.example.host.utils.AppConstants;
import com.google.android.material.tabs.TabLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;

public class HomeFragment extends BaseFragment implements HomeView{

    public final static int SCANNING_REQUEST_CODE = 1;

    @Inject
    HomePresenter<HomeView> mPresenter;

    @BindView(R.id.layout_home_camera)
    CircleImageView mCameraImageView;

    @BindView(R.id.layout_home_tab_bar)
    TabLayout tabLayout;

    @BindView(R.id.layout_home_vp)
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);


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
        HomeTabAdapter adapter = new HomeTabAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @OnClick(R.id.layout_home_camera)
    void onButtonCameraClick(View view){
        Intent intent = new Intent(getActivity(), CaptureActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(intent, AppConstants.SCANNING_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case SCANNING_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    final Bundle bundle = data.getExtras();
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            assert bundle != null;
                            getData(bundle.getString("result"));
                        }
                    });
                }
                break;
            default:
                break;
        }
    }

    void getData(String result){
        Toast.makeText(getContext(), result, Toast.LENGTH_LONG).show();
    }
}
