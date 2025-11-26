package controllers;

import globals.DependencyContainer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.SkillStrength;
import models.Staff;
import models.UserType;
import service.JobRoleService;
import service.StaffService;

import java.io.IOException;

import static javax.swing.JOptionPane.showMessageDialog;

public class ManagerViewEditStaff {
    @FXML
    private ListView StaffMember;
    @FXML
    private TextField firstName;
    @FXML
    private TextField surname;
    @FXML
    private Button ManagerViewEditStaff_Edit;
    @FXML
    private Button ManagerViewEditStaff_Save;
    @FXML
    private Button ManagerViewEditStaff_Delete;
    @FXML
    private TextField username;
    @FXML
    private ComboBox JobRoleFilter;
    @FXML
    private ComboBox SkillFilter;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox SystemRole;
    @FXML
    private ComboBox JobRole;
    @FXML
    private ListView AllocatedSkills;
    @FXML
    private ComboBox SkillStrengthFilter;
    private StaffService staffObj = new StaffService(DependencyContainer.getStaffRepository());
    private JobRoleService jobRoleObj = new JobRoleService(DependencyContainer.getJobRoleRepository());

    public void initialize() {
        this.showList("init");
    }

    private void showList(String state) {
        ObservableList StaffMemberItems = null;
        if(state.equals("init")) {
            StaffMemberItems = FXCollections.observableArrayList(this.staffObj.allStaff("All"));
            ObservableList StaffJobRoleItems = FXCollections.observableArrayList(this.jobRoleObj.allRoles());
            this.SystemRole.getItems().setAll(UserType.values());
            this.JobRole.setItems(StaffJobRoleItems);
            this.JobRoleFilter.setItems(StaffJobRoleItems);
            this.SkillStrengthFilter.getItems().setAll(SkillStrength.values());
        } else {
            StaffMemberItems = FXCollections.observableArrayList(this.staffObj.allStaff(state));
        }
        this.StaffMember.setItems(StaffMemberItems);
        this.StaffMember.refresh();
    }

    @FXML
    private void setJobRoleFilter() {
        String ChoiceBoxValue = null;
        try {
            ChoiceBoxValue = this.JobRoleFilter.getValue().toString();
            this.SkillStrengthFilter.getSelectionModel().select(-1);
            this.SkillFilter.getSelectionModel().select(-1);
        } catch (NullPointerException e) {

        }
        if(ChoiceBoxValue != null) {
            this.showList(ChoiceBoxValue);
        }
    }

    @FXML
    private void setSkillStrengthFilter() {
        String ChoiceBoxValue = null;
        try {
            ChoiceBoxValue = this.SkillStrengthFilter.getValue().toString();
            this.JobRoleFilter.getSelectionModel().select(-1);
            this.SkillFilter.getSelectionModel().select(-1);
        } catch(NullPointerException e) {

        }
        if(ChoiceBoxValue != null) {
            this.showList(ChoiceBoxValue);
        }
    }

    @FXML
    private void setSkillFilter() {
        String ChoiceBoxValue = null;
        try {
            ChoiceBoxValue = this.SkillFilter.getValue().toString();
            this.SkillStrengthFilter.getSelectionModel().select(-1);
            this.JobRoleFilter.getSelectionModel().select(-1);
        } catch(NullPointerException e) {

        }
        if(ChoiceBoxValue != null) {
            this.showList(ChoiceBoxValue);
        }
    }

    @FXML
    private void selectListItem() {
        Staff StaffDetails = (Staff) this.StaffMember.getSelectionModel().getSelectedItem();
        this.firstName.setText(StaffDetails.getStaffFirstname());
        this.surname.setText(StaffDetails.getStaffSurname());
        this.username.setText(StaffDetails.getStaffUsername());
        this.password.setText(StaffDetails.getStaffPassword());
        if(StaffDetails.getStaffUserRole().equals("Manager")) {
            this.SystemRole.getSelectionModel().select(0);
        } else {
            this.SystemRole.getSelectionModel().select(1);
        }
        switch(StaffDetails.getStaffRole()) {
            case "Junior Developer":
                this.JobRole.getSelectionModel().select(0);
                break;
            case "Mid-Level Developer":
                this.JobRole.getSelectionModel().select(1);
                break;
            case "Senior Developer":
                this.JobRole.getSelectionModel().select(2);
                break;
            default:
                this.JobRole.getSelectionModel().select(0);
        }
        try {
            this.AllocatedSkills.getItems().setAll(StaffDetails.getStaffSkillsArray());
        } catch (NullPointerException e) {
            System.out.println("No Staff Skills Attributed");
        }
    }

    @FXML
    private void editSelectedItem() {
        Staff StaffDetails = null;
        try {
            StaffDetails = (Staff) this.StaffMember.getSelectionModel().getSelectedItem();
        } catch (NullPointerException e) {
            showMessageDialog(null, "Please Select A User");
        }
        if(StaffDetails == null) {
            showMessageDialog(null, "Please Select A User");
        } else {
            this.firstName.setDisable(false);
            this.surname.setDisable(false);
            this.username.setDisable(false);
            this.password.setDisable(false);
            this.SystemRole.setDisable(false);
            this.JobRole.setDisable(false);
            this.ManagerViewEditStaff_Edit.setDisable(true);
            this.ManagerViewEditStaff_Save.setDisable(false);
            this.StaffMember.setDisable(true);
            this.ManagerViewEditStaff_Delete.setDisable(true);
        }
    }
    @FXML
    private void deleteStaff() {
        Staff StaffDetails = (Staff) this.StaffMember.getSelectionModel().getSelectedItem();
        staffObj.deleteStaff(StaffDetails.getStaffId().toString());
        this.showList("init");
        this.firstName.setText("");
        this.surname.setText("");
        this.username.setText("");
        this.password.setText("");
        this.SystemRole.getSelectionModel().select(-1);
        this.JobRole.getSelectionModel().select(-1);
        this.JobRoleFilter.getSelectionModel().select(-1);
    }

    public void saveButton() throws IOException {
        Staff StaffDetails = null;
        String firstName = null;
        String surname = null;
        String username = null;
        String password = null;
        String JobRoleDetails = null;
        String UserRole = null;
    try {
        StaffDetails = (Staff) this.StaffMember.getSelectionModel().getSelectedItem();
        firstName = this.firstName.getText();
        surname = this.surname.getText();
        username = this.username.getText();
        password = this.password.getText();
        JobRoleDetails = this.JobRole.getValue().toString();
        UserRole = this.SystemRole.getValue().toString();
    } catch (NullPointerException e) {
        showMessageDialog(null, "Please Complete All Fields");
    }
    if(StaffDetails == null || firstName.length() == 0 || surname.length() == 0 || username.length() == 0 || password.length() == 0 || JobRoleDetails.length() == 0||UserRole.length()==0) {
        showMessageDialog(null, "Please Complete All Fields");
    } else {
        this.firstName.setDisable(true);
        this.surname.setDisable(true);
        this.username.setDisable(true);
        this.password.setDisable(true);
        this.SystemRole.setDisable(true);
        this.JobRole.setDisable(true);
        this.ManagerViewEditStaff_Edit.setDisable(false);
        this.ManagerViewEditStaff_Save.setDisable(true);
        this.StaffMember.setDisable(false);
        this.ManagerViewEditStaff_Delete.setDisable(false);
        this.JobRoleFilter.getSelectionModel().select(-1);
        StaffDetails.setStaffFirstname(firstName);
        StaffDetails.setStaffSurname(surname);
        StaffDetails.setStaffUsername(username);
        StaffDetails.setStaffPassword(password);
        StaffDetails.setStaffRole(JobRoleDetails);
        StaffDetails.setStaffUserRole(UserRole);
//        StaffDetails.setStaffSkillsArrayList();
        this.showList("init");
    }
    }
}
