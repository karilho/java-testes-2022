package menuFunction;

import service.ReadQuestion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class createCandidate {

public static HashMap<Integer,String>  generateCandidate() {
    Scanner scanner = new Scanner(System.in);
    HashMap<Integer, String> listaDePerguntas = new HashMap(ReadQuestion.readQuestion());
    HashMap<Integer,String> listaDeRespostas = new HashMap<>();

    //Faz as perguntas e armazena as respostas
    listaDePerguntas.forEach((questionNumber, questionText) -> {
        System.out.println("Pergunta " + questionNumber + ": " + questionText);
        String resposta = scanner.nextLine();
        listaDeRespostas.put(questionNumber,resposta);
    });

    System.out.println("Respostas: " + listaDeRespostas);
    String filename =  listaDeRespostas.get(1) + ".txt";

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
        for (HashMap.Entry<Integer, String> entry : listaDeRespostas.entrySet()) {
            String questionNumber = String.valueOf(entry.getKey());
            String answer = entry.getValue();

            // Gravar a resposta em uma nova linha no arquivo
            writer.write(questionNumber + " - " + answer);
            writer.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return listaDeRespostas;
}
}
