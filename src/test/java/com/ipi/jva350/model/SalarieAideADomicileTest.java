package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}