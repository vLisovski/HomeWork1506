
import java.io.*;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("input.TXT");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String alphabet = "abcdefghijklmopqrstuvwxyz,!?0123456789 _()";

        int key = Integer.parseInt(bufferedReader.readLine());

        String originalString = bufferedReader.readLine();

        fileReader.close();
        bufferedReader.close();

        String encryptedString = "";
        for (int i = 0; i < originalString.length(); i++) {
            char currentSymbol = originalString.charAt(i);
            int foundIndex = alphabet.indexOf(currentSymbol);

            if (foundIndex != -1) {
                int newIndex = (foundIndex + key) % alphabet.length();
                encryptedString += alphabet.charAt(newIndex);
            } else {
                encryptedString += currentSymbol;
            }
        }

        FileWriter fileWriter = new FileWriter("output.TXT");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write("зашифрованный текст = " + encryptedString);

        String decryptedString = "";
        for (int i = 0; i < encryptedString.length(); i++) {
            char currentSymbol = encryptedString.charAt(i);
            int foundIndex = alphabet.indexOf(currentSymbol);

            if (foundIndex != -1) {

                int newIndex = (foundIndex - key % alphabet.length() + alphabet.length()) % alphabet.length();

                /*int newIndex = foundIndex - key % alphabet.length();
                if (newIndex < 0) {
                    newIndex = alphabet.length() - newIndex;
                }*/
                decryptedString += alphabet.charAt(newIndex);
            } else {
                decryptedString += currentSymbol;
            }
        }

        bufferedWriter.newLine();
        bufferedWriter.write("расшифрованный текст = " + decryptedString);

        bufferedWriter.close();
        fileWriter.close();
    }
}
