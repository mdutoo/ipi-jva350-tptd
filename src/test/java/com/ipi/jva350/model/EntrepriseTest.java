package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class EntrepriseTest {

    @Test
    void estDansPlageTrue() {
        // Given, When
        boolean res = Entreprise.estDansPlage(LocalDate.parse("2022-12-04"), LocalDate.parse("2022-12-01"), LocalDate.parse("2022-12-31"));
        // Then
        Assertions.assertTrue(res);
    }

    @Test
    void estDansPlageFalse() {
        // Given, When
        boolean res = Entreprise.estDansPlage(LocalDate.parse("2022-11-04"), LocalDate.parse("2022-12-01"), LocalDate.parse("2022-12-31"));
        // Then
        Assertions.assertFalse(res);
    }

    @Test
    void estDansPlageWrong() {
        // Given, When
        boolean res = Entreprise.estDansPlage(LocalDate.parse("2022-08-04"), LocalDate.parse("2022-12-31"), LocalDate.parse("2022-11-01"));
        // Then
        Assertions.assertFalse(res);
    }
}