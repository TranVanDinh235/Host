package com.example.host.data.network.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HouseBody {
    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("type")
    private int type;

    @Expose
    @SerializedName("price")
    private int price;

    @Expose
    @SerializedName("guest")
    private int guest;

    @Expose
    @SerializedName("max_guest")
    private int maxGuest;

    @Expose
    @SerializedName("addition_fee")
    private int addition_fee;

    @Expose
    @SerializedName("promotion")
    private int promotion;

    @Expose
    @SerializedName("description")
    private String description;

    @Expose
    @SerializedName("house_rule")
    private String houseRule;

    @Expose
    @SerializedName("bed_room")
    private int bedRoom;

    @Expose
    @SerializedName("bath_room")
    private int bathRoom;

    @Expose
    @SerializedName("bed")
    private int bed;

    @Expose
    @SerializedName("host_id")
    private int hostId;

    @Expose
    @SerializedName("facilities")
    private String facilities;

    @Expose
    @SerializedName("room_facilities")
    private String roomFacilities;

    @Expose
    @SerializedName("kitchen_facilities")
    private String kitchenFacilities;

    @Expose
    @SerializedName("special_facilities")
    private String specialFacilities;

    @Expose
    @SerializedName("entertainment")
    private String entertainment;

    @Expose
    @SerializedName("families")
    private String families;

    @Expose
    @SerializedName("address")
    private String address;

    @Expose
    @SerializedName("city")
    private String city;

    @Expose
    @SerializedName("check_in")
    private String checkIn;

    @Expose
    @SerializedName("check_out")
    private String checkOut;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGuest() {
        return guest;
    }

    public void setGuest(int guest) {
        this.guest = guest;
    }

    public int getMaxGuest() {
        return maxGuest;
    }

    public void setMaxGuest(int maxGuest) {
        this.maxGuest = maxGuest;
    }

    public int getAddition_fee() {
        return addition_fee;
    }

    public void setAddition_fee(int addition_fee) {
        this.addition_fee = addition_fee;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHouseRule() {
        return houseRule;
    }

    public void setHouseRule(String houseRule) {
        this.houseRule = houseRule;
    }

    public int getBedRoom() {
        return bedRoom;
    }

    public void setBedRoom(int bedRoom) {
        this.bedRoom = bedRoom;
    }

    public int getBathRoom() {
        return bathRoom;
    }

    public void setBathRoom(int bathRoom) {
        this.bathRoom = bathRoom;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getRoomFacilities() {
        return roomFacilities;
    }

    public void setRoomFacilities(String roomFacilities) {
        this.roomFacilities = roomFacilities;
    }

    public String getKitchenFacilities() {
        return kitchenFacilities;
    }

    public void setKitchenFacilities(String kitchenFacilities) {
        this.kitchenFacilities = kitchenFacilities;
    }

    public String getSpecialFacilities() {
        return specialFacilities;
    }

    public void setSpecialFacilities(String specialFacilities) {
        this.specialFacilities = specialFacilities;
    }

    public String getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(String entertainment) {
        this.entertainment = entertainment;
    }

    public String getFamilies() {
        return families;
    }

    public void setFamilies(String families) {
        this.families = families;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }
}
