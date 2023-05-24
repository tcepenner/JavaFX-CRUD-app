/**
 * Sample Skeleton for 'insert-agent-view.fxml' Controller Class
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

public class InsertAgentController {

    private String url = "";
    private String user = "";
    private String password = "";

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnAddAgt"
    private Button btnAddAgt; // Value injected by FXMLLoader

    @FXML // fx:id="btnCancel"
    private Button btnCancel; // Value injected by FXMLLoader

    @FXML // fx:id="tfAgencyId"
    private TextField tfAgencyId; // Value injected by FXMLLoader

    @FXML // fx:id="tfAgentId"
    private TextField tfAgentId; // Value injected by FXMLLoader

    @FXML // fx:id="tfAgtBusPhone"
    private TextField tfAgtBusPhone; // Value injected by FXMLLoader

    @FXML // fx:id="tfAgtEmail"
    private TextField tfAgtEmail; // Value injected by FXMLLoader

    @FXML // fx:id="tfAgtFname"
    private TextField tfAgtFname; // Value injected by FXMLLoader

    @FXML // fx:id="tfAgtLname"
    private TextField tfAgtLname; // Value injected by FXMLLoader

    @FXML // fx:id="tfAgtMiddleInitial"
    private TextField tfAgtMiddleInitial; // Value injected by FXMLLoader

    @FXML // fx:id="tfAgtPosition"
    private TextField tfAgtPosition; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnAddAgt != null : "fx:id=\"btnAddAgt\" was not injected: check your FXML file 'insert-agent-view.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'insert-agent-view.fxml'.";
        assert tfAgencyId != null : "fx:id=\"tfAgencyId\" was not injected: check your FXML file 'insert-agent-view.fxml'.";
        assert tfAgentId != null : "fx:id=\"tfAgentId\" was not injected: check your FXML file 'insert-agent-view.fxml'.";
        assert tfAgtBusPhone != null : "fx:id=\"tfAgtBusPhone\" was not injected: check your FXML file 'insert-agent-view.fxml'.";
        assert tfAgtEmail != null : "fx:id=\"tfAgtEmail\" was not injected: check your FXML file 'insert-agent-view.fxml'.";
        assert tfAgtFname != null : "fx:id=\"tfAgtFname\" was not injected: check your FXML file 'insert-agent-view.fxml'.";
        assert tfAgtLname != null : "fx:id=\"tfAgtLname\" was not injected: check your FXML file 'insert-agent-view.fxml'.";
        assert tfAgtMiddleInitial != null : "fx:id=\"tfAgtMiddleInitial\" was not injected: check your FXML file 'insert-agent-view.fxml'.";
        assert tfAgtPosition != null : "fx:id=\"tfAgtPosition\" was not injected: check your FXML file 'insert-agent-view.fxml'.";


        tfAgentId.setDisable(true);

        btnAddAgt.setOnMouseClicked(new EventHandler<MouseEvent>() {
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

        try {
            FileInputStream fis = new FileInputStream("c:\\connection.properties");
            Properties p = new Properties();
            p.load(fis);
            url = (String)p.get("url");
            user = (String) p.get("user");
            password = (String)p.get("password");
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pStmt = conn.prepareStatement("INSERT INTO `agents`( `AgtFirstName`, `AgtMiddleInitial`, `AgtLastName`, `AgtBusPhone`," +
                    " `AgtEmail`, `AgtPosition`, `AgencyId`)" +
                    " VALUES (?,?,?,?,?,?,?)");
            pStmt.setString(1, tfAgtFname.getText());
            pStmt.setString(2, tfAgtMiddleInitial.getText());
            pStmt.setString(3, tfAgtLname.getText());
            pStmt.setString(4, tfAgtBusPhone.getText());
            pStmt.setString(5, tfAgtEmail.getText());
            pStmt.setString(6, tfAgtPosition.getText());
            pStmt.setInt(7, Integer.parseInt(tfAgencyId.getText()));
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
