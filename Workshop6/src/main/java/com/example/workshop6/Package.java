package com.example.workshop6;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Package {
    private SimpleIntegerProperty pkgId;
    private SimpleStringProperty pkgName;
    //private SimpleStringProperty pkgStartDate;
    //private SimpleStringProperty pkgEndDate;
    private ObjectProperty<LocalDate> pkgStartDate;
    private ObjectProperty<LocalDate> pkgEndDate;
    private SimpleStringProperty pkgDescription;
    private SimpleDoubleProperty pkgBasePrice;
    private SimpleDoubleProperty pkgCommission;

    public Package(int pkgId, String pkgName, LocalDate pkgStartDate,
                   LocalDate pkgEndDate, String pkgDescription,
                   double pkgBasePrice, double pkgCommission) {
        this.pkgId = new SimpleIntegerProperty(pkgId);
        this.pkgName = new SimpleStringProperty(pkgName);
        //this.pkgStartDate = new SimpleStringProperty(pkgStartDate);
        //this.pkgEndDate = new SimpleStringProperty(pkgEndDate);
        this.pkgStartDate = new SimpleObjectProperty<>(pkgStartDate);
        this.pkgEndDate = new SimpleObjectProperty<>(pkgEndDate);
        this.pkgDescription = new SimpleStringProperty(pkgDescription);
        this.pkgBasePrice = new SimpleDoubleProperty(pkgBasePrice);
        this.pkgCommission = new SimpleDoubleProperty(pkgCommission);
    }

    public int getPkgId() {
        return pkgId.get();
    }

    public SimpleIntegerProperty pkgIdProperty() {
        return pkgId;
    }

    public void setPkgId(int pkgId) {
        this.pkgId.set(pkgId);
    }

    public String getPkgName() {
        return pkgName.get();
    }

    public SimpleStringProperty pkgNameProperty() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName.set(pkgName);
    }

/*    public String getPkgStartDate() {
        return pkgStartDate.get();
    }

    public SimpleStringProperty pkgStartDateProperty() {
        return pkgStartDate;
    }

    public void setPkgStartDate(String pkgStartDate) {
        this.pkgStartDate.set(pkgStartDate);
    }

    public String getPkgEndDate() {
        return pkgEndDate.get();
    }

    public SimpleStringProperty pkgEndDateProperty() {
        return pkgEndDate;
    }

    public void setPkgEndDate(String pkgEndDate) {
        this.pkgEndDate.set(pkgEndDate);
    }*/
public LocalDate getPkgStartDate() { return pkgStartDate.get(); }

    public ObjectProperty<LocalDate> pkgStartDateProperty() { return pkgStartDate; }

    public void setPkgStartDate(LocalDate pkgStartDate) { this.pkgStartDate.set(pkgStartDate); }
    public LocalDate getPkgEndDate() { return pkgEndDate.get(); }

    public ObjectProperty<LocalDate> pkgEndDateProperty() { return pkgEndDate; }

    public void setPkgEndDate(LocalDate pkgEndDate) { this.pkgEndDate.set(pkgEndDate); }

    public String getPkgDescription() {
        return pkgDescription.get();
    }

    public SimpleStringProperty pkgDescriptionProperty() {
        return pkgDescription;
    }

    public void setPkgDescription(String pkgDescription) {
        this.pkgDescription.set(pkgDescription);
    }

    public double getPkgBasePrice() {
        return pkgBasePrice.get();
    }

    public SimpleDoubleProperty pkgBasePriceProperty() {
        return pkgBasePrice;
    }

    public void setPkgBasePrice(double pkgBasePrice) {
        this.pkgBasePrice.set(pkgBasePrice);
    }

    public double getPkgCommission() {
        return pkgCommission.get();
    }

    public SimpleDoubleProperty pkgCommissionProperty() {
        return pkgCommission;
    }

    public void setPkgCommission(double pkgCommission) {
        this.pkgCommission.set(pkgCommission);
    }

    @Override
    public String toString() {
        return "ID: " + getPkgId() + " - " + getPkgName();
    }
}
