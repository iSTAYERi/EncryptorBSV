package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    public Button btnBrowseInput;
    public Button btnEncryptFile;
    public Button btnEncryptText;
    public TextField txtFieldInput;
    public PasswordField passFieldKey;
    public TextArea txtAreaInput;
    public TextArea txtAreaOutput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void onActionBtnBrowseInput(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File inputFile = fileChooser.showOpenDialog(new Stage());
        txtFieldInput.setText(inputFile.getPath());
    }

    public void onActionBtnEncryptFile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        File outputFile = fileChooser.showSaveDialog(new Stage());
        if (outputFile != null){
            try {
                outputFile.createNewFile();
                Files.write();      //сделать запись текста в файл
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onActionBtnEncryptText(){

    }

    public void onActionPassFieldKey(){

    }

}
