package com.ipi.jva350.model;

import com.ipi.jva350.exception.NotImplementedException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EntrepriseTest {
    //region est dans plage
    @ParameterizedTest(name = "date{0} est dans [debut{1} fin{2}]")
    @CsvSource
            ({
                    "'2022-10-31', '2022-10-31' , '2022-11-04'",
                    "'2022-11-02', '2022-10-31' , '2022-11-04'",
                    "'2022-11-04', '2022-10-31' , '2022-11-04'",
            })
    void testEstDansPlage(LocalDate d , LocalDate dateDebut, LocalDate dateFin )  {
        //GIVEN WHEN
        boolean res = Entreprise.estDansPlage(d , dateDebut , dateFin );
        //THEN
        assertEquals(true , res);
    }

    @ParameterizedTest(name = "date{0} est dans [debut{1} fin{2}]")
    @CsvSource
            ({
                    "'2022-10-30', '2022-10-31' , '2022-11-04'",
                    "'2022-10-05', '2022-10-31' , '2022-11-04'",

            })
    void testPasDansPlage(LocalDate d , LocalDate dateDebut, LocalDate dateFin )  {
        //GIVEN WHEN
        boolean res = Entreprise.estDansPlage(d , dateDebut , dateFin );
        //THEN
        assertEquals(false , res);
    }
    //endregion
    //region estJourFerrié
    @Test
    void estJourFerieFalse() {
        LocalDate date = LocalDate.parse("2022-05-28");//Samedi
        assertEquals(false , Entreprise.estJourFerie(date));
    }
    @Test
    void estJourFerieTrue() {
        LocalDate date = LocalDate.parse("2022-11-11");//Vendredi
        assertEquals(true , Entreprise.estJourFerie(date));
    }

    @Test
    void estJourFerie29Fevrier() {
        LocalDate date = LocalDate.parse("2020-02-29");//Vendredi
        assertEquals(false , Entreprise.estJourFerie(date));
    }
    //endregion
    //proportionPondereeDuMois
    @ParameterizedTest(name = "date{0} est dans [debut{1} fin{2}]")
    @CsvSource
            ({
                    "'2022-01-01'",
                    "'2022-02-01'",
                    "'2022-03-01'",
                    "'2022-04-01'",
                    "'2022-05-01'",
                    "'2022-06-01'",
                    "'2022-07-01'",
                    "'2022-08-01'",
                    "'2022-09-01'",
                    "'2022-10-01'",
                    "'2022-11-01'",
                    "'2022-12-01'",
            })
    void TESTproportionPondereeDuMois01(){
        double result = Entreprise.proportionPondereeDuMois(LocalDate.parse("2020-02-29"));
        assertTrue((result >= 0 || result <= 1));
    }
    //endregion
}
