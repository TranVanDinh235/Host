package com.example.host.ui.newhouse.fragment;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.host.R;
import com.example.host.data.network.request.HouseBody;
import com.example.host.di.component.ActivityComponent;
import com.example.host.ui.base.BaseFragment;
import com.example.host.ui.newhouse.AddPhotoAdapter;
import com.example.host.ui.newhouse.BottomSheetChooseInputPhotoType;
import com.example.host.ui.newhouse.NewHousePresenter;
import com.example.host.ui.newhouse.NewHouseView;
import com.example.host.utils.AppConstants;
import com.example.host.utils.CommonUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;
import static com.example.host.utils.AppConstants.REQUEST_IMAGE_CAPTURE;
import static com.example.host.utils.AppConstants.REQUEST_IMAGE_GALLEY;
import static com.facebook.FacebookSdk.getApplicationContext;

public class PhotoFragment extends BaseFragment implements BottomSheetChooseInputPhotoType.Callback{

    @BindView(R.id.layout_photo_rv)
    RecyclerView mPhotoRecyclerView;

    private BottomSheetChooseInputPhotoType mBottomSheet;
    private AddPhotoAdapter mAdapter;

    private List<String> mPathImageList = new ArrayList<>();
    private List<Uri> mUriImageList = new ArrayList<>();
    private String mPathImageCapture;
    private Uri mUriImageCapture;

    private NewHousePresenter<NewHouseView> mPresenter;
    private HouseBody mHouse;

    public PhotoFragment(HouseBody house, NewHousePresenter<NewHouseView> presenter){
        this.mHouse = house;
        this.mPresenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_photo, container, false);

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
        mAdapter = new AddPhotoAdapter(mPathImageList, mUriImageList);
        mPhotoRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
        mPhotoRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mPhotoRecyclerView.setNestedScrollingEnabled(false);
        mPhotoRecyclerView.setAdapter(mAdapter);


    }

    @OnClick(R.id.layout_photo_btn)
    void onAddPhotoClick(View v){
        mBottomSheet = new BottomSheetChooseInputPhotoType();
        mBottomSheet.setCallback(this);
        mBottomSheet.show(getChildFragmentManager(), AppConstants.TAG_BOTTOM_SHEET_PHOTO);
    }

    @Override
    public void onCameraClick() {
        mBottomSheet.dismiss();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = timeStamp + ".jpg";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        mPathImageCapture = storageDir.getAbsolutePath() + "/" + imageFileName;
        File file = new File(mPathImageCapture);
        Uri outputFileUri = FileProvider.getUriForFile(getApplicationContext(),  "com.example.host.fileprovider" , file);
        mUriImageCapture = outputFileUri;

        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
        startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE);
    }

    @Override
    public void onGalleyClick() {
        mBottomSheet.dismiss();
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"), REQUEST_IMAGE_GALLEY);
    }

    @OnClick(R.id.layout_photo_preview)
    void onClickNext(View view){
        if(validateHouse()) {
            List<File> files = new ArrayList<>();
            for (int i = 0; i < mPathImageList.size(); i++) {
                File file = new File(mPathImageList.get(i));
                files.add(file);
            }
            mPresenter.newHouse(mHouse, files);
        }
    }

    boolean validateHouse(){
        if(mHouse.getTitle() == null || TextUtils.isEmpty(mHouse.getTitle())) return false;
        if(mHouse.getDescription() == null || TextUtils.isEmpty(mHouse.getDescription())) return false;
        if(mHouse.getHouseRule() == null || TextUtils.isEmpty(mHouse.getHouseRule())) return false;
        if(mHouse.getCheckIn() == null || TextUtils.isEmpty(mHouse.getCheckIn())) return false;
        if(mHouse.getCheckOut() == null || TextUtils.isEmpty(mHouse.getCheckOut())) return false;
        if(mHouse.getCity() == null || TextUtils.isEmpty(mHouse.getCity())) return false;
        if(mHouse.getAddress() == null || TextUtils.isEmpty(mHouse.getAddress())) return false;
        if(mHouse.getType() == -1) return false;
        if(mHouse.getPrice() == 0) return false;
        if(mHouse.getGuest() == 0) return false;
        if(mHouse.getMaxGuest() == 0) return false;
        if(mHouse.getBathRoom() == 0) return false;
        if(mHouse.getBedRoom() == 0) return false;
        if(mHouse.getBed() == 0) return false;
//        if(mHouse.getDates() == null || mHouse.getDates().size() == 0) return false;
        if(mPathImageList.size() < 5) return false;
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_IMAGE_CAPTURE:
                    File imgFile = new File(mPathImageCapture);
                    if(imgFile.exists()){
                        mPathImageList.add(mPathImageCapture);
                        mUriImageList.add(mUriImageCapture);
                    }
                    mAdapter.notifyDataSetChanged();
                    break;
                case REQUEST_IMAGE_GALLEY:
                    if (data.getData() != null) {
                        Uri imageUri = data.getData();
                        mUriImageList.add(imageUri);
                        mPathImageList.add(CommonUtils.getPath(getApplicationContext(), imageUri));
                    } else {
                        ClipData clipData = data.getClipData();
                        for(int index = 0; index < clipData.getItemCount(); index ++){
                            ClipData.Item item = clipData.getItemAt(index);
                            mPathImageList.add(CommonUtils.getPath(getApplicationContext(), item.getUri()));
                            mUriImageList.add(item.getUri());
                        }
                    }
                    mAdapter.notifyDataSetChanged();
                    break;
            }
        }
    }
}
