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
//import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import org.cogroo.analyzer.Analyzer;
import org.cogroo.analyzer.ComponentFactory;
import org.cogroo.text.Sentence;
import org.cogroo.text.impl.DocumentImpl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class TextFormatter {
    
    public static void main(String[] args) {
        final String input = "corpus/input/trabalhador.txt";
        //final String output = "corpus/output/trabalhadorOutput.txt";
        String line;
        StringBuilder texto;

        ComponentFactory factory = ComponentFactory.create(new Locale("pt", "BR"));
        Analyzer cogroo = factory.createPipe();
        
        DocumentImpl document = new DocumentImpl();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input), "Cp1252"));
            //BufferedWriter writer = new BufferedWriter(new FileWriter(output, true));

            line = reader.readLine();

            while (line != null) {
                if (line.startsWith("TEXTO")) {
                    //writer.write(line);
                    line = reader.readLine();
                    texto = new StringBuilder();

                    while (!line.equals("</body>")) {
                        texto.append(" ");
                        texto.append(line);
                        line = reader.readLine();
                    }
                    texto.append(" ");
                    texto.append(line);

                    Document doc = Jsoup.parse(texto.toString());
                    //writer.append("\n");
                    //writer.append(doc.body().text());
                    //writer.append("\n\n");

                    document.setText(texto.toString());

                    for (Sentence sentence : document.getSentences()) { // lista de sentenças
                        System.out.println("S: " + sentence.getStart() + " E: " + sentence.getEnd()); // caracteres onde a sentença começa e termina
                        System.out.println(sentence.getText()); // texto da sentença
                    }
                }

                line = reader.readLine();
            }

            reader.close();
            //writer.close();

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
