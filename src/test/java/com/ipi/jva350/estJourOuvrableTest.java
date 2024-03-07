package com.ipi.jva350;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.ipi.jva350.model.SalarieAideADomicile;

public class estJourOuvrableTest {

    @Test
    public void estJourOuvrable1() {
        // Given
        SalarieAideADomicile salarie = new SalarieAideADomicile();

        // When
        boolean res = salarie.estJourOuvrable(LocalDate.of(2024, 2, 19));

        // Then
        assertTrue(res);
    }

    @Test
    public void estJourOuvrable2() {
        // Given
        SalarieAideADomicile salarie = new SalarieAideADomicile();

        // When
        boolean res = salarie.estJourOuvrable(LocalDate.of(2024, 2, 20));

        // Then
        assertTrue(res);
    }

    @Test
    public void estJourOuvrable3() {
        // Given
        SalarieAideADomicile salarie = new SalarieAideADomicile();

        // When
        boolean res = salarie.estJourOuvrable(LocalDate.of(2024, 2, 21));

        // Then
        assertTrue(res);
    }

    @Test
    public void estJourOuvrable4() {
        // Given
        SalarieAideADomicile salarie = new SalarieAideADomicile();

        // When
        boolean res = salarie.estJourOuvrable(LocalDate.of(2024, 2, 22));

        // Then
        assertTrue(res);
    }

    @Test
    public void estJourOuvrable5() {
        // Given
        SalarieAideADomicile salarie = new SalarieAideADomicile();

        // When
        boolean res = salarie.estJourOuvrable(LocalDate.of(2024, 2, 23));

        // Then
        assertTrue(res);
    }

    @Test
    public void estJourOuvrable6() {
        // Given
        SalarieAideADomicile salarie = new SalarieAideADomicile();

        // When
        boolean res = salarie.estJourOuvrable(LocalDate.of(2024, 2, 24));

        // Then
        assertTrue(res);
    }

    @Test
    public void estJourOuvrable7() {
        // Given
        SalarieAideADomicile salarie = new SalarieAideADomicile();

        // When
        boolean res = salarie.estJourOuvrable(LocalDate.of(2024, 2, 25));

        // Then
        assertFalse(res);
    }
}
