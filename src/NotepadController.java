import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JFileChooser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NotepadController {

    @FXML
    private MenuItem aboutItem;

    @FXML
    private MenuItem colorItem;

    @FXML
    private Menu editMenu;

    @FXML
    private Menu fileMenu;

    @FXML
    private MenuItem fontItem;

    @FXML
    private MenuItem fontSizeItem;

    @FXML
    private Menu helpMenu;

    @FXML
    private MenuItem newFileItem;

    @FXML
    private MenuItem openFileItem;

    @FXML
    private AnchorPane panel;

    @FXML
    private MenuItem saveFileItem;

    @FXML
    private TextArea textArea;

    private File file;
    private byte[] characterByte;
    private String textContent;
    private Stage stage;

    @FXML
    void createNewFile(ActionEvent event) throws Exception {
        Stage newFileStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("NotepadScene.fxml"));
        Scene scene = new Scene(root);
        newFileStage.setTitle("Java Notepad");
        newFileStage.setScene(scene);
        newFileStage.getIcons().add(new Image(new File("image\\kate_logo.png").toURI().toString()));
        newFileStage.show();
    }

    @FXML
    void openAFile(ActionEvent event) throws IOException {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.showOpenDialog(null);
        file = jFileChooser.getSelectedFile();
        InputStream in = null;
        if (file != null) {
            try {
                in = new FileInputStream(file);
                byte[] characterByte = in.readAllBytes();
                textContent = "";
                for (byte i : characterByte) {
                    textContent = textContent + (char) i;
                }
                textArea.setText(textContent);
                this.stage = (Stage) panel.getScene().getWindow();
                this.stage.setTitle(file.getName());;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                in.close();
            }
        }
    }

    @FXML
    void saveFile(ActionEvent event) throws IOException {
        OutputStream out = null;
        try {
            if (file != null) {
                out = new FileOutputStream(file);
                characterByte = textArea.getText().getBytes();
                out.write(characterByte);
            } else {
                JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
                fileChooser.showOpenDialog(null);
                out = new FileOutputStream(fileChooser.getSelectedFile().getName());
                characterByte = textArea.getText().getBytes();
                out.write(characterByte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    @FXML
    void font(ActionEvent event) {

    }

    @FXML
    void fontSize(ActionEvent event) {

    }

    @FXML
    void about(ActionEvent event) {

    }

    @FXML
    void color(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert editMenu != null : "fx:id=\"editMenu\" was not injected: check your FXML file 'NotepadScene.fxml'.";
        assert fileMenu != null : "fx:id=\"fileMenu\" was not injected: check your FXML file 'NotepadScene.fxml'.";
        assert helpMenu != null : "fx:id=\"helpMenu\" was not injected: check your FXML file 'NotepadScene.fxml'.";
        assert newFileItem != null : "fx:id=\"newFileItem\" was not injected: check your FXML file 'NotepadScene.fxml'.";
        assert openFileItem != null : "fx:id=\"openFileItem\" was not injected: check your FXML file 'NotepadScene.fxml'.";
        assert panel != null : "fx:id=\"panel\" was not injected: check your FXML file 'NotepadScene.fxml'.";
        assert saveFileItem != null : "fx:id=\"saveFileItem\" was not injected: check your FXML file 'NotepadScene.fxml'.";
        assert textArea != null : "fx:id=\"textArea\" was not injected: check your FXML file 'NotepadScene.fxml'.";
    }

}
