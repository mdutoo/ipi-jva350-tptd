package com.ipi.jva350;

import com.ipi.jva350.model.Entreprise;
<<<<<<< HEAD
<<<<<<< HEAD
import org.assertj.core.api.Assertions;
=======
import com.ipi.jva350.model.SalarieAideADomicile;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
>>>>>>> 16ddc81bef366e2dab8592145c08f495fb9d1b96
=======
import com.ipi.jva350.model.SalarieAideADomicile;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
>>>>>>> f6bf26f4343bd6e328710cc849b6b21ab2dd46d8
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
<<<<<<< HEAD
<<<<<<< HEAD

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
=======
=======
>>>>>>> f6bf26f4343bd6e328710cc849b6b21ab2dd46d8
import java.util.LinkedHashSet;

public class EntrepriseTest {

    @ParameterizedTest(name = "test estDansPlage")
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
<<<<<<< HEAD
>>>>>>> 16ddc81bef366e2dab8592145c08f495fb9d1b96
=======
>>>>>>> f6bf26f4343bd6e328710cc849b6b21ab2dd46d8
        //Then
        Assertions.assertThat(verif).isEqualTo(expected);
    }

<<<<<<< HEAD
<<<<<<< HEAD
    @ParameterizedTest(name = "test estJourFerie")
    @CsvSource({
            "'2022-01-01', true",
            "'2022-06-01', false",
            "'2022-12-25', true",
            "'2022-05-01', true"
    })
    public void proportionPondereeDuMois(String MoisDuConge){

    }



=======
=======
>>>>>>> f6bf26f4343bd6e328710cc849b6b21ab2dd46d8
    @ParameterizedTest(name = "test estDansPlage")
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

    @ParameterizedTest(name = "test estDansPlage")
    @CsvSource({
            "'2022-12-01',  16",
            "'2022-07-01', 28",
            "'2022-07-01', 28",
            "'2021-01-01', 16",
            "'2020-01-12', 16"
    })
    public void proportionPondereeDuMois(String moisDuConge, double expected){
        //Given
        //When
        double verif=Entreprise.proportionPondereeDuMois(LocalDate.parse(moisDuConge));
        //Then
        Assertions.assertThat(verif).isEqualTo(expected);
    }
    @ParameterizedTest(name = "test estDansPlage")
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
<<<<<<< HEAD
>>>>>>> 16ddc81bef366e2dab8592145c08f495fb9d1b96
=======
    @ParameterizedTest(name = "test estJourFerie")
    @CsvSource({
            "'2022-01-01', true",
            "'2022-06-01', false",
            "'2022-12-25', true",
            "'2022-05-01', true"
    })
    public void proportionPondereeDuMois(String MoisDuConge){

    }




>>>>>>> f6bf26f4343bd6e328710cc849b6b21ab2dd46d8
}
