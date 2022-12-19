package com.ipi.jva350;

import com.ipi.jva350.model.Entreprise;
import com.ipi.jva350.model.SalarieAideADomicile;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.LinkedHashSet;

public class EntrepriseTest {

    @ParameterizedTest(name = "TestestDansPlage")
    @CsvSource({
            "'2022-12-01', '2022-10-01', '2022-11-14', false",
            "'2022-07-01', '2021-05-01', '2021-12-25', false",
            "'2022-07-01', '2022-05-01', '2022-12-25', true",
            "'2021-01-01', '2020-05-01', '2022-12-25', true",
            "'2020-01-12', '2018-05-01', '2022-12-25', true"
    })
    public void estDansPlage(String d, String dateDebut, String dateFin,boolean expected){
        //Given
        Entreprise entreprise= new Entreprise();
        //When
        boolean verif=Entreprise.estDansPlage(LocalDate.parse(d),LocalDate.parse(dateDebut),LocalDate.parse(dateFin));
        //Then
        Assertions.assertThat(verif).isEqualTo(expected);
    }

    @ParameterizedTest(name = "TestEstJourFerie")
    @CsvSource({
            "'2022-12-01',  false",
            "'2022-07-01', false",
            "'2022-07-01', false",
            "'2021-01-01', true",
            "'2020-07-14', true"
    })
    public void estJourFerie(String d, boolean expected){
        ///Given
        Entreprise entreprise=new Entreprise();
        //When
        boolean verif=entreprise.estJourFerie(LocalDate.parse(d));
        //Then
        Assertions.assertThat(verif).isEqualTo(expected);
    }

    @ParameterizedTest(name = "TestProportionPonderee")
    @CsvSource({
            "'2022-12-01',  0.6666666666666667",
            "'2022-07-01', 0.23333333333333334",
            "'2022-07-01', 0.23333333333333334",
            "'2021-01-01',  0.7333333333333333",
            "'2020-01-12', 0.7333333333333333"
    })
    public void proportionPondereeDuMois(String moisDuConge, double expected){
        //Given
        //When
        double verif=Entreprise.proportionPondereeDuMois(LocalDate.parse(moisDuConge));
        //Then
        Assertions.assertThat(verif).isEqualTo(expected);
    }

    @ParameterizedTest(name = "TestGetPremierJourAnnéeConge")
    @CsvSource({
            "'2022-12-01',  '2022-06-01'",
            "'2022-07-01', '2022-06-01'",
            "'2022-07-01', '2022-06-01'",
            "'2021-01-01', '2020-06-01'",
            "'2020-01-12', '2019-06-01'"
    })
    public void getPremierJourAnneeDeConge(String d, String expected){
        //Given

        //When
        LocalDate verif=Entreprise.getPremierJourAnneeDeConges(LocalDate.parse(d));
        //Then
        Assertions.assertThat(verif).isEqualTo(LocalDate.parse(expected));
    }

}
