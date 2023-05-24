/**
 * Sample Skeleton for 'insert-booking-view.fxml' Controller Class
 */

package com.example.workshop6;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class InsertBookingcontroller {

    private String url = "";
    private String user = "";
    private String password = "";

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnAddBooking"
    private Button btnAddBooking; // Value injected by FXMLLoader

    @FXML // fx:id="btnCancel"
    private Button btnCancel; // Value injected by FXMLLoader

    @FXML // fx:id="tfBookingCustId"
    private TextField tfBookingCustId; // Value injected by FXMLLoader

    @FXML // fx:id="tfBookingDate"
    private TextField tfBookingDate; // Value injected by FXMLLoader

    @FXML
    private DatePicker pickerBookingDate;
    @FXML // fx:id="tfBookingId"
    private TextField tfBookingId; // Value injected by FXMLLoader

    @FXML // fx:id="tfBookingNo"
    private TextField tfBookingNo; // Value injected by FXMLLoader

    @FXML // fx:id="tfBookingPkgId"
    private TextField tfBookingPkgId; // Value injected by FXMLLoader

    @FXML // fx:id="tfTravelerCount"
    private TextField tfTravelerCount; // Value injected by FXMLLoader

    @FXML // fx:id="tfTripType"
    private TextField tfTripType; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnAddBooking != null : "fx:id=\"btnAddBooking\" was not injected: check your FXML file 'insert-booking-view.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'insert-booking-view.fxml'.";
        assert pickerBookingDate != null : "fx:id=\"pickerBookingDate\" was not injected: check your FXML file 'insert-booking-view.fxml'.";
        assert tfBookingCustId != null : "fx:id=\"tfBookingCustId\" was not injected: check your FXML file 'insert-booking-view.fxml'.";
        assert tfBookingDate != null : "fx:id=\"tfBookingDate\" was not injected: check your FXML file 'insert-booking-view.fxml'.";
        assert tfBookingId != null : "fx:id=\"tfBookingId\" was not injected: check your FXML file 'insert-booking-view.fxml'.";
        assert tfBookingNo != null : "fx:id=\"tfBookingNo\" was not injected: check your FXML file 'insert-booking-view.fxml'.";
        assert tfBookingPkgId != null : "fx:id=\"tfBookingPkgId\" was not injected: check your FXML file 'insert-booking-view.fxml'.";
        assert tfTravelerCount != null : "fx:id=\"tfTravelerCount\" was not injected: check your FXML file 'insert-booking-view.fxml'.";
        assert tfTripType != null : "fx:id=\"tfTripType\" was not injected: check your FXML file 'insert-booking-view.fxml'.";


        tfBookingId.setDisable(true);

        btnAddBooking.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnAddBookingClicked(mouseEvent);
            }
        });

        btnCancel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                sendBacktoMain(mouseEvent);
            }
        });
    }

    private void btnAddBookingClicked(MouseEvent mouseEvent) {

        try {
            FileInputStream fis = new FileInputStream("c:\\connection.properties");
            Properties p = new Properties();
            p.load(fis);
            url = (String)p.get("url");
            user = (String) p.get("user");
            password = (String)p.get("password");
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pStmt = conn.prepareStatement("INSERT INTO `bookings`(`BookingDate`, `BookingNo`," +
                    " `TravelerCount`, `CustomerId`, `TripTypeId`, `PackageId`) VALUES" +
                    " (?,?,?,?,?,?)");
            //pStmt.setString(1, tfBookingDate.getText());
            pStmt.setString(1, String.valueOf(pickerBookingDate.getValue()));
            pStmt.setString(2, tfBookingNo.getText());
            pStmt.setInt(3, Integer.parseInt(tfTravelerCount.getText()));
            pStmt.setInt(4, Integer.parseInt(tfBookingCustId.getText()));
            pStmt.setString(5, tfTripType.getText());
            pStmt.setInt(6, Integer.parseInt(tfBookingPkgId.getText()));
            pStmt.executeUpdate();
            conn.close();

        } catch (IOException | SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
        }
        sendBacktoMain(mouseEvent);
    }
    // after buttons are clicked the user is sent back to the main scene
    private void sendBacktoMain(MouseEvent mouseEvent)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-view.fxml"));
        Parent insertScene;
        try {
            insertScene = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DisplayController displayController = fxmlLoader.getController();
        Scene scene = new Scene(insertScene);
        Stage stage = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
