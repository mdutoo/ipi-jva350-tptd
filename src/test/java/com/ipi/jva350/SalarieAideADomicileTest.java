package com.ipi.jva350;
import com.ipi.jva350.model.SalarieAideADomicile;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.LinkedHashSet;

public class SalarieAideADomicileTest {
   @Test
    public void aLegalementDroitADesCongesPayes14(){
       // Given : Mise en place de l'environnement du test et de ses données (hypothèses)
       double joursTravaillesAnneeNMoins1=14;
       SalarieAideADomicile salarie=new SalarieAideADomicile();
       salarie.setJoursTravaillesAnneeNMoins1(joursTravaillesAnneeNMoins1);
       // When
       boolean joursTravaillesAnneeNMoins1OK=salarie.aLegalementDroitADesCongesPayes();
       // Then
       Assertions.assertThat(joursTravaillesAnneeNMoins1OK).isTrue();
   }
   @Test
   public void aLegalementDroitADesCongesPayes100(){
      // Given : Mise en place de l'environnement du test et de ses données (hypothèses)
      double joursTravaillesAnneeNMoins1=100;
      SalarieAideADomicile salarie=new SalarieAideADomicile();
      salarie.setJoursTravaillesAnneeNMoins1(joursTravaillesAnneeNMoins1);
      // When
      boolean joursTravaillesAnneeNMoins1OK=salarie.aLegalementDroitADesCongesPayes();
      // Then
      Assertions.assertThat(joursTravaillesAnneeNMoins1OK).isTrue();
   }


   @ParameterizedTest(name = "dateDebut {0} dateFin {0} sont valide : {1}")
   @CsvSource({
           "'2022-11-01', '2022-10-01', 0",
           "'2022-01-01', '2022-05-01', 101"
   })

   public void calculeJoursDeCongeDecomptesPourPlage(String dateDebut,String dateFin,int expected){
      //Given
      SalarieAideADomicile aide= new SalarieAideADomicile();
      //When
      LinkedHashSet<LocalDate> jourDeCongeDecomptes=aide.calculeJoursDeCongeDecomptesPourPlage(LocalDate.parse(dateDebut),LocalDate.parse(dateFin));
      //Then
      Assertions.assertThat(jourDeCongeDecomptes.size()).isEqualTo(expected);

   }
}
