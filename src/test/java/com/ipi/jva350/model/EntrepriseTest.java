package com.ipi.jva350.model;

import com.ipi.jva350.exception.NotImplementedException;
import org.junit.jupiter.api.Disabled;
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


}
