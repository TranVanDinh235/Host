package com.example.host.ui.preview;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;

import com.example.host.R;
import com.example.host.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class PreviewActivity extends BaseActivity implements PreviewView{

    @Inject
    PreviewPresenter<PreviewView> mPresenter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_preview);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);

        setUp();
    }

    @Override
    protected void setUp() {

    }
}
