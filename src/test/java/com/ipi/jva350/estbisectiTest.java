package com.ipi.jva350;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.ipi.jva350.model.Entreprise;

public class estbisectiTest {
	@Test
	void isbisectil() {
		Entreprise entreprise = new Entreprise();
		
		boolean res = entreprise.bissextile(2024);
		
		assertTrue(res);
	}
	@Test
	void isbisectil2() {
		Entreprise entreprise = new Entreprise();
		
		boolean res = entreprise.bissextile(2021);
		
		assertFalse(res);
	}
	@Test
	void isbisectil3() {
		Entreprise entreprise = new Entreprise();
		
		boolean res = entreprise.bissextile(2000);
		
		assertTrue(res);
	}
	@Test
	void isbisectil4() {
		Entreprise entreprise = new Entreprise();
		
		boolean res = entreprise.bissextile(2100);
		
		assertFalse(res);
	}
}
