package com.ipi.jva350;

import com.ipi.jva350.exception.SalarieException;
import com.ipi.jva350.model.SalarieAideADomicile;
import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import com.ipi.jva350.service.SalarieAideADomicileService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SalarieAideADomicileServiceTest {

    @Autowired
    private SalarieAideADomicileService salarieAideADomicileService;

    @Autowired
    SalarieAideADomicileRepository salarieRepo;

    @Test
    void clotureMois() throws SalarieException {
        //Given
        SalarieAideADomicile salarie=new SalarieAideADomicile();
        salarie.setNom("Joris");
        salarie.setMoisEnCours(LocalDate.parse("2022-06-01"));
        salarie.setJoursTravaillesAnneeN(10);
        //When
        double joursTravaille=10;
        salarieAideADomicileService.clotureMois(salarie,joursTravaille);
        /*Assertions.assertThat(salarie.getJoursTravaillesAnneeN()).isEqualTo(20);*/
    }


    /**
     * Methode test sans l'utilisation des mocks
     */

    @Test
    void calculeLimiteEntrepriseCongesPermis(){
        //Given
        SalarieAideADomicile salarie=new SalarieAideADomicile();
        salarie.setNom("Mohamed");
        salarie.setMoisEnCours(LocalDate.parse("2022-01-01"));
        salarie.setCongesPayesAcquisAnneeNMoins1(20);
        salarie.setMoisDebutContrat(LocalDate.parse("2021-01-01"));
        salarieRepo.save(salarie);
        //When
         long limiteEntrepriseCongePermis=salarieAideADomicileService.calculeLimiteEntrepriseCongesPermis(salarie.getMoisEnCours(),
                salarie.getCongesPayesAcquisAnneeNMoins1(),
                salarie.getMoisDebutContrat(),LocalDate.parse("2022-01-20"),LocalDate.parse("2022-02-01"));

        //Then
        Assertions.assertThat(limiteEntrepriseCongePermis).isEqualTo(15L);
    }
}
