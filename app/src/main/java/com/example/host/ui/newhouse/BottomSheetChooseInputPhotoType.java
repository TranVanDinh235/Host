package com.example.host.ui.newhouse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.host.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class BottomSheetChooseInputPhotoType extends BottomSheetDialogFragment {

    private Callback mCallback;

    public BottomSheetChooseInputPhotoType(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.bottom_sheet_image, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @OnClick(R.id.bottom_sheet_image_camera)
    void onCameraClick(View v){
        mCallback.onCameraClick();
    }

    @OnClick(R.id.bottom_sheet_image_galley)
    void onGalleyClick(View v){
        mCallback.onGalleyClick();
    }

    public void setCallback(Callback callback){
        this.mCallback = callback;
    }

    public interface Callback{
        void onCameraClick();
        void onGalleyClick();
    }
}
