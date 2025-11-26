import globals.DependencyContainer;
import globals.FakeDatabase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import repositories.JobRoleRepository;
import repositories.SkillRepository;
import repositories.StaffRepository;
import repositories.StaffSkillRepository;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Creates a public object that could be accessed via anything (but in our case via the Repository classes).
        FakeDatabase fd = new FakeDatabase();
        //Manual/concrete Dependencies - Need to be modified to use interfaces
        new DependencyContainer(new SkillRepository(fd), new StaffRepository(fd), new JobRoleRepository(fd), new StaffSkillRepository(fd));

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/FXMLMain.fxml"));
            root.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
