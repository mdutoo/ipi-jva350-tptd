package com.ipi.jva350.service;

import com.ipi.jva350.exception.SalarieException;
import com.ipi.jva350.model.SalarieAideADomicile;
import com.ipi.jva350.repository.SalarieAideADomicileRepository;
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

    @Autowired
    SalarieAideADomicileRepository salarieAideADomicileRepository;

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

    @Test
    void testCalculeLimiteEntrepriseCongesPermis() {
        // Given
        SalarieAideADomicile salarie = new SalarieAideADomicile();
        salarie.setNom("Ruben");
        salarie.setMoisEnCours(LocalDate.parse("2022-01-01"));
        salarie.setCongesPayesAcquisAnneeNMoins1(20);
        salarie.setMoisDebutContrat(LocalDate.parse("2021-01-01"));
        salarieAideADomicileRepository.save(salarie);
        //When
        long limiteEntrepriseCongesPermis = salarieAideADomicileService.calculeLimiteEntrepriseCongesPermis(salarie.getMoisEnCours(),
                salarie.getCongesPayesAcquisAnneeNMoins1(),
                salarie.getMoisDebutContrat(),LocalDate.parse("2022-01-20"),LocalDate.parse("2022-02-01"));

        // Then
        Assertions.assertEquals(limiteEntrepriseCongesPermis, 15L);
    }

}
