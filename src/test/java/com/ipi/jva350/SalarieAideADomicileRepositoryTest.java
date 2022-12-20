package com.ipi.jva350;

import com.ipi.jva350.model.SalarieAideADomicile;
import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;


@RunWith(SpringRunner.class)
@DataJpaTest
public class SalarieAideADomicileRepositoryTest {
    @Autowired
    SalarieAideADomicileRepository salarieRepo;
    @Test
    public void partCongesPrisTotauxAnneeNMoins1(){
        /*la methode fait la sum de toutes les valeurs de congesPayePrisAnneeNMoins1 et divise par la sum
        de toutes les valeurs de congePayesAcquisAnnéeNMoins1
        elle permet notamment de savoir le taux de conges pris par les salaries
        */

        //Given
        SalarieAideADomicile salarie=new SalarieAideADomicile();
        SalarieAideADomicile salarie2=new SalarieAideADomicile();
        String nom="Georges";
        String nom2="Mohamed";
        salarie.setNom(nom);
        salarie2.setNom(nom2);
        salarie.setCongesPayesAcquisAnneeNMoins1(100);
        salarie2.setCongesPayesAcquisAnneeNMoins1(100);
        salarie.setCongesPayesPrisAnneeNMoins1(10);
        salarie2.setCongesPayesPrisAnneeNMoins1(10);
        //When
        salarieRepo.save(salarie);
        salarieRepo.save(salarie2);
        //Then
        Assertions.assertThat(salarieRepo.partCongesPrisTotauxAnneeNMoins1()).isEqualTo(0.1);

    }
}
