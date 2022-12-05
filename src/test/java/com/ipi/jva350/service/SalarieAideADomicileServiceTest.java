package com.ipi.jva350.service;

import com.ipi.jva350.exception.SalarieException;
import com.ipi.jva350.model.SalarieAideADomicile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SalarieAideADomicileServiceTest {

    @Autowired
    private SalarieAideADomicileService salarieAideADomicileService;

    @Test
    void testClotureMoisJoursTravailles() throws SalarieException {
        // Given
        SalarieAideADomicile salarieAideADomicile = new SalarieAideADomicile();
        double joursTravaillesInitial = 10;
        salarieAideADomicile.setJoursTravaillesAnneeN(joursTravaillesInitial);
        salarieAideADomicile.setMoisEnCours(LocalDate.parse("2022-11-01"));
        double joursTravailles = 20;
        // When
        salarieAideADomicileService.clotureMois(salarieAideADomicile, joursTravailles);
        // Then
        Assertions.assertEquals(joursTravaillesInitial + joursTravailles, salarieAideADomicile.getJoursTravaillesAnneeN());
    }

    @Test
    void testClotureMoisCongesPayesAcquis() throws SalarieException {
        // Given
        SalarieAideADomicile salarieAideADomicile = new SalarieAideADomicile();
        double congesPayesAcquisInitial = 10;
        salarieAideADomicile.setCongesPayesAcquisAnneeN(congesPayesAcquisInitial);
        salarieAideADomicile.setMoisEnCours(LocalDate.parse("2022-11-01"));
        double joursTravailles = 20;
        // When
        salarieAideADomicileService.clotureMois(salarieAideADomicile, joursTravailles);
        // Then
        Assertions.assertEquals(congesPayesAcquisInitial + SalarieAideADomicile.CONGES_PAYES_ACQUIS_PAR_MOIS, salarieAideADomicile.getCongesPayesAcquisAnneeN());
    }

    // MOCK
//    @Test
//    void testCalculeLimiteEntrepriseCongesPermis() {
//        // Given
//        SalarieAideADomicile salarieAideADomicile = new SalarieAideADomicile();
//        LocalDate moisEnCours = LocalDate.parse("2022-12-04");
//        double congesPayesAcquisAnneeNMoins1 = 10;
//        LocalDate moisDebutContrat = LocalDate.parse("2022-01-01");
//        LocalDate premierJourConge = LocalDate.parse("2022-12-16");
//        LocalDate dernierJourConge = LocalDate.parse("2022-12-25");
//        // When
//        salarieAideADomicileService.calculeLimiteEntrepriseCongesPermis(moisEnCours, congesPayesAcquisAnneeNMoins1, moisDebutContrat, premierJourConge, dernierJourConge);
//        // Then
//    }

}
