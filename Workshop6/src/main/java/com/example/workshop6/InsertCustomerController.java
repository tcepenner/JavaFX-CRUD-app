/**
 * Sample Skeleton for 'insert-cust-view.fxml' Controller Class
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class InsertCustomerController {

    private String url = "";
    private String user = "";
    private String password = "";

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnAddCust"
    private Button btnAddCust; // Value injected by FXMLLoader

    @FXML // fx:id="btnCancel"
    private Button btnCancel; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustAddress"
    private TextField tfCustAddress; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustAgtId"
    private TextField tfCustAgtId; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustBusPhone"
    private TextField tfCustBusPhone; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustCity"
    private TextField tfCustCity; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustCountry"
    private TextField tfCustCountry; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustEmail"
    private TextField tfCustEmail; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustFname"
    private TextField tfCustFname; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustHomePhone"
    private TextField tfCustHomePhone; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustId"
    private TextField tfCustId; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustLname"
    private TextField tfCustLname; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustPostal"
    private TextField tfCustPostal; // Value injected by FXMLLoader

    @FXML // fx:id="tfCustProvince"
    private TextField tfCustProvince; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnAddCust != null : "fx:id=\"btnAddCust\" was not injected: check your FXML file 'insert-cust-view.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'insert-cust-view.fxml'.";
        assert tfCustAddress != null : "fx:id=\"tfCustAddress\" was not injected: check your FXML file 'insert-cust-view.fxml'.";
        assert tfCustAgtId != null : "fx:id=\"tfCustAgtId\" was not injected: check your FXML file 'insert-cust-view.fxml'.";
        assert tfCustBusPhone != null : "fx:id=\"tfCustBusPhone\" was not injected: check your FXML file 'insert-cust-view.fxml'.";
        assert tfCustCity != null : "fx:id=\"tfCustCity\" was not injected: check your FXML file 'insert-cust-view.fxml'.";
        assert tfCustCountry != null : "fx:id=\"tfCustCountry\" was not injected: check your FXML file 'insert-cust-view.fxml'.";
        assert tfCustEmail != null : "fx:id=\"tfCustEmail\" was not injected: check your FXML file 'insert-cust-view.fxml'.";
        assert tfCustFname != null : "fx:id=\"tfCustFname\" was not injected: check your FXML file 'insert-cust-view.fxml'.";
        assert tfCustHomePhone != null : "fx:id=\"tfCustHomePhone\" was not injected: check your FXML file 'insert-cust-view.fxml'.";
        assert tfCustId != null : "fx:id=\"tfCustId\" was not injected: check your FXML file 'insert-cust-view.fxml'.";
        assert tfCustLname != null : "fx:id=\"tfCustLname\" was not injected: check your FXML file 'insert-cust-view.fxml'.";
        assert tfCustPostal != null : "fx:id=\"tfCustPostal\" was not injected: check your FXML file 'insert-cust-view.fxml'.";
        assert tfCustProvince != null : "fx:id=\"tfCustProvince\" was not injected: check your FXML file 'insert-cust-view.fxml'.";

        // disabled because the database will autogenerate this value
        tfCustId.setDisable(true);

        btnAddCust.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnAddCustClicked(mouseEvent);
            }
        });

        btnCancel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                sendBacktoMain(mouseEvent);
            }
        });
    }

    private void btnAddCustClicked(MouseEvent mouseEvent) {

        try {
            FileInputStream fis = new FileInputStream("c:\\connection.properties");
            Properties p = new Properties();
            p.load(fis);
            url = (String)p.get("url");
            user = (String) p.get("user");
            password = (String)p.get("password");
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pStmt = conn.prepareStatement("INSERT INTO `customers`(`CustFirstName`, `CustLastName`, `CustAddress`," +
                    " `CustCity`, `CustProv`, `CustPostal`, `CustCountry`, `CustHomePhone`, `CustBusPhone`," +
                    " `CustEmail`, `AgentId`) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            pStmt.setString(1, tfCustFname.getText());
            pStmt.setString(2, tfCustLname.getText());
            pStmt.setString(3, tfCustAddress.getText());
            pStmt.setString(4, tfCustCity.getText());
            pStmt.setString(5, tfCustProvince.getText());
            pStmt.setString(6, tfCustPostal.getText());
            pStmt.setString(7, tfCustCountry.getText());
            pStmt.setString(8, tfCustHomePhone.getText());
            pStmt.setString(9, tfCustBusPhone.getText());
            pStmt.setString(10, tfCustEmail.getText());
            pStmt.setInt(11, Integer.parseInt(tfCustAgtId.getText()));
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

