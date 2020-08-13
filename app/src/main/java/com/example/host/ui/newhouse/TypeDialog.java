package com.example.host.ui.newhouse;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.host.R;
import com.example.host.data.eventbus.HouseTypeEvent;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TypeDialog extends Dialog {

    public TypeDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_type);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.dialog_type_entire_house)
    void onEntireHouseClick(View view){
        EventBus.getDefault().post(new HouseTypeEvent(0, getContext().getString(R.string.entirehouse)));
        dismiss();
    }

    @OnClick(R.id.dialog_type_condominium)
    void onCondominiumClick(View view){
        EventBus.getDefault().post(new HouseTypeEvent(1, getContext().getString(R.string.condominium)));
        dismiss();
    }

    @OnClick(R.id.dialog_type_service_apartment)
    void onServiceApartmentClick(View view){
        EventBus.getDefault().post(new HouseTypeEvent(2, getContext().getString(R.string.service_apartment)));
        dismiss();
    }

    @OnClick(R.id.dialog_type_studio_apartment)
    void onStudioApartmentClick(View view){
        EventBus.getDefault().post(new HouseTypeEvent(3, getContext().getString(R.string.studio_apartment)));
        dismiss();
    }

    @OnClick(R.id.dialog_type_other)
    void onOtherClick(View view){
        EventBus.getDefault().post(new HouseTypeEvent(4, getContext().getString(R.string.other)));
        dismiss();
    }
}
