/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textformatter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 14104887
 */
public class TextFormatter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String fileName = "esportes.txt";
        String line = "";
        StringBuilder texto = new StringBuilder();
        StringBuilder[] textos;

        int inicia, continua = 0;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "Cp1252"));
            line = bufferedReader.readLine();

            while (line != null) {
                if (line.startsWith("TEXTO")) {
                    int numTexto = Integer.parseInt(line.split(" ")[1]);
                    System.out.println(">> " + numTexto);

                } else {

                    texto.append(line);
                }

                line = bufferedReader.readLine();
            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");
        }
    }

}
