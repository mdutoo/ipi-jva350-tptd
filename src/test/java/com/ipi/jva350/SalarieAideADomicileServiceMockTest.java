package com.ipi.jva350;

import com.ipi.jva350.exception.SalarieException;
import com.ipi.jva350.model.SalarieAideADomicile;
import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import com.ipi.jva350.service.SalarieAideADomicileService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.class)
public class SalarieAideADomicileServiceMockTest {

    /***
     * la concention de codage JAVA recommande de mettre les variables et les methodes en camelcase
     * et commençant par une minuscule.
     *
     *
     */
    @InjectMocks
    SalarieAideADomicileService salarieServcice;
    @Mock
    SalarieAideADomicileRepository salarieRepo;

    @Test
    public void clotureMois() throws SalarieException {
        //Given
        SalarieAideADomicile salarie=new SalarieAideADomicile();
        salarie.setMoisEnCours(LocalDate.parse("2022-01-01"));
        salarie.setJoursTravaillesAnneeN(100);
        salarie.setCongesPayesAcquisAnneeN(15);
        Mockito.when(salarieRepo.save(Mockito.any(SalarieAideADomicile.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());
        ///When
        salarieServcice.clotureMois(salarie,10);
        //Then
        ArgumentCaptor<SalarieAideADomicile> salarieCaptor = ArgumentCaptor.forClass(SalarieAideADomicile.class);
        Mockito.verify(salarieRepo, Mockito.times(1)).save(salarieCaptor.capture()); // arg capture !
        Assertions.assertThat(salarieCaptor.getValue().getCongesPayesAcquisAnneeN()).isEqualTo(17.5);
        Assertions.assertThat(salarieCaptor.getValue().getJoursTravaillesAnneeN()).isEqualTo(110);
    }
    @Test
    public void calculeLimiteEntrepriseCongesPermis(){
        //Given
        SalarieAideADomicile salarie=new SalarieAideADomicile();
        salarie.setNom("Mohamed");
        salarie.setMoisEnCours(LocalDate.parse("2022-05-01"));
        salarie.setCongesPayesAcquisAnneeNMoins1(10);
        salarie.setMoisDebutContrat(LocalDate.parse("2021-01-01"));
        Mockito.when(salarieRepo.save(Mockito.any(SalarieAideADomicile.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());
        double partConge=0;
        Mockito.when(salarieRepo.partCongesPrisTotauxAnneeNMoins1()).thenReturn(partConge);

        ///When
        long limiteEntrepriseCongePermis=salarieServcice.calculeLimiteEntrepriseCongesPermis(salarie.getMoisEnCours(),
                salarie.getCongesPayesAcquisAnneeNMoins1(),
                salarie.getMoisDebutContrat(),LocalDate.parse("2022-01-20"),LocalDate.parse("2022-02-01"));

        //Then
        ArgumentCaptor<SalarieAideADomicile> salarieCaptor = ArgumentCaptor.forClass(SalarieAideADomicile.class);
        Mockito.verify(salarieRepo, Mockito.times(0)).save(salarieCaptor.capture()); // arg capture !
        Assertions.assertThat(limiteEntrepriseCongePermis).isEqualTo(8L);

    }
}
