package com.ipi.jva350.model;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.util.LinkedHashSet;

import org.junit.jupiter.api.Test;

public class SalaireAideADomicileTest {

	//LEGALEMENT DROIT CONGES PAYES
	@Test
    public final void testaLegalementDroitADesCongesPayesVide() {
		//Given
    	SalarieAideADomicile aide = new SalarieAideADomicile();
    	//When
    	boolean res = aide.aLegalementDroitADesCongesPayes();
    	//Then
    	assertFalse(res);
    }
	

	@Test
    public final void testaLegalementDroitADesCongesPayesjoursTravaillesAnneeZero() {
		//Given
    	SalarieAideADomicile aide = new SalarieAideADomicile("Jeanne", LocalDate.of(2021, 7, 1), LocalDate.now(), 0,0,0, 0, 0);
    	//When
    	boolean res = aide.aLegalementDroitADesCongesPayes();
    	//Then
    	assertFalse(res);
    }
	
	@Test
    public final void testaLegalementDroitADesCongesPayesjoursTravaillesAnneeMoinsDeNeuf() {
    	SalarieAideADomicile aide = new SalarieAideADomicile("Jeanne", LocalDate.of(2021, 7, 1), LocalDate.now(), 0,0,5, 1, 0);
    	boolean res = aide.aLegalementDroitADesCongesPayes();
    	assertFalse(res);
    }
	
	@Test
    public final void testaLegalementDroitADesCongesPayesjoursTravaillesAnneeLimite() {
    	SalarieAideADomicile aide = new SalarieAideADomicile("Jeanne", LocalDate.of(2021, 7, 1), LocalDate.now(), 0,0,9, 0, 0);
    	boolean res = aide.aLegalementDroitADesCongesPayes();
    	assertFalse(res);
    }
	
	@Test
    public final void testaLegalementDroitADesCongesPayesjoursTravaillesAnneeVirgule() {
    	SalarieAideADomicile aide = new SalarieAideADomicile("Jeanne", LocalDate.of(2021, 7, 1), LocalDate.now(), 0,0,9.5, 0, 0);
    	boolean res = aide.aLegalementDroitADesCongesPayes();
    	assertFalse(res);
    }
	
	@Test
    public final void testaLegalementDroitADesCongesPayesjoursTravaillesAnneePlusDeNeuf() {
    	SalarieAideADomicile aide = new SalarieAideADomicile("Jeanne", LocalDate.of(2021, 7, 1), LocalDate.now(), 0,0,10, 0, 0);
    	boolean res = aide.aLegalementDroitADesCongesPayes();
    	assertTrue(res);
    }
	
	
	
	//CALCUL JOURS
	@Test
	public final void calculeJoursDeCongeDecomptesPourPlageEmptyHashSet() {
		SalarieAideADomicile aide = new SalarieAideADomicile("Jeanne", LocalDate.of(2021, 7, 1), LocalDate.now(), 0,0,0, 0, 0);
	 	LinkedHashSet<LocalDate> res = aide.calculeJoursDeCongeDecomptesPourPlage(LocalDate.now(), LocalDate.now().minusDays(1));
    	assertEquals(res, new LinkedHashSet<>());
	}
	
	@Test
	public final void calculeJoursDeCongeDecomptesPourPlageNotEmptyHashSet() {
		SalarieAideADomicile aide = new SalarieAideADomicile("Jeanne", LocalDate.of(2021, 7, 1), LocalDate.now(), 0,0,0, 0, 0);
	 	LinkedHashSet<LocalDate> res = aide.calculeJoursDeCongeDecomptesPourPlage(LocalDate.now(), LocalDate.now().minusDays(1));
    	assertNotEquals(res, res.isEmpty());
	}
	
	@Test
	public final void calculeJoursDeCongeDecomptesPourPlagHashSetFilled() {
		SalarieAideADomicile aide = new SalarieAideADomicile("Jeanne", LocalDate.of(2021, 7, 1), LocalDate.now(), 0,0,0, 0, 0);
	 	LinkedHashSet<LocalDate> res = aide.calculeJoursDeCongeDecomptesPourPlage(LocalDate.now(), LocalDate.now().plusDays(20));
	 	assertEquals(res.size() > 1, true);
	}
 
}
