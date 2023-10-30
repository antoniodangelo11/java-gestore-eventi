package org.lessons.java.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;

public class Concerto extends Evento {
    private LocalTime ora;
    private BigDecimal prezzo;

    public Concerto(String titolo, LocalDate data, int numeroPostiTotali, LocalTime ora, BigDecimal prezzo) {
        super(titolo, data, numeroPostiTotali);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public String getDataOraFormattata() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
        return getData().format(formatter) + " - " + ora.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public String getPrezzoFormattato() {
        DecimalFormat df = new DecimalFormat("##,##€");
        return df.format(prezzo);
    }

    @Override
    public String toString() {
        return getDataOraFormattata() + " - " + getTitolo() + " - " + getPrezzoFormattato();
    }
}

