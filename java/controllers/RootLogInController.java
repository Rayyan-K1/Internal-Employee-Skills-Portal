package controllers;

import globals.DependencyContainer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.Staff;
import routers.RouteNames;
import routers.Router;
import service.StaffService;

import java.io.IOException;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;


public class RootLogInController {
    @FXML
    private TextField RootUsername;
    @FXML
    private PasswordField RootPassword;

    private StaffService StaffServiceObj = new StaffService(DependencyContainer.getStaffRepository());

    @FXML
    private void enableLogin(ActionEvent event) throws IOException {
        String RootUsername = this.RootUsername.getText();
        String RootPassword = this.RootPassword.getText();
        int isSignedIn = 0;
        List<Staff> AllStaff = StaffServiceObj.allStaff("All");
        for (Staff staffIteration: AllStaff) {
            isSignedIn = 0;
            if(staffIteration.getStaffUsername().equals(RootUsername)) {
                isSignedIn++;
                if(staffIteration.getStaffPassword().equals(RootPassword)) {
                    isSignedIn++;
                    if(staffIteration.getStaffUserRole().equals("Manager")) {
                        isSignedIn++;
                        Router.changeRoute(RouteNames.MANAGER_MAIN_MENU, event);
                        break;
                    }
                }
            }
        }
        if(isSignedIn > 0) {
            showMessageDialog(null, "Credentials Correct, Proceeding With Login");
        } else {
            showMessageDialog(null, "Incorrect Credentials");
        }
    }
    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Router.changeRoute(RouteNames.HOME, event);
    }
}
