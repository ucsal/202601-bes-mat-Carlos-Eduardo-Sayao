package br.com.ucsal.olimpiadas;
import java.util.Scanner;
public class QuestaoServices {

    private long proximoId = 1;

    public boolean validar(String enunciado, String[] alternativas, Character correta) {
        return enunciado != null && !enunciado.isBlank()
                && alternativas != null && alternativas.length == 5
                && correta != null;
    }

    public Questao criarQuestao(Long provaId, String enunciado, String[] alternativas, char correta) {
        Questao q = new Questao();
        q.setId(proximoId++);
        q.setProvaId(provaId);
        q.setEnunciado(enunciado);
        q.setAlternativas(alternativas);
        q.setAlternativaCorreta(correta);
        return q;
    }
}
