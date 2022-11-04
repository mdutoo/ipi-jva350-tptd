package com.ipi.jva350.model;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SalarieAideADomicileTest {

	@Test
	void testALegalementDroitADesCongesPayesNonInitialise() {
		// Given
		SalarieAideADomicile aide = new SalarieAideADomicile();
		// When
		boolean resultat = aide.aLegalementDroitADesCongesPayes();
		// Then
		Assertions.assertEquals(false,resultat);
	}
	
	@Test
	void testALegalementDroitADesCongesPayesNouveauSalarie() {
		// Given
		SalarieAideADomicile aide = new SalarieAideADomicile("Rachelle", LocalDate.now(),LocalDate.now(),0,0,0,0,0);
		// When
		boolean resultat = aide.aLegalementDroitADesCongesPayes();
		// Then
		Assertions.assertEquals(false,resultat);
	}
	
	@Test
	void testALegalementDroitADesCongesPayesAncienSalarie() {
		// Given
		SalarieAideADomicile aide = new SalarieAideADomicile("Karen", LocalDate.of(2020, 1, 5),LocalDate.now(),180,0,210,20,20);
		// When
		boolean resultat = aide.aLegalementDroitADesCongesPayes();
		// Then
		Assertions.assertEquals(true,resultat);
	}
	
	@Test
	void testALegalementDroitADesCongesPayesCasAuxLimites() {
		// Given
		SalarieAideADomicile aide = new SalarieAideADomicile("Numéro 1976562821", LocalDate.of(2020, 1, 5),LocalDate.now(),180,0,9,0,0);
		// When
		boolean resultat = aide.aLegalementDroitADesCongesPayes();
		aide.setJoursTravaillesAnneeNMoins1(10);
		// Then
		Assertions.assertEquals(false,resultat);
		Assertions.assertEquals(true,aide.aLegalementDroitADesCongesPayes());
	}


}
