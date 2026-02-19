package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;d

public class SalarieAideADomicile_aLegalementDroitADesCongesPayesTest {

    @Test
    public void testALegalementDroitADesCongesPayes_MoinsDe10Jours() {

        SalarieAideADomicile salarie = new SalarieAideADomicile();
        salarie.setJoursTravaillesAnneeNMoins1(9);

        boolean resultat = salarie.aLegalementDroitADesCongesPayes();

        Assertions.assertFalse(resultat, "Le droit ne devrait pas être ouvert pour 9 jours travaillés");
    }

    @Test
    public void testALegalementDroitADesCongesPayes_Exactement10Jours() {

        SalarieAideADomicile salarie = new SalarieAideADomicile();
        salarie.setJoursTravaillesAnneeNMoins1(10);

        boolean resultat = salarie.aLegalementDroitADesCongesPayes();

        Assertions.assertTrue(resultat, "Le droit devrait être ouvert à partir de 10 jours travaillés");
    }

    @Test
    public void testALegalementDroitADesCongesPayes_PlusDe10Jours() {
        SalarieAideADomicile salarie = new SalarieAideADomicile();
        salarie.setJoursTravaillesAnneeNMoins1(20);

        boolean resultat = salarie.aLegalementDroitADesCongesPayes();

        Assertions.assertTrue(resultat, "Le droit devrait être ouvert pour 20 jours travaillés");
    }
}