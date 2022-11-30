package com.ipi.jva350.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ipi.jva350.model.SalarieAideADomicile;
import com.ipi.jva350.service.SalarieAideADomicileService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SalarieAideADomicileRepositoryTest {

	@Autowired
	private SalarieAideADomicileRepository salarieAideADomicileRepository;
	
	@ParameterizedTest(name = "congesPayesAcquisAnneeNMoins1: {0} et congesPayesPrisAnneeNMoins1: {1}, resultats attendu: {2}")
	@CsvSource({
	"5, 5, 1.0",
	"1, 7, 2.0",
	"4, 13, 2.5"
	
	})
	void testPartCongesPrisTotauxAnneeNMoins1(double congesPayesAcquisAnneeNMoins1, double congesPayesPrisAnneeNMoins1, double result) {
		
		//la fonction salarieAideADomicileRepository.partCongesPrisTotauxAnneeNMoins1() divise la somme des congesPayesPrisAnneeNMoins1 avec congesPayesAcquisAnneeNMoins1
		
		SalarieAideADomicile aide = new SalarieAideADomicile("Numéro 1976562821", LocalDate.of(2021, 7, 1),LocalDate.now(),0,0,9,congesPayesAcquisAnneeNMoins1,congesPayesPrisAnneeNMoins1);
		salarieAideADomicileRepository.save(aide);
		System.out.println(salarieAideADomicileRepository.partCongesPrisTotauxAnneeNMoins1());
		
		Assertions.assertEquals(result,salarieAideADomicileRepository.partCongesPrisTotauxAnneeNMoins1());


	}

}

