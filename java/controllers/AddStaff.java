package controllers;

import globals.DependencyContainer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.UserType;
import service.JobRoleService;
import service.StaffService;

import java.io.IOException;

import static javax.swing.JOptionPane.showMessageDialog;

public class AddStaff {
    @FXML
    private TextField FirstName;
    @FXML
    private TextField Surname;
    @FXML
    private TextField Username;
    @FXML
    private PasswordField Password;
    @FXML
    private ListView JobRole;
    @FXML
    private ComboBox UserRoleList;
    @FXML
    private ListView StaffMember;

    private JobRoleService JobRoleServiceObj = new JobRoleService(DependencyContainer.getJobRoleRepository());
    private StaffService StaffServiceObj = new StaffService(DependencyContainer.getStaffRepository());

    public void initialize() {
        this.showList();
    }
    private void showList() {
        ObservableList JobRoleItems = FXCollections.observableArrayList(this.JobRoleServiceObj.allRoles());
        this.JobRole.setItems(JobRoleItems);
        UserRoleList.getItems().setAll(UserType.values());
    }
    @FXML
    private void selectItemFromList() {
        Object JobRoleDetails = this.JobRole.getSelectionModel().getSelectedItem();
    }
    @FXML
    public void addStaff() throws IOException {
        String FirstName = null;
        String Surname = null;
        String Username = null;
        String Password = null;
        String JobRoleDetails = null;
        String UserRole = null;
        try {
            FirstName = this.FirstName.getText();
            Surname = this.Surname.getText();
            Username = this.Username.getText();
            Password = this.Password.getText();
            JobRoleDetails = this.JobRole.getSelectionModel().getSelectedItem().toString();
            UserRole = this.UserRoleList.getValue().toString();
        } catch (NullPointerException e) {
            showMessageDialog(null, "Please Complete All Fields");
        }
        if(FirstName.length() == 0 || Surname.length() == 0 || Username.length() == 0 || Password.length() == 0 || JobRoleDetails.length() == 0 || UserRole.length() == 0) {

        } else {
            try {
                StaffServiceObj.addStaff(FirstName, Surname, Username, Password, JobRoleDetails, UserRole, null);
                clearForm();
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    private void clearForm(){
        FirstName.clear();
        Surname.clear();
        Username.clear();
        Password.clear();
    }
}
