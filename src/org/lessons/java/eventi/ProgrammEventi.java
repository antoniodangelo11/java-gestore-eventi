package org.lessons.java.eventi;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class ProgrammEventi {
    private final List<Evento> eventi;

    public ProgrammEventi(String titolo) {
        this.eventi = new ArrayList<>();
    }

    public void aggiungiEvento(Evento evento) {
        eventi.add(evento);
    }

    public List<Evento> eventiInData(LocalDate data) {
        List<Evento> eventiInData = new ArrayList<>();
        for (Evento evento : eventi) {
            if (evento.getData().equals(data)) {
                eventiInData.add(evento);
            }
        }
        return eventiInData;
    }

    public int numeroEventi() {
        return eventi.size();
    }

    public void svuotaEventi() {
        eventi.clear();
    }

    public String elencoEventiPerData() {
        StringBuilder sb = new StringBuilder();
        List<Evento> eventiOrdinati = new ArrayList<>(eventi);
        eventiOrdinati.sort((evento1, evento2) -> evento1.getData().compareTo(evento2.getData()));

        for (Evento evento : eventiOrdinati) {
            sb.append(evento.getData().toString()).append(" - ").append(evento.getTitolo()).append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ProgrammEventi programma = new ProgrammEventi("Programma Eventi");

        programma.aggiungiEvento(new Evento("Concerto 1",
                LocalDate.of(2023, 10, 30), 100));
        programma.aggiungiEvento(new Evento("Concerto 2",
                LocalDate.of(2024, 11, 15), 50));
        programma.aggiungiEvento(new Evento("Concerto 3",
                LocalDate.of(2025, 11, 15), 80));

        System.out.println("Elenco eventi per data:");
        System.out.println(programma.elencoEventiPerData());

        System.out.println("Eventi il 30 ottobre 2023:");
        List<Evento> eventiInData = programma.eventiInData(LocalDate.of(2023, 10, 30));
        for (Evento evento : eventiInData) {
            System.out.println(evento.getTitolo());
        }

        System.out.println("Numero di eventi nel programma: " + programma.numeroEventi());

        programma.svuotaEventi();
        System.out.println("Numero di eventi nel programma dopo la cancellazione: " + programma.numeroEventi());
    }
}