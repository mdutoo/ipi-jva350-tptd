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
		SalarieAideADomicile aide = new SalarieAideADomicile("Numéro 1976562821", LocalDate.of(2021, 7, 1),LocalDate.now(),0,0,9,1,0);
		
		salarieAideADomicileService.clotureMois(aide, 20);
		Assertions.assertEquals(20, aide.getJoursTravaillesAnneeN());
	}

}
