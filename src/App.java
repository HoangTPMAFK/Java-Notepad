import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        // String stringPath = "Working Directory = " + System.getProperty("user.dir") + "\\image\\kate_logo.png";
        // System.out.println(stringPath);
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("NotepadScene.fxml"));
        stage.setTitle("Java Notepad");
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image(new File("image\\kate_logo.png").toURI().toString()));
        stage.show();
    }
}
