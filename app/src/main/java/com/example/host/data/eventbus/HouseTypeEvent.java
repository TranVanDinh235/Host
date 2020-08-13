package com.example.host.data.eventbus;

public class HouseTypeEvent {
    private int type;
    private String typeHouse;

    public HouseTypeEvent(int type) {
        this.type = type;
    }

    public HouseTypeEvent(int type, String typeHouse) {
        this.type = type;
        this.typeHouse = typeHouse;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeHouse() {
        return typeHouse;
    }

    public void setTypeHouse(String typeHouse) {
        this.typeHouse = typeHouse;
    }
}
