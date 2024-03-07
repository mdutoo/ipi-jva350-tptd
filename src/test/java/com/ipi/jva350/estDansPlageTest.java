package com.ipi.jva350;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.ipi.jva350.model.Entreprise;

public class estDansPlageTest {
	@Test
	public void estDansPlage() {
		// Given
		Entreprise entreprise = new Entreprise();
		//When
		boolean res = entreprise.estDansPlage(LocalDate.of(2024, 3, 2), LocalDate.of(2024, 1, 1), LocalDate.of(2025, 1, 1));
		// Then
		assertEquals(true,res);
	}
	@Test
	public void estDansPlage2() {
		// Given
		Entreprise entreprise = new Entreprise();
		//When
		boolean res = entreprise.estDansPlage(LocalDate.of(2024, 12, 14), LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 1));
		// Then
		assertFalse(res);
	}
}
