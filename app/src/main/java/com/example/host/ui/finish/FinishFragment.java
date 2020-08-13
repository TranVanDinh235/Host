package com.example.host.ui.finish;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.host.R;
import com.example.host.di.component.ActivityComponent;
import com.example.host.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class FinishFragment extends BaseFragment implements FinishView{

    @Inject
    FinishPresenter<FinishView> mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_finish, container, false);

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

    }
}
