package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

class EntrepriseTest {

    @Test
    void testEstDansPlageTrue() {
        // Given, When
        boolean res = Entreprise.estDansPlage(LocalDate.parse("2022-12-04"), LocalDate.parse("2022-12-01"), LocalDate.parse("2022-12-31"));
        // Then
        Assertions.assertTrue(res);
    }

    @Test
    void testEstDansPlageFalse() {
        // Given, When
        boolean res = Entreprise.estDansPlage(LocalDate.parse("2022-11-04"), LocalDate.parse("2022-12-01"), LocalDate.parse("2022-12-31"));
        // Then
        Assertions.assertFalse(res);
    }

    @Test
    void testEstDansPlageWrong() {
        // Given, When
        boolean res = Entreprise.estDansPlage(LocalDate.parse("2022-08-04"), LocalDate.parse("2022-12-31"), LocalDate.parse("2022-11-01"));
        // Then
        Assertions.assertFalse(res);
    }

    @ParameterizedTest
    @CsvSource({
            "'2012-04-09'",
            "'2022-01-01'",
            "'2022-05-01'",
            "'2022-07-14'",
            "'2022-08-15'",
            "'2022-11-01'",
            "'2022-11-11'",
            "'2022-12-25'"
    })
    void testEstJourFerieRegular(String date) {
        // Given, When
        boolean res = Entreprise.estJourFerie(LocalDate.parse(date));
        // Then
        Assertions.assertTrue(res);
    }
}