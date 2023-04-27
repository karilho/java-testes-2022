package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadQuestion {

    public static final String PATH = "C:\\Users\\Carrilho\\Documents\\estudos\\codar\\java-testes-2022\\src\\formulario.txt";
    public static Map<Integer,String> readQuestion() {

        HashMap<Integer,String> indicePerguntas = new HashMap();
        try {
            FileReader questionReader = new FileReader(PATH);
            BufferedReader questionBuffer = new BufferedReader(questionReader);

            String line;
            String regex = "^(P)(\\d+)\\|(.*?)$";
            Pattern pattern = Pattern.compile(regex);

            while ((line = questionBuffer.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    Integer questionNumber = Integer.valueOf(matcher.group(2));
                    String questionText = matcher.group(3);

                    indicePerguntas.put(questionNumber, questionText);
                }
            }

            questionBuffer.close();
            questionReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found" + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("Outro"+ e.getMessage());
        }
        return indicePerguntas;
    }
}
