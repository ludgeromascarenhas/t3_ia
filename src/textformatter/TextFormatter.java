/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textformatter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author 14104887
 */
public class TextFormatter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String input = "corpus/input/trabalhador.txt";
        final String output = "corpus/output/trabalhadorOutput.txt";
        String line;
        StringBuilder texto;
        List<StringBuilder> textos = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input), "Cp1252"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(output, true));
            
            line = reader.readLine();

            while (line != null) {
                if (line.startsWith("TEXTO")) {
                    writer.write(line);
                    line = reader.readLine();
                    texto = new StringBuilder();

                    while (!line.equals("</body>")) {
                        texto.append(" ");
                        texto.append(line);
                        line = reader.readLine();
                    }
                    texto.append(" ");
                    texto.append(line);
                    
                    writer.append("\n");
                    Document doc = Jsoup.parse(texto.toString());
                    writer.append(doc.body().text());
                    writer.append("\n\n");
                    textos.add(texto);
                }

                line = reader.readLine();
            }

            reader.close();
            writer.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + input + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + input + "'");
        }
    }
}
