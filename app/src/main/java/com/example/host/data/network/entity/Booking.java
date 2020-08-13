package com.example.host.data.network.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Booking {
    @Expose
    @SerializedName("house_id")
    private int houseId;

    @Expose
    @SerializedName("host_id")
    private int hostId;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("photo")
    private String photo;

    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("guest_id")
    private int guestId;

    @Expose
    @SerializedName("state")
    private int state;

    @Expose
    @SerializedName("start_date")
    private int startDate;

    @Expose
    @SerializedName("end_date")
    private int endDate;

    @Expose
    @SerializedName("num_guest")
    private String numGuest;

    @Expose
    @SerializedName("cost")
    private int cost;

    @Expose
    @SerializedName("promotion")
    private int promotion;

    @Expose
    @SerializedName("adult")
    private String adult;

    @Expose
    @SerializedName("child")
    private String child;

    @Expose
    @SerializedName("time")
    private int time;

    @Expose
    @SerializedName("user_name")
    private String userName;

    @Expose
    @SerializedName("pic_url")
    private String picUrl;

    @Expose
    @SerializedName("price")
    private String price;

    @Expose
    @SerializedName("num_of_day")
    private int numOfDay;

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    public String getNumGuest() {
        return numGuest;
    }

    public void setNumGuest(String numGuest) {
        this.numGuest = numGuest;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getNumOfDay() {
        return numOfDay;
    }

    public void setNumOfDay(int numOfDay) {
        this.numOfDay = numOfDay;
    }
}
