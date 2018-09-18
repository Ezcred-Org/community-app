/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */

package com.mifos.objects.organisation;

import android.os.Parcel;
import android.os.Parcelable;

import com.mifos.api.local.MifosBaseModel;
import com.mifos.api.local.MifosDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ishankhanna on 14/07/14.
 */
@Table(database = MifosDatabase.class)
@ModelContainer
public class Office extends MifosBaseModel implements Parcelable {

    @PrimaryKey
    Integer id;

    @Column
    String externalId;

    @Column
    String name;

    @Column
    Long addressId;

    @Column
    String nameDecorated;

    @Column
    @ForeignKey(saveForeignKeyModel = true)
    OfficeOpeningDate officeOpeningDate;

    List<Integer> openingDate = new ArrayList<Integer>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameDecorated() {
        return nameDecorated;
    }

    public void setNameDecorated(String nameDecorated) {
        this.nameDecorated = nameDecorated;
    }

    public List<Integer> getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(List<Integer> openingDate) {
        this.openingDate = openingDate;
    }

    public OfficeOpeningDate getOfficeOpeningDate() {
        return this.officeOpeningDate;
    }

    public void setOfficeOpeningDate(OfficeOpeningDate officeOpeningDate) {
        this.officeOpeningDate = officeOpeningDate;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId (Long addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", externalId='" + externalId + '\'' +
                ", name='" + name + '\'' +
                ", addressId='" + addressId + '\'' +
                ", nameDecorated='" + nameDecorated + '\'' +
                ", officeOpeningDate=" + officeOpeningDate +
                ", openingDate=" + openingDate +
                '}';
    }

    public Office() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.externalId);
        dest.writeString(this.name);
        dest.writeLong(this.addressId);
        dest.writeString(this.nameDecorated);
        dest.writeParcelable(this.officeOpeningDate, flags);
        dest.writeList(this.openingDate);
    }

    protected Office(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.externalId = in.readString();
        this.name = in.readString();
        this.addressId = in.readLong();
        this.nameDecorated = in.readString();
        this.officeOpeningDate = in.readParcelable(OfficeOpeningDate.class.getClassLoader());
        this.openingDate = new ArrayList<Integer>();
        in.readList(this.openingDate, Integer.class.getClassLoader());
    }

    public static final Creator<Office> CREATOR = new Creator<Office>() {
        @Override
        public Office createFromParcel(Parcel source) {
            return new Office(source);
        }

        @Override
        public Office[] newArray(int size) {
            return new Office[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Office)) return false;

        Office office = (Office) o;

        if (id != null ? !id.equals(office.id) : office.id != null) return false;
        if (externalId != null ? !externalId.equals(office.externalId) : office.externalId != null)
            return false;
        if (name != null ? !name.equals(office.name) : office.name != null) return false;
        if (addressId != null ? !addressId.equals(office.addressId) : office.addressId != null)
            return false;
        if (nameDecorated != null ? !nameDecorated.equals(office.nameDecorated) : office.nameDecorated != null)
            return false;
        if (officeOpeningDate != null ? !officeOpeningDate.equals(office.officeOpeningDate) : office.officeOpeningDate != null)
            return false;
        return openingDate != null ? openingDate.equals(office.openingDate) : office.openingDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (externalId != null ? externalId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (addressId != null ? addressId.hashCode() : 0);
        result = 31 * result + (nameDecorated != null ? nameDecorated.hashCode() : 0);
        result = 31 * result + (officeOpeningDate != null ? officeOpeningDate.hashCode() : 0);
        result = 31 * result + (openingDate != null ? openingDate.hashCode() : 0);
        return result;
    }
}
