
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        root.setCenter(new ShapedButton(7,3));
        stage.setMinHeight(200);
        stage.setMinWidth(200);
        stage.setScene(new Scene(root));
        stage.show();
        
    }
}
