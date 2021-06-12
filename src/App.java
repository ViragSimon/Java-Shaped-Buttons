
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception{
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        root.setCenter(new ShapedButton(6));
        stage.setMinHeight(500);
        stage.setMinWidth(500);
        stage.setScene(new Scene(root));
        stage.show();
        
    }
}
