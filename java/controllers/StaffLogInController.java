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

public class StaffLogInController {
    @FXML
    private TextField StaffUsername;
    @FXML
    private PasswordField StaffPassword;
    private StaffService staffObj = new StaffService(DependencyContainer.getStaffRepository());
    public static Staff staffDataObj;

    @FXML
    private void submitLogin(ActionEvent event) throws IOException {
        String username = this.StaffUsername.getText();
        String password = this.StaffPassword.getText();
        int isSignedIn = 0;
        List<Staff> allStaffGet = staffObj.allStaff("All");
        for (Staff staffIteration: allStaffGet) {
            isSignedIn = 0;
            if(staffIteration.getStaffUsername().equals(username)) {
                isSignedIn++;
                if(staffIteration.getStaffPassword().equals(password)) {
                    isSignedIn++;
                    if(staffIteration.getStaffUserRole().equals("User")) {
                        isSignedIn++;
                        this.staffDataObj = staffIteration;
                        Router.changeRoute(RouteNames.STAFF_MAIN_MENU, event);
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

    Staff getLoggedInUser() {
        return this.staffDataObj;
    }
    @FXML
    private void backButton(ActionEvent event) throws IOException {
        Router.changeRoute(RouteNames.HOME, event);
    }
}
