package com.example.android.tourapp;

/**
 * Created by XXX on 14-Mar-18.
 */

public class FoodElement {

    private String mName;

    private String mAddress;

    private String mPhone;

    private float mService;

    private float mFood;

    private float mValue;

    public FoodElement(String name, String address, String phone, float service, float food, float value) {

        mName = name;
        mAddress = address;
        mPhone = phone;
        mService = service;
        mFood = food;
        mValue = value;

    }

    public String getName() {
        return mName;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getPhone() {
        return mPhone;
    }

    public float getService() {
        return mService;
    }

    public float getFood() {
        return mFood;
    }

    public float getValue() {
        return mValue;
    }

}