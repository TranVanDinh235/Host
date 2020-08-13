package com.example.host.ui.newhouse;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.host.R;
import com.example.host.ui.base.BaseViewHolder;
import com.rishabhharit.roundedimageview.RoundedImageView;

import java.io.File;
import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddPhotoAdapter extends RecyclerView.Adapter<AddPhotoAdapter.ViewHolder> {

    List<String> mPathPhotoList;
    List<Uri> mUriPhotoList;

    public AddPhotoAdapter(List<String> paths, List<Uri> uris){
        this.mPathPhotoList = paths;
        this.mUriPhotoList = uris;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_add_photo, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mPathPhotoList.size();
    }

    public class ViewHolder extends BaseViewHolder{
        @BindView(R.id.item_photo_imv)
        RoundedImageView mPhotoImageView;

        @BindView(R.id.item_photo_btn)
        ImageView mDeleteImageView;

        private String path;
        private Uri uri;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);
            path = mPathPhotoList.get(position);
            uri = mUriPhotoList.get(position);
            File file = new File(mPathPhotoList.get(position));
            if(file.exists()){
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(itemView.getContext().getContentResolver(), Uri.fromFile(file));
                    mPhotoImageView.setImageBitmap(bitmap);
                    int rotateImage = getCameraPhotoOrientation(itemView.getContext(), uri,
                            path);

                    mPhotoImageView.setRotation(rotateImage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        protected void clear() {

        }

        @OnClick(R.id.item_photo_btn)
        void deletePhoto(View view){
            mPathPhotoList.remove(path);
            notifyDataSetChanged();
        }


        public boolean onLongClick(View v) {
            return false;
        }
    }

    public int getCameraPhotoOrientation(Context context, Uri imageUri,
                                         String imagePath) {
        int rotate = 0;
        try {
            context.getContentResolver().notifyChange(imageUri, null);
            File imageFile = new File(imagePath);
            ExifInterface exif = new ExifInterface(imageFile.getAbsolutePath());
            int orientation = exif.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);

            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_270:
                    rotate = 270;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    rotate = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_90:
                    rotate = 90;
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rotate;
    }
}
