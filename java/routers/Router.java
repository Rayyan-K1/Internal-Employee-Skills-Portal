package routers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Router{
    private static final String CSS_FILE = "/css/style.css";
    private static FXMLLoader fxmlLoader;
    private static Stage stage;

    public static void changeRoute(RouteNames route, ActionEvent actionEvent) throws IOException {
        fxmlLoader = new FXMLLoader(Router.class.getResource(route.location));
        Parent root  = fxmlLoader.load();
        Scene scene = new Scene(root);
        root.getStylesheets().add(routers.Router.class.getResource(CSS_FILE).toExternalForm());

        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

}