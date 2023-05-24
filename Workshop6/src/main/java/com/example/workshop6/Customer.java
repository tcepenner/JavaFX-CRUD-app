package com.example.workshop6;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Customer {


    private SimpleIntegerProperty customerId;
    private SimpleStringProperty custFname;
    private SimpleStringProperty custLname;
    private SimpleStringProperty custAddress;
    private SimpleStringProperty custCity;
    private SimpleStringProperty custProv;
    private SimpleStringProperty custPostal;
    private SimpleStringProperty custCountry;
    private SimpleStringProperty custHomePhone;
    private SimpleStringProperty custBusPhone;
    private SimpleStringProperty custEmail;
    private SimpleIntegerProperty custAgtId;


    public Customer(int customerId, String custFname, String custLname,
                    String custAddress, String custCity, String custProv,
                    String custPostal, String custCountry, String custHomePhone,
                    String custBusPhone, String custEmail, int custAgtId) {
        this.customerId = new SimpleIntegerProperty(customerId);
        this.custFname = new SimpleStringProperty(custFname);
        this.custLname = new SimpleStringProperty(custLname);
        this.custAddress = new SimpleStringProperty(custAddress);
        this.custCity = new SimpleStringProperty(custCity);
        this.custProv = new SimpleStringProperty(custProv);
        this.custPostal = new SimpleStringProperty(custPostal);
        this.custCountry = new SimpleStringProperty(custCountry);
        this.custHomePhone = new SimpleStringProperty(custHomePhone);
        this.custBusPhone = new SimpleStringProperty(custBusPhone);
        this.custEmail = new SimpleStringProperty(custEmail);
        this.custAgtId = new SimpleIntegerProperty(custAgtId);


    }
    public int getCustomerId() {
        return customerId.get();
    }

    public SimpleIntegerProperty customerIdProperty() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId.set(customerId);
    }

    public String getCustFname() {
        return custFname.get();
    }

    public SimpleStringProperty custFnameProperty() {
        return custFname;
    }

    public void setCustFname(String custFname) {
        this.custFname.set(custFname);
    }

    public String getCustLname() {
        return custLname.get();
    }

    public SimpleStringProperty custLnameProperty() {
        return custLname;
    }

    public void setCustLname(String custLname) {
        this.custLname.set(custLname);
    }

    public String getCustAddress() {
        return custAddress.get();
    }

    public SimpleStringProperty custAddressProperty() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress.set(custAddress);
    }

    public String getCustCity() {
        return custCity.get();
    }

    public SimpleStringProperty custCityProperty() {
        return custCity;
    }

    public void setCustCity(String custCity) {
        this.custCity.set(custCity);
    }

    public String getCustProv() {
        return custProv.get();
    }

    public SimpleStringProperty custProvProperty() {
        return custProv;
    }

    public void setCustProv(String custProv) {
        this.custProv.set(custProv);
    }

    public String getCustPostal() {
        return custPostal.get();
    }

    public SimpleStringProperty custPostalProperty() {
        return custPostal;
    }

    public void setCustPostal(String custPostal) {
        this.custPostal.set(custPostal);
    }

    public String getCustCountry() {
        return custCountry.get();
    }

    public SimpleStringProperty custCountryProperty() {
        return custCountry;
    }

    public void setCustCountry(String custCountry) {
        this.custCountry.set(custCountry);
    }

    public String getCustHomePhone() {
        return custHomePhone.get();
    }

    public SimpleStringProperty custHomePhoneProperty() {
        return custHomePhone;
    }

    public void setCustHomePhone(String custHomePhone) {
        this.custHomePhone.set(custHomePhone);
    }

    public String getCustBusPhone() {
        return custBusPhone.get();
    }

    public SimpleStringProperty custBusPhoneProperty() {
        return custBusPhone;
    }

    public void setCustBusPhone(String custBusPhone) {
        this.custBusPhone.set(custBusPhone);
    }

    public String getCustEmail() {
        return custEmail.get();
    }

    public SimpleStringProperty custEmailProperty() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail.set(custEmail);
    }

    public int getCustAgtId() {
        return custAgtId.get();
    }

    public SimpleIntegerProperty custAgtIdProperty() {
        return custAgtId;
    }

    public void setCustAgtId(int custAgtId) {
        this.custAgtId.set(custAgtId);
    }

    @Override
    public String toString() {
        return "ID: " + getCustomerId() + " - " + getCustFname() + " " + getCustLname();
    }


}
