package com.ipi.jva350.model;

import com.ipi.jva350.exception.NotImplementedException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EntrepriseTest {
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

    @Test
    void getPremierJourAnneeDeCongesNULL() {
        assertEquals(null,Entreprise.getPremierJourAnneeDeConges(null));
    }
    @Test
    void getPremierJourAnneeDeCongesOk() {
    LocalDate date = LocalDate.parse("2022-06-28");//Vendredi
        assertEquals(2021,Entreprise.getPremierJourAnneeDeConges(date).getYear());
    }
}
