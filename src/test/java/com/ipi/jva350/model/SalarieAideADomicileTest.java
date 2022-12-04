package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.LinkedHashSet;

class SalarieAideADomicileTest {

    @Test
    void testALegalementDroitADesCongesPayesDefault() {
        // Given
        SalarieAideADomicile aide = new SalarieAideADomicile();
        // When
        boolean res = aide.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertFalse(res);
    }

    @Test
    void testALegalementDroitADesCongesPayes9() {
        // Given
        SalarieAideADomicile aide = new SalarieAideADomicile();
        aide.setJoursTravaillesAnneeNMoins1(9);
        // When
        boolean res = aide.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertFalse(res);
    }

    @Test
    void testALegalementDroitADesCongesPayes10() {
        // Given
        SalarieAideADomicile aide = new SalarieAideADomicile();
        aide.setJoursTravaillesAnneeNMoins1(10);
        // When
        boolean res = aide.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertTrue(res);
    }

    @Test
    void testALegalementDroitADesCongesPayesBigNumber() {
        // Given
        SalarieAideADomicile aide = new SalarieAideADomicile();
        aide.setJoursTravaillesAnneeNMoins1(100);
        // When
        boolean res = aide.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertTrue(res);
    }

    @ParameterizedTest
    @CsvSource({
            "'2022-11-30', '2022-11-30', 1"
    })
    void testCalculeJoursDeCongeDecomptesPourPlage(String dateDebut, String dateFin, int tailleAttendue) {
        // Given
        SalarieAideADomicile salarieAideADomicile = new SalarieAideADomicile();
        // When
        LinkedHashSet<LocalDate> joursDeCongesDecomptes = salarieAideADomicile.calculeJoursDeCongeDecomptesPourPlage(LocalDate.parse(dateDebut), LocalDate.parse(dateFin));
        // Then
        Assertions.assertEquals(joursDeCongesDecomptes.size(), tailleAttendue);
    }
}