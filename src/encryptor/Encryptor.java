package encryptor;


import javafx.fxml.Initializable;

import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class Encryptor implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public static String encrypt(String inputText, int key){
        String s = "";
        int len = inputText.length();
        for(int x = 0; x < len; x++){
            char c = (char)(inputText.charAt(x) + key);
            if (c > 'z')
                s += (char)(inputText.charAt(x) - (26-key));
            else
                s += (char)(inputText.charAt(x) + key);
        }
        return s;
    }
}
