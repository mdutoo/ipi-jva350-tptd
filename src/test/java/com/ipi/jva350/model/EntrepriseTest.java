package com.ipi.jva350.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EntrepriseTest {

	@ParameterizedTest(name = "expectedResult: {3} du jour {0} comprit entre {1} et {2}")
	@CsvSource({
	        "'2022-07-05', '2022-07-01', '2022-07-07', true",
	        "'2022-07-01', '2022-07-01', '2022-07-07', true",
	        "'2022-07-07', '2022-07-01', '2022-07-07', true",
	        "'2022-07-08', '2022-07-01', '2022-07-07', false",
	        "'2022-08-31', '2022-07-01', '2022-07-07', false"
	})
	void estDansPlage(String now, String debut, String fin, boolean expectedResult) {
		//Given
		Entreprise aide = new Entreprise();
		//When
		boolean res = Entreprise.estDansPlage(LocalDate.parse(now), LocalDate.parse(debut), LocalDate.parse(fin));
		//Then
		Assertions.assertEquals(res, expectedResult);
		
	}

}
