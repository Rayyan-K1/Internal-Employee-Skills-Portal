import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import routers.RouteNames;
import routers.Router;

import java.io.IOException;
import java.util.logging.Logger;

public class FXMLMain{
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @FXML
    private Label label;

    @FXML
    private void goToManagerLogin(ActionEvent event) throws IOException {
        LOGGER.info("Routing to Manager log in page");
        Router.changeRoute(RouteNames.MANAGER_LOGIN, event);
    }
    @FXML
    private void goToStaffLogin(ActionEvent event) throws IOException {
        LOGGER.info("Routing to Staff log in page");
        Router.changeRoute(RouteNames.STAFF_LOGIN, event);
    }

    @FXML
    private void quitApplication(ActionEvent event) {
        Platform.exit();
    }
}
