package org.lessons.java.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Inizializzo lo Scanner
        Scanner input = new Scanner(System.in);

        Evento evento = null;

        while (true) {
            System.out.println("Scegli un'azione:");
            System.out.println("1. Creare un nuovo evento");
            System.out.println("2. Prenotare posti");
            System.out.println("3. Disdire posti");
            System.out.println("4. Uscire");
            System.out.print("Scegli: ");

            int scelta = Integer.parseInt(input.nextLine());

            switch (scelta) {
                case 1:
                    System.out.println("Inserisci i dettagli per creare un nuovo evento:");
                    System.out.print("Titolo: ");
                    String titolo = input.nextLine();

                    System.out.print("Data (AAAA-MM-GG): ");
                    LocalDate data = LocalDate.parse(input.nextLine());
                    System.out.print("Numero di posti totali: ");

                    int numeroPostiTotali = Integer.parseInt(input.nextLine());

                    evento = new Evento(titolo, data, numeroPostiTotali);
                    break;
                case 2:
                    if (evento == null) {
                        System.out.println("Nessun evento creato. Devi prima creare un evento.");
                    } else {
                        System.out.print("Quanti posti vuoi prenotare? ");
                        int postiDaPrenotare = Integer.parseInt(input.nextLine());
                        try {
                            evento.prenota(postiDaPrenotare);
                            System.out.println("Prenotazione effettuata con successo!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Errore: " + e.getMessage());
                        }
                    }
                    break;
                case 3:
                    if (evento == null) {
                        System.out.println("Nessun evento creato. Devi prima creare un evento.");
                    } else {
                        System.out.print("Quanti posti vuoi disdire? ");
                        int postiDaCancellare = Integer.parseInt(input.nextLine());
                        try {
                            evento.disdici(postiDaCancellare);
                            System.out.println("Posti cancellati con successo!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Errore: " + e.getMessage());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Uscita dal programma.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }

            // Stampo il numero di posti prenotati e disponibili dopo ogni singola azione
            if (evento != null) {
                System.out.println("Posti prenotati: " + evento.getNumeroPostiPrenotati());
                System.out.println("Posti disponibili: " +
                        (evento.getNumeroPostiTotali() - evento.getNumeroPostiPrenotati()));
            }
        }
    }
}
