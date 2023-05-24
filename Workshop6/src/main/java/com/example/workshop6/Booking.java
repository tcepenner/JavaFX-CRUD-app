package com.example.workshop6;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Booking {

    private SimpleIntegerProperty bookingId;
    //private SimpleStringProperty bookingDate;
    private ObjectProperty<LocalDate> bookingDate;
    private SimpleStringProperty bookingNo;
    private SimpleIntegerProperty bookingTravelerCount;
    private SimpleIntegerProperty bookingCustId;
    private SimpleStringProperty bookingTripType;
    private SimpleIntegerProperty bookingPkgId;

    public Booking(int bookingId, LocalDate bookingDate, String bookingNo,
                   int bookingTravelerCount, int bookingCustId,
                   String bookingTripType, int bookingPkgId) {
        this.bookingId = new SimpleIntegerProperty(bookingId);
        //this.bookingDate = new SimpleStringProperty(bookingDate);
        this.bookingDate = new SimpleObjectProperty<>(bookingDate);
        this.bookingNo = new SimpleStringProperty(bookingNo);
        this.bookingTravelerCount = new SimpleIntegerProperty(bookingTravelerCount);
        this.bookingCustId = new SimpleIntegerProperty(bookingCustId);
        this.bookingTripType = new SimpleStringProperty(bookingTripType);
        this.bookingPkgId = new SimpleIntegerProperty(bookingPkgId);
    }

    public int getBookingId() {
        return bookingId.get();
    }

    public SimpleIntegerProperty bookingIdProperty() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId.set(bookingId);
    }

/*    public String getBookingDate() {
        return bookingDate.get();
    }

    public SimpleStringProperty bookingDateProperty() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate.set(bookingDate);
    }*/
    public LocalDate getBookingDate() { return bookingDate.get(); }

    public ObjectProperty<LocalDate> bookingDateProperty() { return bookingDate; }

    public void setBookingDate(LocalDate bookingDate) { this.bookingDate.set(bookingDate); }

    public String getBookingNo() {
        return bookingNo.get();
    }

    public SimpleStringProperty bookingNoProperty() {
        return bookingNo;
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo.set(bookingNo);
    }

    public int getBookingTravelerCount() {
        return bookingTravelerCount.get();
    }

    public SimpleIntegerProperty bookingTravelerCountProperty() {
        return bookingTravelerCount;
    }

    public void setBookingTravelerCount(int bookingITravelerCount) {
        this.bookingTravelerCount.set(bookingITravelerCount);
    }

    public int getBookingCustId() {
        return bookingCustId.get();
    }

    public SimpleIntegerProperty bookingCustIdProperty() {
        return bookingCustId;
    }

    public void setBookingCustId(int bookingCustId) {
        this.bookingCustId.set(bookingCustId);
    }

    public String getBookingTripType() {
        return bookingTripType.get();
    }

    public SimpleStringProperty bookingTripTypeProperty() {
        return bookingTripType;
    }

    public void setBookingTripType(String bookingTripType) {
        this.bookingTripType.set(bookingTripType);
    }

    public int getBookingPkgId() {
        return bookingPkgId.get();
    }

    public SimpleIntegerProperty bookingPkgIdProperty() {
        return bookingPkgId;
    }

    public void setBookingPkgId(int bookingPkgId) {
        this.bookingPkgId.set(bookingPkgId);
    }

    @Override
    public String toString() {
        return "Booking ID: " + getBookingId() + " - Customer ID: " + getBookingCustId();
    }
}
