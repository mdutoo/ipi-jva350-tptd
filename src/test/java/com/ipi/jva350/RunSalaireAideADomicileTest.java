package com.ipi.jva350;
import static org.junit.jupiter.api.Assertions.*;

import com.ipi.jva350.model.SalarieAideADomicile;
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

    @Test
    void TESTALegalementDroitADesCongesPayesTRUE(){
        assertTrue(new SalarieAideADomicile().aLegalementDroitADesCongesPayes(1500));
    }

    @Test
    void TESTALegalementDroitADesCongesPayesFalse(){
        assertFalse(new SalarieAideADomicile().aLegalementDroitADesCongesPayes(0));
    }

    @ParameterizedTest
    @CsvSource
            ({"'-999999999-01-01','+999999999-12-31'",
                    "'2022-01-01', '2023-12-26"
            })
    void TESTcalculeJoursDeCongeDecomptesPourPlage(LocalDate dateDebut, LocalDate dateFin){
        //Given :
        SalarieAideADomicile aideADomicile = new SalarieAideADomicile();
        //When :
        aideADomicile.calculeJoursDeCongeDecomptesPourPlage(dateDebut, dateFin);
    }
}
