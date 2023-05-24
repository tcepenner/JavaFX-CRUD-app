/**
 * Sample Skeleton for 'insert-pkg-view.fxml' Controller Class
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

public class InsertPackageController {

    private String url = "";
    private String user = "";
    private String password = "";
    private void showAlert(Alert.AlertType alertType, String message){
        Alert alert = new Alert(alertType);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private boolean validateUserInputs() {
        if(!Validation.datePickerHasValue(pickerPkgStartDate)) {
            showAlert(Alert.AlertType.ERROR, "Please select a Start Date");
            return false;
        }
        if(!Validation.datePickerHasValue(pickerPkgEndDate)) {
            showAlert(Alert.AlertType.ERROR, "Please select an End Date");
            return false;
        }
        if(!Validation.textFieldisText(tfPkgName)) {
            showAlert(Alert.AlertType.ERROR, "Please enter a Package Name");
            return false;
        }
        if(!Validation.textFieldisText(tfPkgDesc)) {
            showAlert(Alert.AlertType.ERROR, "Please enter the Packages description");
            return false;
        }
        if(!Validation.textFieldisDouble(tfPkgBasePrice)) {
            showAlert(Alert.AlertType.ERROR, "Please enter a valid Base Price");
            return false;
        }
        if(!Validation.textFieldisDouble(tfPkgCommission)) {
            showAlert(Alert.AlertType.ERROR, "Please enter a valid Commission rate");
            return false;
        }
        return true;
    }

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnAddPkg"
    private Button btnAddPkg; // Value injected by FXMLLoader

    @FXML // fx:id="btnCancel"
    private Button btnCancel; // Value injected by FXMLLoader

    @FXML // fx:id="pickerPkgEndDate"
    private DatePicker pickerPkgEndDate; // Value injected by FXMLLoader

    @FXML // fx:id="pickerPkgStartDate"
    private DatePicker pickerPkgStartDate; // Value injected by FXMLLoader

    @FXML // fx:id="tfPkgBasePrice"
    private TextField tfPkgBasePrice; // Value injected by FXMLLoader

    @FXML // fx:id="tfPkgCommission"
    private TextField tfPkgCommission; // Value injected by FXMLLoader

    @FXML // fx:id="tfPkgDesc"
    private TextField tfPkgDesc; // Value injected by FXMLLoader

    @FXML // fx:id="tfPkgEndDate"
    private TextField tfPkgEndDate; // Value injected by FXMLLoader

    @FXML // fx:id="tfPkgId"
    private TextField tfPkgId; // Value injected by FXMLLoader

    @FXML // fx:id="tfPkgName"
    private TextField tfPkgName; // Value injected by FXMLLoader

    @FXML // fx:id="tfPkgStartDate"
    private TextField tfPkgStartDate; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnAddPkg != null : "fx:id=\"btnAddPkg\" was not injected: check your FXML file 'insert-pkg-view.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'insert-pkg-view.fxml'.";
        assert pickerPkgEndDate != null : "fx:id=\"pickerPkgEndDate\" was not injected: check your FXML file 'insert-pkg-view.fxml'.";
        assert pickerPkgStartDate != null : "fx:id=\"pickerPkgStartDate\" was not injected: check your FXML file 'insert-pkg-view.fxml'.";
        assert tfPkgBasePrice != null : "fx:id=\"tfPkgBasePrice\" was not injected: check your FXML file 'insert-pkg-view.fxml'.";
        assert tfPkgCommission != null : "fx:id=\"tfPkgCommission\" was not injected: check your FXML file 'insert-pkg-view.fxml'.";
        assert tfPkgDesc != null : "fx:id=\"tfPkgDesc\" was not injected: check your FXML file 'insert-pkg-view.fxml'.";
        assert tfPkgEndDate != null : "fx:id=\"tfPkgEndDate\" was not injected: check your FXML file 'insert-pkg-view.fxml'.";
        assert tfPkgId != null : "fx:id=\"tfPkgId\" was not injected: check your FXML file 'insert-pkg-view.fxml'.";
        assert tfPkgName != null : "fx:id=\"tfPkgName\" was not injected: check your FXML file 'insert-pkg-view.fxml'.";
        assert tfPkgStartDate != null : "fx:id=\"tfPkgStartDate\" was not injected: check your FXML file 'insert-pkg-view.fxml'.";



        tfPkgId.setDisable(true);

        btnAddPkg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnAddAgtClicked(mouseEvent);
            }
        });

        btnCancel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                sendBacktoMain(mouseEvent);
            }
        });
    }

    private void btnAddAgtClicked(MouseEvent mouseEvent) {

        String message = "";
        //writting out error messages with new line character at the end, so if there is multiple errors then it will display them all in a block of text for the user
        if(!Validation.textFieldisText(tfPkgName)){
            message += "Please Enter a Name for the Package \n";
            tfPkgName.requestFocus();
        }
        if(!Validation.textFieldisText(tfPkgDesc)){
            message += "Please Enter a Description for the Package \n";
            tfPkgDesc.requestFocus();
        }
        if(!Validation.datePickerHasValue(pickerPkgStartDate)){
            message += "Please choose a starting date for the Package \n";
            pickerPkgStartDate.requestFocus();
        }
        if(!Validation.datePickerHasValue(pickerPkgEndDate)){
            message += "Please choose an ending date for the Package \n";
            pickerPkgEndDate.requestFocus();
        }
        if(!Validation.textFieldisDouble(tfPkgBasePrice)){
            message += "Please Enter the Base Price for the Package \n";
            tfPkgBasePrice.requestFocus();
        }
        if(!Validation.textFieldisDouble(tfPkgCommission)){
            message += "Please Enter the Commission on the Package \n";
            tfPkgCommission.requestFocus();
        }
        //if no error messages the process with insertion of new Package
;        if (message.isEmpty()) {
            try {
                FileInputStream fis = new FileInputStream("c:\\connection.properties");
                Properties p = new Properties();
                p.load(fis);
                url = (String)p.get("url");
                user = (String) p.get("user");
                password = (String)p.get("password");
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pStmt = conn.prepareStatement("INSERT INTO `packages`(`PkgName`, `PkgStartDate`," +
                        " `PkgEndDate`, `PkgDesc`, `PkgBasePrice`, `PkgAgencyCommission`) " +
                        "VALUES (?,?,?,?,?,?)");
                pStmt.setString(1, tfPkgName.getText());
                //pStmt.setString(2, tfPkgStartDate.getText());
                //pStmt.setString(3, tfPkgEndDate.getText());
                pStmt.setObject(2, pickerPkgStartDate.getValue());
                pStmt.setObject(3, pickerPkgEndDate.getValue());
                pStmt.setString(4, tfPkgDesc.getText());
                pStmt.setDouble(5, Double.parseDouble(tfPkgBasePrice.getText()));
                pStmt.setDouble(6, Double.parseDouble(tfPkgCommission.getText()));
                pStmt.executeUpdate();
                conn.close();

            } catch (IOException | SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
            }
            sendBacktoMain(mouseEvent);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Insertion Error");
            alert.setHeaderText("Please correct the following errors on the form");
            alert.setContentText(message);
            alert.showAndWait();
        }

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


