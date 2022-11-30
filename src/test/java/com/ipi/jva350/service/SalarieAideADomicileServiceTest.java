package com.ipi.jva350.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ipi.jva350.exception.SalarieException;
import com.ipi.jva350.model.SalarieAideADomicile;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SalarieAideADomicileServiceTest {

	@Autowired
	private SalarieAideADomicileService salarieAideADomicileService;
	
	@Test
	void testClotureMois() throws SalarieException {
		SalarieAideADomicile aide = new SalarieAideADomicile("Numéro 1976562821", LocalDate.of(2021, 7, 1),LocalDate.now(),30,0,9,1,0);
		
		salarieAideADomicileService.clotureMois(aide, 20);
		Assertions.assertEquals(50, aide.getJoursTravaillesAnneeN());
	}
	
	@Test
	void testCalculeLimiteEntrepriseCongesPermis() throws SalarieException{
		
		SalarieAideADomicile aide = new SalarieAideADomicile("Sujet de test n°2", LocalDate.of(2021,1,1),LocalDate.of(2022,01,12),190,27.5,220,30,20);
		salarieAideADomicileService.creerSalarieAideADomicile(aide);
		
		// Contexte : vacances de Noël 2022
		// Congés pris diffères de plus de 20% avec congés acquis
		// Droit à (30 - 20)*0.2 = 2 jours de congés supplémentaires année N + 2 car 2 années d'ancienneté
		// Expected : Congés gagnés à partir du 2022/06/01 jusqu'au 1er jour de congé : 7 * 2.5 = 17.5
		// 17.5 + 2 jours de congés supplémentaires année N = 19.5
		// 19.5 + 2 années d'ancienneté (+1 jour par an) = 21.5
		// Arrondir 19.5 à l'entier superieur : 22
		double expected = Math.round(17.5 + 2 + 2);
		
		
		Assertions.assertEquals(expected, salarieAideADomicileService.calculeLimiteEntrepriseCongesPermis(
				aide.getMoisEnCours(), 
				aide.getCongesPayesAcquisAnneeNMoins1(),
				aide.getMoisDebutContrat(), 
				LocalDate.of(2022,12,25),
				LocalDate.of(2023,1,5)));
	}

}
