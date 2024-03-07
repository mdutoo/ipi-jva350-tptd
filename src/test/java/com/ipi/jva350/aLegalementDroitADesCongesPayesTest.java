package com.ipi.jva350;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.ipi.jva350.model.SalarieAideADomicile;
public class aLegalementDroitADesCongesPayesTest {
	   @Test
	    public void aLegalementDroitADesCongesPayes1(){
	       // Given
	       double joursTravaillesAnneeNMoins1=1;
	       SalarieAideADomicile salarie=new SalarieAideADomicile();
	       salarie.setJoursTravaillesAnneeNMoins1(joursTravaillesAnneeNMoins1);
	       // When
	       boolean joursTravaillesAnneeNMoins1OK=salarie.aLegalementDroitADesCongesPayes();
	       // Then
	       assertFalse(joursTravaillesAnneeNMoins1OK);
	   }
	   @Test
	   public void aLegalementDroitADesCongesPayes90(){
	      // Given
	      double joursTravaillesAnneeNMoins1=90;
	      SalarieAideADomicile salarie=new SalarieAideADomicile();
	      salarie.setJoursTravaillesAnneeNMoins1(joursTravaillesAnneeNMoins1);
	      // When
	      boolean joursTravaillesAnneeNMoins1OK=salarie.aLegalementDroitADesCongesPayes();
	      // Then
	      assertTrue(joursTravaillesAnneeNMoins1OK);
	   }
}