package com.example.host.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.host.R;
import com.example.host.data.network.entity.User;
import com.example.host.di.component.ActivityComponent;
import com.example.host.ui.base.BaseFragment;
import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends BaseFragment implements ProfileView{

    @Inject
    ProfilePresenter<ProfileView> mPresenter;

    @BindView(R.id.layout_profile_photo)
    CircleImageView mPhotoImageView;

    @BindView(R.id.layout_profile_user_name)
    TextView mUsernameTextView;

    private User mUser;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);


        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, root));
            mPresenter.onAttach(this);
        }
        return root;
    }

    @Override
    protected void setUp(View root) {
        mPresenter.getUserData();
    }

    @OnClick(R.id.layout_profile_user_name)
    void onUserNameClick(View view){
//        Intent intent = new Intent(getActivity(), InfoActivity.class);
//        intent.putExtra(AppConstants.TAG_DATA_USER, new Gson().toJson(mUser));
//        startActivity(intent);
    }

    @Override
    public void loadData(User user) {
        this.mUser = user;
        if(user.getPic() != null) {
            Glide.with(getActivity())
                    .load(user.getPic())
                    .asBitmap()
                    .centerCrop()
                    .into(mPhotoImageView);
        }

        if(user.getName() != null){
            mUsernameTextView.setText(user.getName());
        }
    }
}
