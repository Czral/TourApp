package com.example.android.tourapp;

/**
 * Created by XXX on 13-Mar-18.
 */

public class HistoryElement {

    private int mImage;

    private String mName;

    private String mAddress;

    private String mHoursMonday;

    private String mHoursTuesday;

    private String mHoursWednesday;

    private String mHoursThursday;

    private String mHoursFriday;

    private String mHoursSaturday;

    private String mHoursSunday;

    private String mPhone;

    private float mRating;

    public HistoryElement(int image, String name, String address,
                          String hoursMonday, String hoursTuesday, String hoursWednesday, String hoursThursday, String hoursFriday, String hoursSaturday, String hoursSunday,
                          String phone, float rating) {

        mImage = image;
        mName = name;
        mAddress = address;
        mHoursMonday = hoursMonday;
        mHoursTuesday = hoursTuesday;
        mHoursWednesday = hoursWednesday;
        mHoursThursday = hoursThursday;
        mHoursFriday = hoursFriday;
        mHoursSaturday = hoursSaturday;
        mHoursSunday = hoursSunday;
        mPhone = phone;
        mRating = rating;

    }

    public int getImage() {
        return mImage;
    }

    public String getName() {
        return mName;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getHoursMonday() {
        return mHoursMonday;
    }

    public String getHoursTuesday() {
        return mHoursTuesday;
    }

    public String getHoursWednesday() {
        return mHoursWednesday;
    }

    public String getHoursThursday() {
        return mHoursThursday;
    }

    public String getHoursFriday() {
        return mHoursFriday;
    }

    public String getHoursSaturday() {
        return mHoursSaturday;
    }

    public String getHoursSunday() {
        return mHoursSunday;
    }

    public String getPhone() {
        return mPhone;
    }

    public float getRating() {
        return mRating;
    }

}