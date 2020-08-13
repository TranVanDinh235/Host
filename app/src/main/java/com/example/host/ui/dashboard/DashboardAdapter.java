package com.example.host.ui.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.host.R;
import com.example.host.data.network.entity.House;
import com.example.host.ui.base.BaseViewHolder;
import com.example.host.utils.StringUtils;
import com.rishabhharit.roundedimageview.RoundedImageView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<House> mHouseList;
    private Callback mCallback;

    @Inject
    public DashboardAdapter(List<House> houses){
        this.mHouseList = houses;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dashboard, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mHouseList.size();
    }

    public void addItem(List<House> houseList){
        mHouseList.addAll(houseList);
        notifyDataSetChanged();
    }

    public void setCallback(Callback callback){
        this.mCallback = callback;
    }

    public interface Callback {
        void onItemClick(House house);
    }

    public class ViewHolder extends BaseViewHolder implements View.OnClickListener{

        @BindView(R.id.item_dashboard_photo)
        RoundedImageView mPhotoImageView;

        @BindView(R.id.item_dashboard_title)
        TextView mTitleTextView;

        @BindView(R.id.item_dashboard_address)
        TextView mAddressTextView;

        @BindView(R.id.item_dashboard_review)
        TextView mReviewTextView;

        @BindView(R.id.item_dashboard_price)
        TextView mPriceTextView;

        @BindView(R.id.item_dashboard_rating)
        RatingBar mRatingBar;

        private House mHouse;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        protected void clear() {

        }

        @Override
        public void onBind(int position) {
            super.onBind(position);
            this.mHouse = mHouseList.get(position);

            if(mHouse.getAddress() != null) {
                mAddressTextView.setText(mHouse.getAddress());
            }

            if(mHouse.getTitle() != null) {
                mTitleTextView.setText(StringUtils.cutString(mHouse.getTitle(), 50));
            }

            if(mHouse.getPrice() != null) {
                mPriceTextView.setText(StringUtils.toRate(mHouse.getPrice()));
            }

            if(mHouse.getTotalReview() == 0){
                mRatingBar.setVisibility(View.GONE);
                mReviewTextView.setVisibility(View.GONE);
            } else {
                String review = "(" + mHouse.getTotalReview() + ")";
                mReviewTextView.setText(review);
                mRatingBar.setRating(mHouse.getRating());
                mRatingBar.setVisibility(View.VISIBLE);
                mReviewTextView.setVisibility(View.VISIBLE);
            }

            if(mHouse.getPhoto() != null && !mHouse.getPhoto().equalsIgnoreCase("")){
                Glide.with(itemView.getContext())
                        .load(mHouse.getPhoto())
                        .asBitmap()
                        .centerCrop()
                        .into(mPhotoImageView);
            }
        }

        @Override
        public void onClick(View v) {
            mCallback.onItemClick(mHouse);
        }
    }
}
