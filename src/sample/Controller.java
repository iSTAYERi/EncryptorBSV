package sample;

import encryptor.Encryptor;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    public Button btnBrowseInput;
    public Button btnEncryptFile;
    public Button btnEncryptText;
    public TextField txtFieldInput;
    public PasswordField passFieldKey;
    public TextArea txtAreaInput;
    public TextArea txtAreaOutput;
    public Label labelStatus;

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
        int key;
        try {
            key = Integer.getInteger(passFieldKey.getText());
        } catch (Exception e) {
            labelStatus.setText("key must be an integer");
        }
        PrintWriter printWriter;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        File outputFile = fileChooser.showSaveDialog(new Stage());
        if (outputFile != null){
            try {
                printWriter = new PrintWriter(outputFile);
                printWriter.println("Hello");
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onActionBtnEncryptText(){
        int key = 0;
        try {
            key = Integer.parseInt(passFieldKey.getText());
        } catch (Exception e) {
            System.out.println(e);
            labelStatus.setText("key must be an integer");
        }
        String inputText = txtAreaInput.getText();
        System.out.println(inputText);
        String encryptedText = Encryptor.encrypt(inputText, key);
        txtAreaOutput.setText(encryptedText);
    }

    public void onActionPassFieldKey(){

    }

}
