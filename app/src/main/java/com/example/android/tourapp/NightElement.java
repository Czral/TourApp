package com.example.android.tourapp;

/**
 * Created by XXX on 15-Mar-18.
 */

public class NightElement {

    private String mName;
    private String mAddress;
    private String mPhone;
    private String mDescription;
    private String mHours;

    public NightElement(String name,
                        String address,
                        String phone,
                        String description,
                        String hours) {

        mName = name;
        mAddress = address;
        mPhone = phone;
        mDescription = description;
        mHours = hours;
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

    public String getDescription() {
        return mDescription;
    }

    public String getHours() {
        return mHours;
    }

}