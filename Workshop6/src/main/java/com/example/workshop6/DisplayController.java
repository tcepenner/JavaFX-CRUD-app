package com.example.workshop6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;



public class DisplayController {

    private ObservableList<Agent> agtData = FXCollections.observableArrayList();
    private ObservableList<Customer> custData = FXCollections.observableArrayList();
    private ObservableList<Package> pkgData = FXCollections.observableArrayList();
    private ObservableList<Booking> bookingData = FXCollections.observableArrayList();




    //private ListView<Agent> agentListView = new ListView<>();
    private String url = "";
    private String user = "";
    private String password = "";

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnAddAgt"
    private Button btnAddAgt; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddBooking"
    private Button btnAddBooking; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddCust"
    private Button btnAddCust; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddPkg"
    private Button btnAddPkg; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeleteAgt"
    private Button btnDeleteAgt; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeleteBooking"
    private Button btnDeleteBooking; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeleteCust"
    private Button btnDeleteCust; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeletePkg"
    private Button btnDeletePkg; // Value injected by FXMLLoader

    @FXML // fx:id="btnEditAgt"
    private Button btnEditAgt; // Value injected by FXMLLoader

    @FXML // fx:id="btnEditBooking"
    private Button btnEditBooking; // Value injected by FXMLLoader

    @FXML // fx:id="btnEditCust"
    private Button btnEditCust; // Value injected by FXMLLoader

    @FXML // fx:id="btnEditPkg"
    private Button btnEditPkg; // Value injected by FXMLLoader

    @FXML // fx:id="btnSaveAgt"
    private Button btnSaveAgt; // Value injected by FXMLLoader

    @FXML // fx:id="btnSaveBooking"
    private Button btnSaveBooking; // Value injected by FXMLLoader

    @FXML // fx:id="btnSaveCust"
    private Button btnSaveCust; // Value injected by FXMLLoader

    @FXML // fx:id="btnSavePkg"
    private Button btnSavePkg; // Value injected by FXMLLoader

    @FXML // fx:id="ivTravelExperts"
    private ImageView ivTravelExperts; // Value injected by FXMLLoader

    @FXML // fx:id="lvAgents"
    private ListView<Agent> lvAgents; // Value injected by FXMLLoader

    @FXML // fx:id="lvBookings"
    private ListView<Booking> lvBookings; // Value injected by FXMLLoader

    @FXML // fx:id="lvCustomers"
    private ListView<Customer> lvCustomers; // Value injected by FXMLLoader

    @FXML // fx:id="lvPackages"
    private ListView<Package> lvPackages; // Value injected by FXMLLoader

    @FXML // fx:id="pickerBookingDate"
    private DatePicker pickerBookingDate; // Value injected by FXMLLoader

    @FXML // fx:id="pickerPkgEndDate"
    private DatePicker pickerPkgEndDate; // Value injected by FXMLLoader

    @FXML // fx:id="pickerPkgStartDate"
    private DatePicker pickerPkgStartDate; // Value injected by FXMLLoader

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

    @FXML // fx:id="tfBookingCustId"
    private TextField tfBookingCustId; // Value injected by FXMLLoader

    @FXML // fx:id="tfBookingDate"
    private TextField tfBookingDate; // Value injected by FXMLLoader

    @FXML // fx:id="tfBookingId"
    private TextField tfBookingId; // Value injected by FXMLLoader

    @FXML // fx:id="tfBookingNo"
    private TextField tfBookingNo; // Value injected by FXMLLoader

    @FXML // fx:id="tfBookingPkgId"
    private TextField tfBookingPkgId; // Value injected by FXMLLoader

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

    @FXML // fx:id="tfTravelerCount"
    private TextField tfTravelerCount; // Value injected by FXMLLoader

    @FXML // fx:id="tfTripType"
    private TextField tfTripType; // Value injected by FXMLLoader

    public DisplayController() throws FileNotFoundException {
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnAddAgt != null : "fx:id=\"btnAddAgt\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnAddBooking != null : "fx:id=\"btnAddBooking\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnAddCust != null : "fx:id=\"btnAddCust\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnAddPkg != null : "fx:id=\"btnAddPkg\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnDeleteAgt != null : "fx:id=\"btnDeleteAgt\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnDeleteBooking != null : "fx:id=\"btnDeleteBooking\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnDeleteCust != null : "fx:id=\"btnDeleteCust\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnDeletePkg != null : "fx:id=\"btnDeletePkg\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnEditAgt != null : "fx:id=\"btnEditAgt\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnEditBooking != null : "fx:id=\"btnEditBooking\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnEditCust != null : "fx:id=\"btnEditCust\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnEditPkg != null : "fx:id=\"btnEditPkg\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnSaveAgt != null : "fx:id=\"btnSaveAgt\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnSaveBooking != null : "fx:id=\"btnSaveBooking\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnSaveCust != null : "fx:id=\"btnSaveCust\" was not injected: check your FXML file 'main-view.fxml'.";
        assert btnSavePkg != null : "fx:id=\"btnSavePkg\" was not injected: check your FXML file 'main-view.fxml'.";
        assert ivTravelExperts != null : "fx:id=\"ivTravelExperts\" was not injected: check your FXML file 'main-view.fxml'.";
        assert pickerBookingDate != null : "fx:id=\"pickerBookingDate\" was not injected: check your FXML file 'main-view.fxml'.";
        assert pickerPkgEndDate != null : "fx:id=\"pickerPkgEndDate\" was not injected: check your FXML file 'main-view.fxml'.";
        assert pickerPkgStartDate != null : "fx:id=\"pickerPkgStartDate\" was not injected: check your FXML file 'main-view.fxml'.";
        assert lvAgents != null : "fx:id=\"lvAgents\" was not injected: check your FXML file 'main-view.fxml'.";
        assert lvBookings != null : "fx:id=\"lvBookings\" was not injected: check your FXML file 'main-view.fxml'.";
        assert lvCustomers != null : "fx:id=\"lvCustomers\" was not injected: check your FXML file 'main-view.fxml'.";
        assert lvPackages != null : "fx:id=\"lvPackages\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfAgencyId != null : "fx:id=\"tfAgencyId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfAgentId != null : "fx:id=\"tfAgentId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfAgtBusPhone != null : "fx:id=\"tfAgtBusPhone\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfAgtEmail != null : "fx:id=\"tfAgtEmail\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfAgtFname != null : "fx:id=\"tfAgtFname\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfAgtLname != null : "fx:id=\"tfAgtLname\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfAgtMiddleInitial != null : "fx:id=\"tfAgtMiddleInitial\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfAgtPosition != null : "fx:id=\"tfAgtPosition\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfBookingCustId != null : "fx:id=\"tfBookingCustId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfBookingDate != null : "fx:id=\"tfBookingDate\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfBookingId != null : "fx:id=\"tfBookingId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfBookingNo != null : "fx:id=\"tfBookingNo\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfBookingPkgId != null : "fx:id=\"tfBookingPkgId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfCustAddress != null : "fx:id=\"tfCustAddress\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfCustAgtId != null : "fx:id=\"tfCustAgtId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfCustBusPhone != null : "fx:id=\"tfCustBusPhone\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfCustCity != null : "fx:id=\"tfCustCity\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfCustCountry != null : "fx:id=\"tfCustCountry\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfCustEmail != null : "fx:id=\"tfCustEmail\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfCustFname != null : "fx:id=\"tfCustFname\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfCustHomePhone != null : "fx:id=\"tfCustHomePhone\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfCustId != null : "fx:id=\"tfCustId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfCustLname != null : "fx:id=\"tfCustLname\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfCustPostal != null : "fx:id=\"tfCustPostal\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfCustProvince != null : "fx:id=\"tfCustProvince\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfPkgBasePrice != null : "fx:id=\"tfPkgBasePrice\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfPkgCommission != null : "fx:id=\"tfPkgCommission\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfPkgDesc != null : "fx:id=\"tfPkgDesc\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfPkgEndDate != null : "fx:id=\"tfPkgEndDate\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfPkgId != null : "fx:id=\"tfPkgId\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfPkgName != null : "fx:id=\"tfPkgName\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfPkgStartDate != null : "fx:id=\"tfPkgStartDate\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfTravelerCount != null : "fx:id=\"tfTravelerCount\" was not injected: check your FXML file 'main-view.fxml'.";
        assert tfTripType != null : "fx:id=\"tfTripType\" was not injected: check your FXML file 'main-view.fxml'.";

        //Save button cannot be clicked and textfields cannot be edited until edit button has been clicked
        disableAgentTextFields();
        disableCustomerTextFields();
        disablePackageTextFields();
        disableBookingTextFields();
        disablePrimaryKeyTextFields(); //the primary key fields will never be enabled as they should not be edited
        btnSaveAgt.setDisable(true);
        btnSaveCust.setDisable(true);
        btnSavePkg.setDisable(true);
        btnSaveBooking.setDisable(true);


        getAgents();
        getCustomers();
        getPackages();
        getBookings();

        // filling the listviews with data from the databases
        lvAgents.getItems().addAll(agtData);
        lvCustomers.getItems().addAll(custData);
        lvPackages.getItems().addAll(pkgData);
        lvBookings.getItems().addAll(bookingData);



        // setting each cell of the listview to be able to be clicked and selected based on their index
        lvAgents.setCellFactory(new Callback<ListView<Agent>, ListCell<Agent>>() {
            @Override
            public ListCell<Agent> call(ListView<Agent> param) {
                return new ListCell<Agent>() {
                    @Override
                    protected void updateItem(Agent item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item.toString());
                        }
                    }
                };
            }
        });

        // when a cell of the listview is clicked it will populate textfields with related data
        lvAgents.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Agent>() {
            @Override
            public void changed(ObservableValue<? extends Agent> observable, Agent oldValue, Agent newValue) {
                if (newValue != null) {
                    tfAgentId.setText(newValue.getAgentId() + "");
                    tfAgtFname.setText(newValue.getAgtFname());
                    tfAgtMiddleInitial.setText(newValue.getAgtMiddleInitial());
                    tfAgtLname.setText(newValue.getAgtLname());
                    tfAgtBusPhone.setText(newValue.getAgtPhone());
                    tfAgtEmail.setText(newValue.getAgtEmail());
                    tfAgtPosition.setText(newValue.getAgtPosition());
                    tfAgencyId.setText(newValue.getAgencyId() + "");
                }
            }
        });

        // when an edit button is clicked it will enable the textfields to be edited and will also enable the save button which will save these edits
        btnEditAgt.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnEditAgt.setDisable(true);
                btnSaveAgt.setDisable(false);
                btnAddAgt.setDisable(true);
                enableAgentTextFields();
            }
        });

        // connecting to the database and saving the changes made from edits
        btnSaveAgt.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnEditAgt.setDisable(false);
                btnAddAgt.setDisable(false);

                int agentId = Integer.parseInt(tfAgentId.getText());
                String agtFname = tfAgtFname.getText();
                String agtMiddleInitial = tfAgtMiddleInitial.getText();
                String agtLname = tfAgtLname.getText();
                String agtPhone = tfAgtBusPhone.getText();
                String agtEmail = tfAgtEmail.getText();
                String agtPosition = tfAgtPosition.getText();
                int agencyId = Integer.parseInt(tfAgencyId.getText());
                Agent putAgent = new Agent(agentId, agtFname, agtMiddleInitial, agtLname, agtPhone,
                        agtEmail, agtPosition, agencyId);

                try {
                    FileInputStream fis = new FileInputStream("c:\\connection.properties");
                    Properties p = new Properties();
                    p.load(fis);
                    url = (String)p.get("url");
                    user = (String) p.get("user");
                    password = (String)p.get("password");
                    Connection conn = DriverManager.getConnection(url, user, password);
                    PreparedStatement pStmt = conn.prepareStatement("UPDATE `agents` SET `AgtFirstName`=?,`AgtMiddleInitial`=?,`AgtLastName`=?," +
                            "`AgtBusPhone`=?,`AgtEmail`=?,`AgtPosition`=?,`AgencyId`=? WHERE `AgentId`=?");
                    pStmt.setString(1, putAgent.getAgtFname());
                    pStmt.setString(2, putAgent.getAgtMiddleInitial());
                    pStmt.setString(3, putAgent.getAgtLname());
                    pStmt.setString(4, putAgent.getAgtPhone());
                    pStmt.setString(5, putAgent.getAgtEmail());
                    pStmt.setString(6, putAgent.getAgtPosition());
                    pStmt.setInt(7, putAgent.getAgencyId());
                    pStmt.setInt(8, putAgent.getAgentId());
                    pStmt.executeUpdate();
                    conn.close();

                } catch (IOException | SQLException e) {
                    new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
                }

                btnSaveAgt.setDisable(true);
                disableAgentTextFields();
                refreshGUI();
            }
        });

        // loading up the Insert scene when clicked for the user to add new entries
        btnAddAgt.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("insert-agent-view.fxml"));
                Parent mainScene;
                try {
                    mainScene = fxmlLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                InsertAgentController insertAgentController = fxmlLoader.getController();
                Scene scene = new Scene(mainScene);
                Stage stage = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });

        btnDeleteAgt.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Agent selectedAgent = lvAgents.getSelectionModel().getSelectedItem();
                if(selectedAgent != null)
                {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Delete Agent");
                    alert.setHeaderText("Are you sure you want to delete this Agent?");
                    alert.setContentText("This delete will be permanent and cannot be undone");
                    Optional<ButtonType> result = alert.showAndWait();
                    if(result.get() == ButtonType.OK)
                    {
                        try {
                            FileInputStream fis = new FileInputStream("c:\\connection.properties");
                            Properties p = new Properties();
                            p.load(fis);
                            url = (String)p.get("url");
                            user = (String) p.get("user");
                            password = (String)p.get("password");
                            Connection conn = DriverManager.getConnection(url, user, password);
                            PreparedStatement pStmt = conn.prepareStatement("DELETE from `agents` WHERE AgentId=?");
                            pStmt.setInt(1, Integer.parseInt(tfAgentId.getText()));
                            pStmt.executeUpdate();
                            conn.close();

                            agtData.remove(selectedAgent);
                            lvAgents.refresh();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                refreshGUI();
            }
        });

        // setting each cell of the listview to be able to be clicked and selected based on their index - Trevor Penner
        lvCustomers.setCellFactory(new Callback<ListView<Customer>, ListCell<Customer>>() {
            @Override
            public ListCell<Customer> call(ListView<Customer> param) {
                return new ListCell<Customer>() {
                    @Override
                    protected void updateItem(Customer item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item.toString());
                        }
                    }
                };
            }
        });

        // when a cell of the listview is clicked it will populate textfields with related data - Trevor Penner
        lvCustomers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Customer>() {
            @Override
            public void changed(ObservableValue<? extends Customer> observable, Customer oldValue, Customer newValue) {
                if (newValue != null) {
                    tfCustId.setText(newValue.getCustomerId() + "");
                    tfCustFname.setText(newValue.getCustFname());
                    tfCustLname.setText(newValue.getCustLname());
                    tfCustAddress.setText(newValue.getCustAddress());
                    tfCustCity.setText(newValue.getCustCity());
                    tfCustProvince.setText(newValue.getCustProv());
                    tfCustPostal.setText(newValue.getCustPostal());
                    tfCustCountry.setText(newValue.getCustCountry());
                    tfCustHomePhone.setText(newValue.getCustHomePhone());
                    tfCustBusPhone.setText(newValue.getCustBusPhone());
                    tfCustEmail.setText(newValue.getCustEmail());
                    tfCustAgtId.setText(newValue.getCustAgtId() + "");
                }
            }
        });

        // when an edit button is clicked it will enable the textfields to be edited and will also enable the save button which will save these edits - Trevor Penner
        btnEditCust.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnEditCust.setDisable(true);
                btnSaveCust.setDisable(false);
                btnAddCust.setDisable(true);
                enableCustomerTextFields();
            }
        });

        // connecting to the database and saving the changes made from edits - Trevor Penner
        btnSaveCust.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnEditCust.setDisable(false);
                btnAddCust.setDisable(false);

                int customerId = Integer.parseInt(tfCustId.getText());
                String custFname = tfCustFname.getText();
                String custLname = tfCustLname.getText();
                String custAddress = tfCustAddress.getText();
                String custCity = tfCustCity.getText();
                String custProv = tfCustProvince.getText();
                String custPostal = tfCustPostal.getText();
                String custCountry = tfCustCountry.getText();
                String custHomePhone = tfCustHomePhone.getText();
                String custBusPhone = tfCustBusPhone.getText();
                String custEmail = tfCustEmail.getText();
                int custAgtId = Integer.parseInt(tfCustAgtId.getText());
                Customer putCust = new Customer(customerId, custFname, custLname, custAddress, custCity,
                        custProv, custPostal, custCountry, custHomePhone, custBusPhone, custEmail, custAgtId);

                try {
                    FileInputStream fis = new FileInputStream("c:\\connection.properties");
                    Properties p = new Properties();
                    p.load(fis);
                    url = (String)p.get("url");
                    user = (String) p.get("user");
                    password = (String)p.get("password");
                    Connection conn = DriverManager.getConnection(url, user, password);
                    PreparedStatement pStmt = conn.prepareStatement("UPDATE `customers` SET `CustFirstName`=?,`CustLastName`=?,`CustAddress`=?," +
                            "`CustCity`=?,`CustProv`=?,`CustPostal`=?,`CustCountry`=?,`CustHomePhone`=?,`CustBusPhone`=?,`CustEmail`=?," +
                            "`AgentId`=? WHERE `CustomerId`=?");
                    pStmt.setString(1, putCust.getCustFname());
                    pStmt.setString(2, putCust.getCustLname());
                    pStmt.setString(3, putCust.getCustAddress());
                    pStmt.setString(4, putCust.getCustCity());
                    pStmt.setString(5, putCust.getCustProv());
                    pStmt.setString(6, putCust.getCustPostal());
                    pStmt.setString(7, putCust.getCustCountry());
                    pStmt.setString(8, putCust.getCustHomePhone());
                    pStmt.setString(9, putCust.getCustBusPhone());
                    pStmt.setString(10, putCust.getCustEmail());
                    pStmt.setInt(11, putCust.getCustAgtId());
                    pStmt.setInt(12, putCust.getCustomerId());

                    pStmt.executeUpdate();
                    conn.close();

                } catch (IOException | SQLException e) {
                    new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
                }

                btnSaveCust.setDisable(true);
                disableCustomerTextFields();
                refreshGUI();
            }
        });

        // loading up the Insert scene when clicked for the user to add new entries - Trevor Penner
        btnAddCust.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("insert-cust-view.fxml"));
                Parent mainScene;
                try {
                    mainScene = fxmlLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                InsertCustomerController insertCustomerController = fxmlLoader.getController();
                Scene scene = new Scene(mainScene);
                Stage stage = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });

        btnDeleteCust.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Customer selectedCust= lvCustomers.getSelectionModel().getSelectedItem();
                if(selectedCust != null)
                {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Delete Customer");
                    alert.setHeaderText("Are you sure you want to delete this Customer?");
                    alert.setContentText("This delete will be permanent and cannot be undone");
                    Optional<ButtonType> result = alert.showAndWait();
                    if(result.get() == ButtonType.OK)
                    {
                        try {
                            FileInputStream fis = new FileInputStream("c:\\connection.properties");
                            Properties p = new Properties();
                            p.load(fis);
                            url = (String)p.get("url");
                            user = (String) p.get("user");
                            password = (String)p.get("password");
                            Connection conn = DriverManager.getConnection(url, user, password);
                            PreparedStatement pStmt = conn.prepareStatement("DELETE from `customers` WHERE CustomerId=?");
                            pStmt.setInt(1, Integer.parseInt(tfCustId.getText()));
                            pStmt.executeUpdate();
                            conn.close();

                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                refreshGUI();
            }
        });

        // setting each cell of the listview to be able to be clicked and selected based on their index - Trevor Penner
        lvPackages.setCellFactory(new Callback<ListView<Package>, ListCell<Package>>() {
            @Override
            public ListCell<Package> call(ListView<Package> param) {
                return new ListCell<Package>() {
                    @Override
                    protected void updateItem(Package item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item.toString());
                        }
                    }
                };
            }
        });

        // when a cell of the listview is clicked it will populate textfields with related data - Trevor Penner
        lvPackages.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Package>() {
            @Override
            public void changed(ObservableValue<? extends Package> observable, Package oldValue, Package newValue) {
                if (newValue != null) {
                    tfPkgId.setText(newValue.getPkgId() + "");
                    tfPkgName.setText(newValue.getPkgName());
                    //tfPkgStartDate.setText(newValue.getPkgStartDate());
                    //tfPkgEndDate.setText(newValue.getPkgEndDate());
                    pickerPkgStartDate.setValue(newValue.getPkgStartDate());
                    pickerPkgEndDate.setValue(newValue.getPkgEndDate());
                    tfPkgDesc.setText(newValue.getPkgDescription());
                    tfPkgBasePrice.setText(newValue.getPkgBasePrice() + "");
                    tfPkgCommission.setText(newValue.getPkgCommission() + "");
                }
            }
        });

        // when an edit button is clicked it will enable the textfields to be edited and will also enable the save button which will save these edits - Trevor Penner
        btnEditPkg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnEditPkg.setDisable(true);
                btnSavePkg.setDisable(false);
                btnAddPkg.setDisable(true);
                enablePackageTextFields();
            }
        });

        // connecting to the database and saving the changes made from edits - Trevor Penner
        btnSavePkg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnEditPkg.setDisable(false);
                btnAddPkg.setDisable(false);

                int packageId = Integer.parseInt(tfCustId.getText());
                String pkgName = tfCustFname.getText();
                //String pkgStartDate = tfCustLname.getText();
                //String pkgEndDate = tfCustAddress.getText();
                LocalDate pkgStartDate = pickerPkgStartDate.getValue();
                LocalDate pkgEndDate = pickerPkgEndDate.getValue();
                String pkgDesc = tfCustCity.getText();
                double pkgBasePrice = Double.parseDouble(tfCustProvince.getText());
                double pkgCommission = Double.parseDouble(tfCustPostal.getText());

                Package putPkg = new Package(packageId, pkgName, pkgStartDate, pkgEndDate, pkgDesc,
                        pkgBasePrice, pkgCommission);

                try {
                    FileInputStream fis = new FileInputStream("c:\\connection.properties");
                    Properties p = new Properties();
                    p.load(fis);
                    url = (String)p.get("url");
                    user = (String) p.get("user");
                    password = (String)p.get("password");
                    Connection conn = DriverManager.getConnection(url, user, password);
                    PreparedStatement pStmt = conn.prepareStatement("UPDATE `packages` SET `PkgName`=?,`PkgStartDate`=?," +
                            "`PkgEndDate`=?,`PkgDesc`=?,`PkgBasePrice`=?,`PkgAgencyCommission`=? WHERE `PackageId`=?");
                    pStmt.setString(1, putPkg.getPkgName());
                    pStmt.setObject(2, putPkg.getPkgStartDate());
                    pStmt.setObject(3, putPkg.getPkgEndDate());
                    pStmt.setString(4, putPkg.getPkgDescription());
                    pStmt.setDouble(5, putPkg.getPkgBasePrice());
                    pStmt.setDouble(6, putPkg.getPkgCommission());
                    pStmt.setInt(7, putPkg.getPkgId());

                    pStmt.executeUpdate();
                    conn.close();

                } catch (IOException | SQLException e) {
                    new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
                }

                btnSavePkg.setDisable(true);
                disablePackageTextFields();
                refreshGUI();
            }
        });

        // loading up the Insert scene when clicked for the user to add new entries - Trevor Penner
        btnAddPkg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("insert-pkg-view.fxml"));
                Parent mainScene;
                try {
                    mainScene = fxmlLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                InsertPackageController insertPackageController = fxmlLoader.getController();
                Scene scene = new Scene(mainScene);
                Stage stage = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });

        btnDeletePkg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Package selectedPackage = lvPackages.getSelectionModel().getSelectedItem();
                if(selectedPackage != null)
                {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Delete Package");
                    alert.setHeaderText("Are you sure you want to delete this Package?");
                    alert.setContentText("This delete will be permanent and cannot be undone");
                    Optional<ButtonType> result = alert.showAndWait();
                    if(result.get() == ButtonType.OK)
                    {
                        try {
                            FileInputStream fis = new FileInputStream("c:\\connection.properties");
                            Properties p = new Properties();
                            p.load(fis);
                            url = (String)p.get("url");
                            user = (String) p.get("user");
                            password = (String)p.get("password");
                            Connection conn = DriverManager.getConnection(url, user, password);
                            PreparedStatement pStmt = conn.prepareStatement("DELETE from `packages` WHERE PackageId=?");
                            pStmt.setInt(1, Integer.parseInt(tfPkgId.getText()));
                            pStmt.executeUpdate();
                            conn.close();


                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
                refreshGUI();
            }
        });

        // setting each cell of the listview to be able to be clicked and selected based on their index - Trevor Penner
        lvBookings.setCellFactory(new Callback<ListView<Booking>, ListCell<Booking>>() {
            @Override
            public ListCell<Booking> call(ListView<Booking> param) {
                return new ListCell<Booking>() {
                    @Override
                    protected void updateItem(Booking item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item.toString());
                        }
                    }
                };
            }
        });


        // when a cell of the listview is clicked it will populate textfields with related data - Trevor Penner
        lvBookings.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Booking>() {
            @Override
            public void changed(ObservableValue<? extends Booking> observable, Booking oldValue, Booking newValue) {
                if (newValue != null) {
                    tfBookingId.setText(newValue.getBookingId() + "");
                    //tfBookingDate.setText(String.valueOf(newValue.getBookingDate()));
                    pickerBookingDate.setValue(newValue.getBookingDate());
                    tfBookingNo.setText(newValue.getBookingNo());
                    tfTravelerCount.setText(newValue.getBookingTravelerCount() + "");
                    tfBookingCustId.setText(newValue.getBookingCustId() + "");
                    tfTripType.setText(newValue.getBookingTripType());
                    tfBookingPkgId.setText(newValue.getBookingPkgId() + "");
                }
            }
        });

        // when an edit button is clicked it will enable the textfields to be edited and will also enable the save button which will save these edits - Trevor Penner
        btnEditBooking.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnEditBooking.setDisable(true);
                btnSaveBooking.setDisable(false);
                btnAddBooking.setDisable(true);
                enableBookingTextFields();
            }
        });

        // connecting to the database and saving the changes made from edits - Trevor Penner
        btnSaveBooking.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnEditBooking.setDisable(false);
                btnAddBooking.setDisable(false);

                int bookingId = Integer.parseInt(tfBookingId.getText());
                //LocalDate bookingDate = LocalDate.parse(tfBookingDate.getText());
                LocalDate bookingDate = pickerBookingDate.getValue();
                String bookingNo = tfBookingNo.getText();
                int travelerCount = Integer.parseInt(tfTravelerCount.getText());
                int bookingCustId = Integer.parseInt(tfBookingCustId.getText());
                String tripType = tfTripType.getText();
                int bookingPkgId = Integer.parseInt(tfBookingPkgId.getText());

                Booking putBooking = new Booking(bookingId, bookingDate, bookingNo, travelerCount, bookingCustId,
                        tripType, bookingPkgId);

                try {
                    FileInputStream fis = new FileInputStream("c:\\connection.properties");
                    Properties p = new Properties();
                    p.load(fis);
                    url = (String)p.get("url");
                    user = (String) p.get("user");
                    password = (String)p.get("password");
                    Connection conn = DriverManager.getConnection(url, user, password);
                    PreparedStatement pStmt = conn.prepareStatement("UPDATE `bookings` SET `BookingDate`=?,`BookingNo`=?,`TravelerCount`=?,`CustomerId`=?," +
                            "`TripTypeId`=?,`PackageId`=? WHERE `BookingId`=?");
                    pStmt.setObject(1, putBooking .getBookingDate());
                    pStmt.setString(2, putBooking .getBookingNo());
                    pStmt.setInt(3, putBooking .getBookingTravelerCount());
                    pStmt.setInt(4, putBooking .getBookingCustId());
                    pStmt.setString(5, putBooking .getBookingTripType());
                    pStmt.setInt(6, putBooking .getBookingPkgId());
                    pStmt.setInt(7, putBooking .getBookingId());

                    pStmt.executeUpdate();
                    conn.close();

                } catch (IOException | SQLException e) {
                    new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
                }

                btnSaveBooking.setDisable(true);
                disableBookingTextFields();
                refreshGUI();
            }
        });

        // loading up the Insert scene when clicked for the user to add new entries - Trevor Penner
        btnAddBooking.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("insert-booking-view.fxml"));
                Parent mainScene;
                try {
                    mainScene = fxmlLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                InsertBookingcontroller insertBookingcontroller = fxmlLoader.getController();
                Scene scene = new Scene(mainScene);
                Stage stage = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });

        btnDeleteBooking.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Booking selectedBooking = lvBookings.getSelectionModel().getSelectedItem();
                if(selectedBooking != null)
                {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Delete Booking");
                    alert.setHeaderText("Are you sure you want to delete this Booking?");
                    alert.setContentText("This delete will be permanent and cannot be undone");
                    Optional<ButtonType> result = alert.showAndWait();
                    if(result.get() == ButtonType.OK)
                    {
                        try {
                            FileInputStream fis = new FileInputStream("c:\\connection.properties");
                            Properties p = new Properties();
                            p.load(fis);
                            url = (String)p.get("url");
                            user = (String) p.get("user");
                            password = (String)p.get("password");
                            Connection conn = DriverManager.getConnection(url, user, password);
                            PreparedStatement pStmt = conn.prepareStatement("DELETE from `bookings` WHERE BookingId=?");
                            pStmt.setInt(1, Integer.parseInt(tfBookingId.getText()));
                            pStmt.executeUpdate();
                            conn.close();


                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                refreshGUI();
            }
        });

    }


    // disabling editing of these fields because they are auto generated by the database and editing them could corrupt the data
    private void disablePrimaryKeyTextFields() {
        tfAgentId.setDisable(true);
        tfCustId.setDisable(true);
        tfPkgId.setDisable(true);
        tfBookingId.setDisable(true);
    }

    private void disableAgentTextFields() {
        tfAgtFname.setDisable(true);
        tfAgtMiddleInitial.setDisable(true);
        tfAgtLname.setDisable(true);
        tfAgtBusPhone.setDisable(true);
        tfAgtEmail.setDisable(true);
        tfAgtPosition.setDisable(true);
        tfAgencyId.setDisable(true);
    }
    private void enableAgentTextFields(){

        tfAgtFname.setDisable(false);
        tfAgtMiddleInitial.setDisable(false);
        tfAgtLname.setDisable(false);
        tfAgtBusPhone.setDisable(false);
        tfAgtEmail.setDisable(false);
        tfAgtPosition.setDisable(false);
        tfAgencyId.setDisable(false);
    }
    private void disableCustomerTextFields(){
        tfCustFname.setDisable(true);
        tfCustLname.setDisable(true);
        tfCustAddress.setDisable(true);
        tfCustCity.setDisable(true);
        tfCustProvince.setDisable(true);
        tfCustPostal.setDisable(true);
        tfCustCountry.setDisable(true);
        tfCustHomePhone.setDisable(true);
        tfCustBusPhone.setDisable(true);
        tfCustEmail.setDisable(true);
        tfCustAgtId.setDisable(true);
    }
    private void enableCustomerTextFields(){
        tfCustFname.setDisable(false);
        tfCustLname.setDisable(false);
        tfCustAddress.setDisable(false);
        tfCustCity.setDisable(false);
        tfCustProvince.setDisable(false);
        tfCustPostal.setDisable(false);
        tfCustCountry.setDisable(false);
        tfCustHomePhone.setDisable(false);
        tfCustBusPhone.setDisable(false);
        tfCustEmail.setDisable(false);
        tfCustAgtId.setDisable(false);
    }
    private void disablePackageTextFields(){
        tfPkgName.setDisable(true);
        //tfPkgStartDate.setDisable(true);
        //tfPkgEndDate.setDisable(true);
        pickerPkgEndDate.setDisable(true);
        pickerPkgStartDate.setDisable(true);
        tfPkgDesc.setDisable(true);
        tfPkgBasePrice.setDisable(true);
        tfPkgCommission.setDisable(true);
    }
    private void enablePackageTextFields(){
        tfPkgName.setDisable(false);
        //tfPkgStartDate.setDisable(false);
        //tfPkgEndDate.setDisable(false);
        pickerPkgEndDate.setDisable(false);
        pickerPkgStartDate.setDisable(false);
        tfPkgDesc.setDisable(false);
        tfPkgBasePrice.setDisable(false);
        tfPkgCommission.setDisable(false);
    }
    private void disableBookingTextFields(){
        tfBookingId.setDisable(true);
        //tfBookingDate.setDisable(true);
        pickerBookingDate.setDisable(true);
        tfBookingNo.setDisable(true);
        tfTravelerCount.setDisable(true);
        tfBookingCustId.setDisable(true);
        tfTripType.setDisable(true);
        tfBookingPkgId.setDisable(true);
    }
    private void enableBookingTextFields(){
        //tfBookingDate.setDisable(false);
        pickerBookingDate.setDisable(false);
        tfBookingNo.setDisable(false);
        tfTravelerCount.setDisable(false);
        tfBookingCustId.setDisable(false);
        tfTripType.setDisable(false);
        tfBookingPkgId.setDisable(false);
    }


    private void getAgents() {


        try {
            FileInputStream fis = new FileInputStream("c:\\connection.properties");
            Properties p = new Properties();
            p.load(fis);
            url = (String)p.get("url");
            user = (String) p.get("user");
            password = (String)p.get("password");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from agents");
            while(rs.next()){
                agtData.add(new Agent(rs.getInt(1), rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6),
                        rs.getString(7),rs.getInt(8)));

            }
            conn.close();
        } catch (IOException | SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
        }
    }

    private void editAgents(){

    }

    private void getCustomers() {
        //agtData.clear();

        try {
            FileInputStream fis = new FileInputStream("c:\\connection.properties");
            Properties p = new Properties();
            p.load(fis);
            url = (String)p.get("url");
            user = (String) p.get("user");
            password = (String)p.get("password");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customers");
            while(rs.next()){
                custData.add(new Customer(rs.getInt(1), rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6),
                        rs.getString(7),rs.getString(8), rs.getString(9) ,rs.getString(10),
                        rs.getString(11), rs.getInt(12)));

            }
            conn.close();
        } catch (IOException | SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
        }
    }

    private void getPackages() {
        //agtData.clear();


        try {
            FileInputStream fis = new FileInputStream("c:\\connection.properties");
            Properties p = new Properties();
            p.load(fis);
            url = (String)p.get("url");
            user = (String) p.get("user");
            password = (String)p.get("password");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from packages");
            while(rs.next()){
                pkgData.add(new Package(rs.getInt(1), rs.getString(2),rs.getDate(3).toLocalDate(),
                        rs.getDate(4).toLocalDate(),rs.getString(5),rs.getDouble(6),
                        rs.getDouble(7)));

            }
            conn.close();
        } catch (IOException | SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
        }
    }

    private void getBookings() {
        //agtData.clear();


        try {
            FileInputStream fis = new FileInputStream("c:\\connection.properties");
            Properties p = new Properties();
            p.load(fis);
            url = (String)p.get("url");
            user = (String) p.get("user");
            password = (String)p.get("password");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from bookings");
            while(rs.next()){
                bookingData.add(new Booking(rs.getInt(1), rs.getDate(2).toLocalDate(),rs.getString(3),
                        rs.getInt(4),rs.getInt(5),rs.getString(6),
                        rs.getInt(7)));

            }
            conn.close();
        } catch (IOException | SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
        }
    }

    // refreshing the listviews- will be called when edits or deletions are made to the GUI updates with the new data
    private void refreshGUI() {

        agtData.clear();
        getAgents();
        lvAgents.setItems(agtData);

        custData.clear();
        getCustomers();
        lvCustomers.setItems(custData);

        pkgData.clear();
        getPackages();
        lvPackages.setItems(pkgData);

        bookingData.clear();
        getBookings();
        lvBookings.setItems(bookingData);
    }
}
