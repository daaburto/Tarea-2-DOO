package org.example;
/**Clase que representa una nota hecha en una reunión.*/
public class Notas{
    /**Contenido de la nota*/
    private String contenido;

    /**
     * Constructor de la clase Notas.
     * @param nota El contenido de la nota.
     */
    public Notas(String nota){
        this.contenido = nota;
    }

    /**@return contenido de la nota*/
    public String getContenido() {
        return contenido;
    }
}
