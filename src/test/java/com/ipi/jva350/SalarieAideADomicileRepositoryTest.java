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
    public void findByNom(){
        SalarieAideADomicile salarie=new SalarieAideADomicile();
        String nom="Georges";
        salarie.setNom(nom);
        salarieRepo.save(salarie);
        Assertions.assertThat(salarieRepo.findByNom(nom)).isEqualTo(salarie);


    }
    @Test
    public void findByNomNotExists(){
        SalarieAideADomicile salarie=new SalarieAideADomicile();
        String nom="Georges";
        salarie.setNom(nom);
        Assertions.assertThat(salarieRepo.findByNom(nom)).isEqualTo(null);
    }
}
