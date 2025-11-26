package controllers;

import globals.DependencyContainer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import models.Staff;
import models.StaffSkills;
import service.StaffSkillsService;

import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class StaffViewEditDetails extends StaffLogInController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField surname;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private ChoiceBox StaffDetails_JobRole;
    @FXML
    private Button editDetails;
    @FXML
    private Button saveDetails;
    private StaffSkillsService staffSkillsObj = new StaffSkillsService(DependencyContainer.getStaffSkillRepository());
    public void initialize() {
        setInitialData();
    }

    private void setInitialData() {
//        StaffLogInController staffLogInController = new StaffLogInController();
        Staff StaffData = super.getLoggedInUser();
        this.firstName.setText(StaffData.getStaffFirstname());
        this.surname.setText(StaffData.getStaffSurname());
        this.username.setText(StaffData.getStaffUsername());
        this.password.setText(StaffData.getStaffPassword());
        firstName.setDisable(true);
        surname.setDisable(true);
        username.setDisable(true);
        password.setDisable(true);
        StaffDetails_JobRole.setDisable(true);
        if(StaffData.getStaffRole().equals("Junior Developer")) {
            this.StaffDetails_JobRole.getSelectionModel().select(0);
        } else if(StaffData.getStaffRole().equals("Mid-Level Developer")){
            this.StaffDetails_JobRole.getSelectionModel().select(1);
        } else {
            this.StaffDetails_JobRole.getSelectionModel().select(2);
        }
    }
    @FXML
    private void editStaffDetails(){
        this.firstName.setDisable(false);
        this.surname.setDisable(false);
        this.username.setDisable(false);
        this.password.setDisable(false);
        this.StaffDetails_JobRole.setDisable(false);
        this.editDetails.setDisable(true);
        this.saveDetails.setDisable(false);
    }
    @FXML
    private void saveStaffDetails() {
        String Firstname= null;
        String Surname = null;
        String Username = null;
        String Password = null;
        String JobRole = null;
//        StaffLogInController staffLogInController = new StaffLogInController();
        Staff StaffData = super.getLoggedInUser();
    try {
        Firstname = this.firstName.getText();
        Surname = this.surname.getText();
        Username = this.username.getText();
        Password = this.password.getText();
        JobRole = this.StaffDetails_JobRole.getValue().toString();
    } catch (NullPointerException e) {
        showMessageDialog(null, "Please Complete All Fields");
    }
    if(Firstname.length() == 0 || Surname.length() == 0 || Username.length() == 0 || Password.length() == 0|| JobRole.length() == 0) {
        showMessageDialog(null, "Please Complete All Fields");
    } else {
        List<StaffSkills> StaffSkillsArrayList = staffSkillsObj.allStaffSkills();
        firstName.setDisable(true);
        surname.setDisable(true);
        username.setDisable(true);
        password.setDisable(true);
        StaffDetails_JobRole.setDisable(true);
        editDetails.setDisable(false);
        saveDetails.setDisable(true);
        StaffData.setStaffFirstname(Firstname);
        StaffData.setStaffSurname(Surname);
        StaffData.setStaffUsername(Username);
        StaffData.setStaffPassword(Password);
        StaffData.setStaffRole(JobRole);
        StaffData.setStaffSkillsArrayList(StaffSkillsArrayList);
    }
    }
}
