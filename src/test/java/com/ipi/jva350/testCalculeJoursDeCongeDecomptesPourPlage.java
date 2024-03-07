package com.ipi.jva350;
import static org.junit.jupiter.api.Assertions.*;

import java.io.Console;
import java.time.LocalDate;
import java.util.LinkedHashSet;

import org.junit.jupiter.api.Test;

import com.ipi.jva350.model.SalarieAideADomicile;

public class testCalculeJoursDeCongeDecomptesPourPlage {

    @Test
    public void testCalculeJoursDeCongeDecomptesPourPlage() {
        // Given
        SalarieAideADomicile salarie = new SalarieAideADomicile();
        LocalDate dateDebut = LocalDate.of(2024, 2, 18);
        LocalDate dateFin = LocalDate.of(2024, 2, 20);

        // When
        LinkedHashSet<LocalDate> joursDeConge = salarie.calculeJoursDeCongeDecomptesPourPlage(dateDebut, dateFin);
        // Then
        assertFalse(joursDeConge.contains(LocalDate.of(2024, 2, 18)));
    }
    @Test
    public void testCalculeJoursDeCongeDecomptesPourPlage1() {
        // Given
        SalarieAideADomicile salarie = new SalarieAideADomicile();
        LocalDate dateDebut = LocalDate.of(2024, 2, 18);
        LocalDate dateFin = LocalDate.of(2024, 2, 20);

        // When
        LinkedHashSet<LocalDate> joursDeConge = salarie.calculeJoursDeCongeDecomptesPourPlage(dateDebut, dateFin);
        // Then
        assertTrue(joursDeConge.contains(LocalDate.of(2024, 2, 19)));
    }
    @Test
    public void testCalculeJoursDeCongeDecomptesPourPlage2() {
        // Given
        SalarieAideADomicile salarie = new SalarieAideADomicile();
        LocalDate dateDebut = LocalDate.of(2024, 2, 18);
        LocalDate dateFin = LocalDate.of(2024, 2, 20);
        // When
        LinkedHashSet<LocalDate> joursDeConge = salarie.calculeJoursDeCongeDecomptesPourPlage(dateDebut, dateFin);
        // Then
        assertTrue(joursDeConge.contains(LocalDate.of(2024, 2, 20)));
    }
}
