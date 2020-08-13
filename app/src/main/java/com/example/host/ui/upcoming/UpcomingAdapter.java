package com.example.host.ui.upcoming;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.host.R;
import com.example.host.data.network.entity.Booking;
import com.example.host.data.network.entity.House;
import com.example.host.ui.base.BaseViewHolder;
import com.example.host.utils.DateTimeUtils;
import com.example.host.utils.StringUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class UpcomingAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Booking> mHouseList;

    private Callback mCallback;

    public UpcomingAdapter(List<Booking> houses){
        this.mHouseList = houses;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_upcoming, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    public void clear(){
        mHouseList.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mHouseList.size();
    }

    public void addItem(List<Booking> houseList){
        mHouseList.addAll(houseList);
        notifyDataSetChanged();
    }

    public void setCallback(Callback callback){
        this.mCallback = callback;
    }

    public interface Callback {
        void onItemClick(Booking house);
    }

    public class ViewHolder extends BaseViewHolder{
        @BindView(R.id.item_upcoming_title)
        TextView mTitleTextView;

        @BindView(R.id.item_upcoming_photo)
        ImageView mPhotoImageView;

        @BindView(R.id.item_upcoming_guest_photo)
        CircleImageView mPhotoGuestImageView;

        @BindView(R.id.item_upcoming_time)
        TextView mTimeTextView;

        @BindView(R.id.item_upcoming_guest_name)
        TextView mNameTextView;

        @BindView(R.id.item_upcoming_num_guest)
        TextView mNumGuestTextView;

        @BindView(R.id.item_upcoming_state)
        TextView mStateTextView;

        private Booking mHouse;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallback.onItemClick(mHouse);
                }
            });
        }

        @Override
        protected void clear() {

        }

        @Override
        public void onBind(int position) {
            super.onBind(position);
            mHouse = mHouseList.get(position);

            if(mHouse.getTitle() != null) {
                mTitleTextView.setText(StringUtils.cutString(mHouse.getTitle(), 50));
            }

            if(mHouse.getUserName() != null){
                String name = "Khách: " + mHouse.getUserName();
                mNameTextView.setText(name);
            }

            if(mHouse.getPhoto() != null && !mHouse.getPhoto().equalsIgnoreCase("")){
                Glide.with(itemView.getContext())
                        .load(mHouse.getPhoto())
                        .asBitmap()
                        .centerCrop()
                        .into(mPhotoImageView);
            }

            if(mHouse.getPicUrl() != null && !mHouse.getPicUrl().equalsIgnoreCase("")){
                Glide.with(itemView.getContext())
                        .load(mHouse.getPicUrl())
                        .asBitmap()
                        .centerCrop()
                        .into(mPhotoGuestImageView);
            }

            if(mHouse.getNumGuest() != null && mHouse.getAdult() != null && mHouse.getChild() != null){
                String numGuest = mHouse.getNumGuest() + " khách: " + mHouse.getAdult() + " người lớn - " + mHouse.getChild() + " trẻ em";
                mNumGuestTextView.setText(numGuest);
            }

            String time = DateTimeUtils.houseDateToString(mHouse.getStartDate()) + " - "
                    + DateTimeUtils.houseDateToString(mHouse.getEndDate());

            mTimeTextView.setText(time);
        }

    }
}
