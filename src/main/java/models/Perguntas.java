package models;

import java.util.HashMap;

public class Perguntas {

   private HashMap<Integer,String> indicePerguntas = new HashMap();

    public Perguntas(HashMap<Integer, String> indicePerguntas) {
        this.indicePerguntas = indicePerguntas;
    }
}
