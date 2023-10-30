package org.lessons.java.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

    // Attributi
    private String titolo;
    private LocalDate data;
    private final int numeroPostiTotali;
    private int numeroPostiPrenotati;

    // Costruttori
    public Evento(String titolo, LocalDate data, int numeroPostiTotali) {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere nel passato.");
        }

        if (numeroPostiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo.");
        }

        this.titolo = titolo;
        this.data = data;
        this.numeroPostiTotali = numeroPostiTotali;
        this.numeroPostiPrenotati = 0;
    }

    // Metodi
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere al passato.");
        }
        this.data = data;
    }

    public int getNumeroPostiTotali() {
        return numeroPostiTotali;
    }

    public int getNumeroPostiPrenotati() {
        return numeroPostiPrenotati;
    }

    public void prenota(int postiDaPrenotare) {
        if (data.isBefore(LocalDate.now()) || postiDaPrenotare <= 0 || postiDaPrenotare >
                (numeroPostiTotali - numeroPostiPrenotati)) {
            throw new IllegalArgumentException("Non puoi prenotare questi posti.");
        }
        numeroPostiPrenotati += postiDaPrenotare;
    }

    public void disdici(int postiDaCancellare) {
        if (data.isBefore(LocalDate.now()) || postiDaCancellare <= 0 || postiDaCancellare > numeroPostiPrenotati) {
            throw new IllegalArgumentException("Non puoi cancellare questa prenotazione.");
        }
        numeroPostiPrenotati -= postiDaCancellare;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter) + " - " + titolo;
    }
}
