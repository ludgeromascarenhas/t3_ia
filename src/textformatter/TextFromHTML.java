/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textformatter;

/**
 *
 * @author Eduardo
 */
public class TextFromHTML {
    int id;
    StringBuilder texto;

    public TextFromHTML(int id, StringBuilder texto) {
        this.id = id;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StringBuilder getTexto() {
        return texto;
    }

    public void setTexto(StringBuilder texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "TextFromHTML{" + "id=" + id + ", texto=" + texto + '}';
    }    
}
