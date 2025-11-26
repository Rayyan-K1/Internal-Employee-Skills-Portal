package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import routers.RouteNames;
import routers.Router;
import java.io.IOException;

public class ManagerMainMenu {
    @FXML
    private void viewEditStaff(ActionEvent event) throws IOException {
        Router.changeRoute(RouteNames.VIEW_EDIT_STAFF, event);
    }
    @FXML
    private void addStaff(ActionEvent event) throws IOException {
        Router.changeRoute(RouteNames.ADD_STAFF, event);
    }
    @FXML
    private void viewEditSkills(ActionEvent event) throws IOException {
        Router.changeRoute(RouteNames.VIEW_EDIT_SKILLS, event);
    }
    @FXML
    private void addSkill(ActionEvent event) throws IOException {
        Router.changeRoute(RouteNames.ADD_SKILL, event);
    }
    @FXML
    private void logout(ActionEvent event) throws IOException {
        Router.changeRoute(RouteNames.HOME, event);
    }
}
