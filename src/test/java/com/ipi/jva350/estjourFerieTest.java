package com.ipi.jva350;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.ipi.jva350.model.Entreprise;

public class estjourFerieTest {
	@Test
	public void estferier() {
		// Given
		Entreprise entreprise = new Entreprise();
		// When
		boolean res = entreprise.estJourFerie(LocalDate.of(2024, 7, 3));
        // Then
		assertEquals(res,false);
	}
	
	@Test
	public void estToussaint1() {
		// Given
		Entreprise entreprise = new Entreprise();
		// When
		boolean res = entreprise.estJourFerie(LocalDate.of(2024, 11, 1));
		// Then
		assertEquals(res,true);
	}
	
	@Test
	public void estToussaint2() {
		// Given
		Entreprise entreprise = new Entreprise();
		// When
		boolean res = entreprise.estJourFerie(LocalDate.of(2025, 11, 1));
		// Then
		assertEquals(res,true);
	}
	@Test
	public void estauteuranee() {
		// Given
		Entreprise entreprise = new Entreprise();
		// When
		boolean res = entreprise.estJourFerie(LocalDate.of(2025, 11, 2));
		// Then
		assertEquals(res,false);
	}
	@Test
	public void estbixetil() {
		// Given
		Entreprise entreprise = new Entreprise();
		// When
		boolean res = entreprise.estJourFerie(LocalDate.of(2024, 2, 29));
		// Then
		assertEquals(res,false);
	}
	@Test
	public void estpaque() {
		// Given
		Entreprise entreprise = new Entreprise();
		// When
		boolean res = entreprise.estJourFerie(LocalDate.of(2024, 3, 31).plusDays(1L));
		// Then
		assertEquals(res,true);
	}
}
