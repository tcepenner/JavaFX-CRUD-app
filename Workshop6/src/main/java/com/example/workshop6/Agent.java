package com.example.workshop6;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Agent {
    private SimpleIntegerProperty agentId;
    private SimpleStringProperty agtFname;
    private SimpleStringProperty agtMiddleInitial;
    private SimpleStringProperty agtLname;
    private SimpleStringProperty agtPhone;
    private SimpleStringProperty agtEmail;
    private SimpleStringProperty agtPosition;
    private SimpleIntegerProperty agencyId;

    public Agent(int agentId, String agtFname, String agtMiddleInitial, String agtLname,
                 String agtPhone, String agtEmail, String agtPosition, int agencyId) {
        this.agentId = new SimpleIntegerProperty(agentId);
        this.agtFname = new SimpleStringProperty(agtFname);
        this.agtMiddleInitial = new SimpleStringProperty(agtMiddleInitial);
        this.agtLname = new SimpleStringProperty(agtLname);
        this.agtPhone = new SimpleStringProperty(agtPhone);
        this.agtEmail = new SimpleStringProperty(agtEmail);
        this.agtPosition = new SimpleStringProperty(agtPosition);
        this.agencyId = new SimpleIntegerProperty(agencyId);
    }

    public int getAgentId() {
        return agentId.get();
    }

    public SimpleIntegerProperty agentIdProperty() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId.set(agentId);
    }

    public String getAgtFname() {
        return agtFname.get();
    }

    public SimpleStringProperty agtFnameProperty() {
        return agtFname;
    }

    public void setAgtFname(String agtFname) {
        this.agtFname.set(agtFname);
    }

    public String getAgtMiddleInitial() {
        return agtMiddleInitial.get();
    }

    public SimpleStringProperty agtMiddleInitialProperty() {
        return agtMiddleInitial;
    }

    public void setAgtMiddleInitial(String agtMiddleInitial) {
        this.agtMiddleInitial.set(agtMiddleInitial);
    }

    public String getAgtLname() {
        return agtLname.get();
    }

    public SimpleStringProperty agtLnameProperty() {
        return agtLname;
    }

    public void setAgtLname(String agtLname) {
        this.agtLname.set(agtLname);
    }

    public String getAgtPhone() {
        return agtPhone.get();
    }

    public SimpleStringProperty agtPhoneProperty() {
        return agtPhone;
    }

    public void setAgtPhone(String agtPhone) {
        this.agtPhone.set(agtPhone);
    }

    public String getAgtEmail() {
        return agtEmail.get();
    }

    public SimpleStringProperty agtEmailProperty() {
        return agtEmail;
    }

    public void setAgtEmail(String agtEmail) {
        this.agtEmail.set(agtEmail);
    }

    public String getAgtPosition() {
        return agtPosition.get();
    }

    public SimpleStringProperty agtPositionProperty() {
        return agtPosition;
    }

    public void setAgtPosition(String agtPosition) {
        this.agtPosition.set(agtPosition);
    }

    public int getAgencyId() {
        return agencyId.get();
    }

    public SimpleIntegerProperty agencyIdProperty() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId.set(agencyId);
    }

    @Override
    public String toString() {
        return "ID: " + getAgentId() + " - " + getAgtFname() + " " + getAgtLname();
    }
}
