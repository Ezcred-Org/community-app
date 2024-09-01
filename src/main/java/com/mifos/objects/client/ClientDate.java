package com.mifos.objects.client;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.mifos.api.local.MifosBaseModel;
import com.mifos.api.local.MifosDatabase;




/**
 * Created by Rajan Maurya on 04/07/16.
 */

public class ClientDate extends MifosBaseModel implements Parcelable {

    
    @SerializedName("clientId")
    long clientId;

    
    @SerializedName("chargeId")
    long chargeId;

    
    @SerializedName("day")
    int day;

    
    @SerializedName("month")
    int month;

    
    @SerializedName("year")
    int year;

    public ClientDate(long clientId, long chargeId, int day, int month, int year) {
        this.clientId = clientId;
        this.chargeId = chargeId;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.clientId);
        dest.writeInt(this.day);
        dest.writeInt(this.month);
        dest.writeInt(this.year);
    }

    public ClientDate() {
    }

    protected ClientDate(Parcel in) {
        this.clientId = in.readLong();
        this.day = in.readInt();
        this.month = in.readInt();
        this.year = in.readInt();
    }

    public static final Parcelable.Creator<ClientDate> CREATOR = new Parcelable
            .Creator<ClientDate>() {
        @Override
        public ClientDate createFromParcel(Parcel source) {
            return new ClientDate(source);
        }

        @Override
        public ClientDate[] newArray(int size) {
            return new ClientDate[size];
        }
    };
}
