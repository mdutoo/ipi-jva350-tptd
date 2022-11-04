package com.ipi.jva350;
import static org.junit.jupiter.api.Assertions.*;

import com.ipi.jva350.model.SalarieAideADomicile;
import org.hibernate.type.LocalDateTimeType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import java.io.Console;
import java.io.PrintWriter;
import java.time.LocalDate;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/ipi/jva350")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class RunSalaireAideADomicileTest {
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
    void TEST_ALegalementDroitADesCongesPayes_ADejaCPMaisPasUtilise_TRUE(){
        assertTrue(new SalarieAideADomicile("Patrick", LocalDate.now(),
                                                LocalDate.now(), 0,
                                                0, 0,
                                            1, 0).aLegalementDroitADesCongesPayes());
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
    @Disabled
    @ParameterizedTest
    @CsvSource
            ({"'01/01/2022', '12/12/2023"
            })
    void TESTcalculeJoursDeCongeDecomptesPourPlage(LocalDate dateDebut, LocalDate dateFin){
        //Given :
        SalarieAideADomicile aideADomicile = new SalarieAideADomicile();
        //When :
        aideADomicile.calculeJoursDeCongeDecomptesPourPlage(dateDebut, dateFin);
        //Then :

    }
}
