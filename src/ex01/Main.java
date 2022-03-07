package ex01;

import java.util.*;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);

        List<Candidato> candidatos = new ArrayList<>();
        preencherCandidatos(candidatos);

        int voto;
        Map<Integer, Integer> votos = new HashMap<>();

        do {
            listarCandidatos(candidatos);

            System.out.print("\nDigite seu voto: ");
            voto = scanner.nextInt();
            if (voto != 0) {
                contabilizarVoto(votos, voto);
            }
        } while (voto != 0);

        resultadoVotacao(votos,candidatos);
    }

    private void listarCandidatos(List<Candidato> candidatos) {
        System.out.println("\nCandidatos:");
        for (Candidato candidato : candidatos) {
            System.out.println(candidato);
        }
    }

    private void preencherCandidatos(List<Candidato> candidatos) {
        Candidato candidato1 = new Candidato();
        candidato1.setId(1);
        candidato1.setNome("João");
        candidatos.add(candidato1);

        Candidato candidato2 = new Candidato();
        candidato2.setId(2);
        candidato2.setNome("Maria");
        candidatos.add(candidato2);

        Candidato candidato3 = new Candidato();
        candidato3.setId(3);
        candidato3.setNome("José");
        candidatos.add(candidato3);

        Candidato candidato4 = new Candidato();
        candidato4.setId(4);
        candidato4.setNome("Antônio");
        candidatos.add(candidato4);

        Candidato candidato5 = new Candidato();
        candidato5.setId(5);
        candidato5.setNome("Tiburssinho");
        candidatos.add(candidato5);

    }

    private void contabilizarVoto(Map<Integer, Integer> votos, int idCandidato) {
        if (votos.containsKey(idCandidato)) {
            votos.put(idCandidato, votos.get(idCandidato) + 1);
        } else {
            votos.put(idCandidato, 1);
        }
        System.out.println("Obrigado, seu voto foi registrado!");
    }

    private void resultadoVotacao(Map<Integer, Integer> votos, List<Candidato> candidatos) {
        System.out.println("\nResultado da votação:");

        List<Entry<Integer, Integer>> list = new ArrayList<>(votos.entrySet());
        list.sort(Entry.comparingByValue());
        //list.forEach(System.out::println);

        System.out.println("\nO candidato eleito é o: " +
                candidatos.get(list.get(list.size()-1).getKey()-1).getNome());

        /*
        System.out.println(candidatos);
        System.out.println(list);
        */

        int i = 0;

        for (i = list.size() -1; i >= 0; i--) {
            int idCandidato = list.get(i).getKey();
            String nomeCandidato = candidatos.get(idCandidato - 1).getNome();

            System.out.println("Lugar "+ (list.size() - i) + ": " +"Candidato " + nomeCandidato +
                    " - " + list.get(i).getValue() + " voto(s)");
        }
    }
}
