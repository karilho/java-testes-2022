import menuFunction.createCandidate;
import service.ReadQuestion;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        
        //Todo -> Acertar os diretorios da onde são salvo os .txt
        //Fazer uma varredura em todo o código pra ler todos os usuários cadastrados
        //Decidir se vou ler nr + String ou só o String de resposta de acordo com regra
        HashMap<Integer, String> listaDePerguntas = new HashMap(ReadQuestion.readQuestion());

        System.out.println("teste");
        /*
                listaDePerguntas.forEach((questionNumber, questionText) -> {
            System.out.println("Pergunta " + questionNumber + ": " + questionText);
        });
         */

        createCandidate.generateCandidate();
    }
}
