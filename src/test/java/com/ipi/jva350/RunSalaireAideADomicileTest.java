package com.ipi.jva350;

import com.ipi.jva350.model.SalarieAideADomicile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import java.time.LocalDate;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static org.junit.jupiter.api.Assertions.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/ipi/jva350")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
class RunSalaireAideADomicileTest {

    //region Test_ALegalementDroitADesCongesPayes
    @Test
    void TEST_ALegalementDroitADesCongesPayes_NoINIT_False(){
        assertFalse(new SalarieAideADomicile().aLegalementDroitADesCongesPayes());
    }
    @Test
    void TEST_ALegalementDroitADesCongesPayes_EmptyINIT_False(){
        assertFalse(new SalarieAideADomicile("Patrick", LocalDate.now(),
                LocalDate.now(), 0,
                0, 0,
                0, 0).aLegalementDroitADesCongesPayes());
    }
    @Test
    void TEST_ALegalementDroitADesCongesPayes_CasAuxLimitesJoursTravaille(){
        SalarieAideADomicile aideADomicile = new SalarieAideADomicile("Patrick", LocalDate.now(),
                                                                LocalDate.now(), 0,
                                                                0, 9,
                                                                0, 0);

        assertFalse(aideADomicile.aLegalementDroitADesCongesPayes());

        aideADomicile.setJoursTravaillesAnneeNMoins1(10);
        assertTrue(aideADomicile.aLegalementDroitADesCongesPayes());
    }
    @Test
    void TEST_ALegalementDroitADesCongesPayes_ADejaCPMaisPasUtiliseEtJoursTravailleeSuffisant_TRUE(){
        assertTrue(new SalarieAideADomicile("Patrick", LocalDate.now(),
                LocalDate.now(), 0,
                0, 10,
                1, 0).aLegalementDroitADesCongesPayes());
    }

    //endregion
    //region CalculeJoursDeCongeDecomptesPourPlage
    @ParameterizedTest(name = "dateDebut{0}, dateFin{1}, expectedCount{2}")
    @CsvSource
            ({
                    "'2022-01-03', '2022-01-03', 1", //le meme jour
                    "'2022-01-08', '2022-01-08', 0", //le meme samedi
                    "'2022-12-12', '2022-01-01', 0", //date de fin anterieur
                    "'2022-01-08', '2022-01-10', 1", //du samedi au lundi
                    "'2022-01-07', '2022-01-10', 3", //du vendredi au lundi
                    "'2021-12-25', '2022-01-01', 5", //du samedi ferrier au samedi suivant
                    "'2022-01-01', '2022-12-12', 288", //data aleatoire sure l'année
            })
    void TESTcalculeJoursDeCongeDecomptesPourPlage(LocalDate dateDebut, LocalDate dateFin, int expectedCount){
        //Given :
        SalarieAideADomicile aideADomicile = new SalarieAideADomicile();
        //When :
        int result = aideADomicile.calculeJoursDeCongeDecomptesPourPlage(dateDebut, dateFin).size();
        //Then :
        assertEquals(expectedCount, result);
    }
    //endregion

    //region
    @Test
    void TESTestJourOuvrableTrue() {
        //GIVEN
        LocalDate date = LocalDate.of(2022, 4, 11); //lundi non ferrier
        SalarieAideADomicile salarieAideADomicile = new SalarieAideADomicile();
        //WHEN
        boolean res = salarieAideADomicile.estJourOuvrable(date);
        assertTrue(res);
    }

    @Test
    void TESTestJourOuvrableFalse() {
        //GIVEN
        LocalDate date = LocalDate.of(2022, 11, 6); //dimanche
        SalarieAideADomicile salarieAideADomicile = new SalarieAideADomicile();
        //WHEN
        boolean res = salarieAideADomicile.estJourOuvrable(date);
        assertFalse(res);
    }

    @Test
    void TESTestJourOuvrableFerrieeFalse() {
        //GIVEN
        LocalDate date = LocalDate.of(2022, 11, 11); // 11 novembre
        SalarieAideADomicile salarieAideADomicile = new SalarieAideADomicile();
        //WHEN
        boolean res = salarieAideADomicile.estJourOuvrable(date);
        assertFalse(res);
    }
    //endregion

    //region
    @ParameterizedTest(name = "date{0}")
    @CsvSource
            ({
                    "'2022-11-05'",
                    "'2022-11-06'",
            })
    void TESTestHabituellementTravailleSamediFalse(LocalDate date) {
        //WHEN
        SalarieAideADomicile salarieAideADomicile = new SalarieAideADomicile();
        boolean res = salarieAideADomicile.estHabituellementTravaille(date);
        //THEN
        assertFalse(res);
    }

    @ParameterizedTest(name = "date{0}")
    @CsvSource
            ({
                    "'2022-10-31'",
                    "'2022-11-01'",
                    "'2022-11-02'",
                    "'2022-11-03'",
                    "'2022-11-04'",
            })
    void TESTestHabituellementTravailleTrue(LocalDate date) {
        //WHEN
        SalarieAideADomicile salarieAideADomicile = new SalarieAideADomicile();
        boolean res = salarieAideADomicile.estHabituellementTravaille(date);
        //THEN
        assertTrue(res);
    }
    //endregion
}
