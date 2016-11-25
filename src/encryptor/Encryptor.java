package encryptor;


import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Encryptor implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    // разделеие текста на слова, разделенные по пробелам и переходам на новую строку.
    // Отправка отдельных слов на шифрование.
    public static String encrypt(String inputText, int key){
        String outputText = "";
        String[] lines = inputText.split("\\n");
        for (String l: lines){
            String[] words = l.split("\\s");
            for (String w: words){
                outputText += encryptCaesar(w, key) + " ";
            }
            outputText += "\n";
        }

        return outputText;
    }

    private static String encryptCaesar(String inputWord, int key){
        String s = "";
        int len = inputWord.length();
        for(int x = 0; x < len; x++){
//            char c = (char)(inputWord.charAt(x) + key);
//            if ((int)c > 256)
//                s += (char)(inputWord.charAt(x) - (256-key));
//            else
                s += (char)(inputWord.charAt(x) + key);
        }
        return s;
    }

    public static String decrypt(String inputText, int key){
        String outputText = "";
        String[] lines = inputText.split("\\n");
        for (String l: lines){
            String[] words = l.split("\\s");
            for (String w: words){
                outputText += decryptCaesar(w, key) + " ";
            }
            outputText += "\n";
        }

        return outputText;
    }

    private static String decryptCaesar(String inputWord, int key){
        String s = "";
        int len = inputWord.length();
        for(int x = 0; x < len; x++){
            s += (char)(inputWord.charAt(x) - key);
        }
        return s;
    }

    public static int getASCII(String text){
        char[] ctext = text.toCharArray();
        int asciiInt = 0;
        for (char n: ctext){
            asciiInt += (int)n;
        }
        return asciiInt;
    }
}

