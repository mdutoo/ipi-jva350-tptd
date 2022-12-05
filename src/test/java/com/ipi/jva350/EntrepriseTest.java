package com.ipi.jva350;

import com.ipi.jva350.model.Entreprise;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

public class EntrepriseTest {
    @ParameterizedTest(name = "test est dans plage")
    @CsvSource({
            "'2022-01-01','2021-06-01','2022-06-01', true",
            "'2022-06-01','2022-06-01','2022-12-01', false",
            "'2022-10-15','2021-06-01','2022-06-01', false",
    })
    public void estDansPlage(String d, String dateDebut, String dateFin, boolean expected){
        //Given
        Entreprise entreprise=new Entreprise();
        //When
        boolean verif=entreprise.estDansPlage(LocalDate.parse(d),LocalDate.parse(dateDebut), LocalDate.parse(dateFin));
        //Then
        Assertions.assertThat(verif).isEqualTo(expected);

    }

    @ParameterizedTest(name = "test estJourFerie")
    @CsvSource({
            "'2022-01-01', true",
            "'2022-06-01', false",
            "'2022-12-25', true",
            "'2022-05-01', true"
    })
    public void estJourFerie(String jour,boolean expected){
        //Given
        Entreprise entreprise=new Entreprise();
        //When
        boolean verif=entreprise.estJourFerie(LocalDate.parse(jour));
        //Then
        Assertions.assertThat(verif).isEqualTo(expected);
    }

    @ParameterizedTest(name = "test estJourFerie")
    @CsvSource({
            "'2022-01-01', true",
            "'2022-06-01', false",
            "'2022-12-25', true",
            "'2022-05-01', true"
    })
    public void proportionPondereeDuMois(String MoisDuConge){

    }



}
