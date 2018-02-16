package com.mifos.objects.client;
/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.mifos.api.local.MifosBaseModel;
import com.mifos.api.local.MifosDatabase;
import com.mifos.objects.noncore.DataTablePayload;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import lombok.Getter;

/**
 * Created by ADMIN on 16-Jun-15.
 */
@Table(database = MifosDatabase.class)
@ModelContainer
public class ClientPayload extends MifosBaseModel implements Parcelable {

    @PrimaryKey(autoincrement = true)
    transient Long id;

    @Column
    transient Long clientCreationTime;

    @Column
    transient String errorMessage;

    @SerializedName("firstname")
    @Column
    String firstname;

    @SerializedName("lastname")
    @Column
    String lastname;

    @SerializedName("middlename")
    @Column
    String middlename;

    @SerializedName("officeId")
    @Column
    Integer officeId;

    @SerializedName("staffId")
    @Column
    Integer staffId;

    @SerializedName("genderId")
    @Column
    Integer genderId;

    @SerializedName("active")
    @Column
    Boolean active;

    @SerializedName("activationDate")
    @Column
    String activationDate;

    @SerializedName("submittedOnDate")
    @Column
    String submittedOnDate;

    @SerializedName("dateOfBirth")
    @Column
    String dateOfBirth;

    @SerializedName("mobileNo")
    @Column
    String mobileNo;

    @SerializedName("externalId")
    @Column
    String externalId;

    @SerializedName("clientTypeId")
    @Column
    Integer clientTypeId;

    @SerializedName("clientClassificationId")
    @Column
    Integer clientClassificationId;

    @SerializedName("address")
    List<Address> address;

    @SerializedName("dateFormat")
    @Column
    String dateFormat;

    @SerializedName("locale")
    @Column
    String locale;

    @SerializedName("datatables")
    private List<DataTablePayload> datatables;

    public List<DataTablePayload> getDatatables() {
        return datatables;
    }

    public void addDataTable(DataTablePayload dataTablePayload) {
        datatables.add(dataTablePayload);
    }

    public void setDatatables(List<DataTablePayload> datatables) {
        this.datatables = datatables;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientCreationTime() {
        return clientCreationTime;
    }

    public void setClientCreationTime(Long clientCreationTime) {
        this.clientCreationTime = clientCreationTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }

    public String getSubmittedOnDate() {
        return submittedOnDate;
    }

    public void setSubmittedOnDate(String submittedOnDate) {
        this.submittedOnDate = submittedOnDate;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Integer getClientTypeId() {
        return clientTypeId;
    }

    public void setClientTypeId(Integer clientTypeId) {
        this.clientTypeId = clientTypeId;
    }

    public Integer getClientClassificationId() {
        return clientClassificationId;
    }

    public void setClientClassificationId(Integer clientClassificationId) {
        this.clientClassificationId = clientClassificationId;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public String toString() {
        return "ClientPayload{" +
                "id=" + id +
                ", errorMessage='" + errorMessage + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", officeId=" + officeId +
                ", staffId=" + staffId +
                ", genderId=" + genderId +
                ", active=" + active +
                ", activationDate='" + activationDate + '\'' +
                ", submittedOnDate='" + submittedOnDate + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", externalId='" + externalId + '\'' +
                ", clientTypeId=" + clientTypeId +
                ", clientClassificationId=" + clientClassificationId +
                ", address=" + address +
                ", dateFormat='" + dateFormat + '\'' +
                ", locale='" + locale + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.firstname);
        dest.writeString(this.lastname);
        dest.writeString(this.middlename);
        dest.writeValue(this.officeId);
        dest.writeValue(this.staffId);
        dest.writeValue(this.genderId);
        dest.writeValue(this.active);
        dest.writeString(this.activationDate);
        dest.writeString(this.submittedOnDate);
        dest.writeString(this.dateOfBirth);
        dest.writeString(this.mobileNo);
        dest.writeString(this.externalId);
        dest.writeValue(this.clientTypeId);
        dest.writeValue(this.clientClassificationId);
        dest.writeTypedList(this.address);
        dest.writeString(this.dateFormat);
        dest.writeString(this.locale);
    }

    public ClientPayload() {}

    protected ClientPayload(Parcel in) {
        this.firstname = in.readString();
        this.lastname = in.readString();
        this.middlename = in.readString();
        this.officeId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.staffId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.genderId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.active = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.activationDate = in.readString();
        this.submittedOnDate = in.readString();
        this.dateOfBirth = in.readString();
        this.mobileNo = in.readString();
        this.externalId = in.readString();
        this.clientTypeId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.clientClassificationId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.address = in.createTypedArrayList(Address.CREATOR);
        this.dateFormat = in.readString();
        this.locale = in.readString();
    }

    public static final Parcelable.Creator<ClientPayload> CREATOR =
            new Parcelable.Creator<ClientPayload>() {
        @Override
        public ClientPayload createFromParcel(Parcel source) {
            return new ClientPayload(source);
        }

        @Override
        public ClientPayload[] newArray(int size) {
            return new ClientPayload[size];
        }
    };

    public static final class Builder {
        private String firstName;
        private String middleName;
        private String lastName;
        private String mobileNo;
        private Date activationDate;
        private String submittedOnDate;
        private Date dateOfBirth;
        private String externalId;
        private List<Address> address;
        private List<DataTablePayload> datatables;
        private Integer clientTypeId;
        private Integer officeId;
        private Integer staffId;
        private Integer genderId;
        private Integer clientClassificationId;
        private Boolean active;

        private final DateFormat dateFormat;
        private static final String locale = "en";

        private Builder(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        public static Builder with(DateFormat dateFormat) {
            return new Builder(dateFormat);
        }


        public ClientPayload build() {
            ClientPayload clientPayload = new ClientPayload();
            clientPayload.setLocale(locale);
            clientPayload.setDateFormat(dateFormat.getFormat());

            if (firstName != null) {
                clientPayload.setFirstname(firstName);
            }

            if (middleName != null) {
                clientPayload.setMiddlename(middleName);
            }

            if (lastName != null) {
                clientPayload.setLastname(lastName);
            }

            if (mobileNo != null) {
                clientPayload.setMobileNo(mobileNo);
            }

            if(active != null) {
                clientPayload.setActive(active);
            }

            if(activationDate != null) {
                clientPayload.setActivationDate(dateFormat.getDateFormat().format(activationDate));
            }

            if(submittedOnDate != null) {
                clientPayload.setSubmittedOnDate(submittedOnDate);
            }

            if(dateOfBirth != null) {
                clientPayload.setDateOfBirth(dateFormat.getDateFormat().format(dateOfBirth));
            }

            if(externalId != null) {
                clientPayload.setExternalId(externalId);
            }

            if(address != null && address.size() != 0) {
                clientPayload.setAddress(address);
            }

            if(clientTypeId != null) {
                clientPayload.setClientTypeId(clientTypeId);
            }

            if(officeId != null) {
                clientPayload.setOfficeId(officeId);
            }

            if(staffId != null) {
                clientPayload.setStaffId(staffId);
            }

            if(genderId != null) {
                clientPayload.setGenderId(genderId);
            }

            if(clientClassificationId != null) {
                clientPayload.setClientClassificationId(clientClassificationId);
            }

            if(datatables != null && datatables.size() != 0) {
                clientPayload.setDatatables(datatables);
            }

            return clientPayload;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
            return this;
        }

        public Builder setActivationDate(Date activationDate) {
            this.activationDate = activationDate;
            return  this;
        }

        public Builder setSubmittedOnDate(String submittedOnDate) {
            this.submittedOnDate = submittedOnDate;
            return this;
        }

        public Builder setDateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public Builder setAddress(List<Address> address) {
            this.address = address;
            return this;
        }

        public Builder setClientTypeId(int clientTypeId) {
            this.clientTypeId = clientTypeId;
            return this;
        }

        public Builder setOfficeId(int officeId) {
            this.officeId = officeId;
            return this;
        }

        public Builder setStaffId(int staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder setGenderId(int genderId) {
            this.genderId = genderId;
            return this;
        }

        public Builder setClientClassificationId(int clientClassificationId) {
            this.clientClassificationId = clientClassificationId;
            return this;
        }

        public Builder setActive(boolean active) {
            this.active = active;
            return this;
        }

        public Builder setDatatables(List<DataTablePayload> datatables) {
            this.datatables = datatables;
            return this;
        }
    }

    public enum DateFormat {
        dd_MMMM_yyyy("dd MMMM yyyy"),
        yyyy("yyyy");

        @Getter
        private final String format;

        DateFormat(String format) {
            this.format = format;
        }

        @SuppressLint("SimpleDateFormat")
        public SimpleDateFormat getDateFormat() {
            return new SimpleDateFormat(format);
        }
    }
}

