package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import routers.RouteNames;
import routers.Router;

import java.io.IOException;

public class StaffMainMenu {
    @FXML
    private void logout(ActionEvent event) throws IOException {
        Router.changeRoute(RouteNames.HOME, event);
    }
    @FXML
    private void showStaffDetails(ActionEvent event) throws IOException {
        Router.changeRoute(RouteNames.STAFF_DETAILS, event);
    }
    @FXML
    private void showStaffSkills(ActionEvent event) throws IOException {
        Router.changeRoute(RouteNames.STAFF_SKILLS, event);
    }
}
