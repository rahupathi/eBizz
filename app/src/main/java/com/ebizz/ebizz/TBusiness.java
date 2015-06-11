package com.ebizz.ebizz;

import java.io.Serializable;

/**
 * Created by BMS0020 on 5/25/2015.
 */
public class TBusiness implements Serializable {
    private String Name;
    private String Address;
    private String City;
    private String ContactNo;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
    }
}
