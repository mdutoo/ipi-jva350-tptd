package com.ipi.jva350.repository;


import com.ipi.jva350.model.SalarieAideADomicile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SalarieAideADomicileRepositoryIntegrationTest {

    @Autowired
    private SalarieAideADomicileRepository salarieAideADomicileRepository;

    @Test
    void findByNomNotFound() {
        SalarieAideADomicile res = salarieAideADomicileRepository.findByNom("Ruben");
        Assertions.assertNull(res);
    }

    @Test
    void findByNomFound() {
        String testNom = "Ruben";
        SalarieAideADomicile salarieAideADomicile = new SalarieAideADomicile();
        salarieAideADomicile.setNom(testNom);
        salarieAideADomicileRepository.save(salarieAideADomicile);
        SalarieAideADomicile res = salarieAideADomicileRepository.findByNom(testNom);
        Assertions.assertNotNull(res);
        Assertions.assertEquals(testNom, res.getNom());
    }

    @Test
    void testPartCongesPrisTotauxAnneeNMoins1() {
        // Given
        SalarieAideADomicile salarieAideADomicile1 = new SalarieAideADomicile();
        SalarieAideADomicile salarieAideADomicile2 = new SalarieAideADomicile();
        String nom1 = "Ruben";
        String nom2 = "Jallifier";
        salarieAideADomicile1.setNom(nom1);
        salarieAideADomicile2.setNom(nom2);
        salarieAideADomicile1.setCongesPayesAcquisAnneeNMoins1(100);
        salarieAideADomicile2.setCongesPayesAcquisAnneeNMoins1(100);
        salarieAideADomicile1.setCongesPayesPrisAnneeNMoins1(10);
        salarieAideADomicile2.setCongesPayesPrisAnneeNMoins1(10);

        // When
        salarieAideADomicileRepository.save(salarieAideADomicile1);
        salarieAideADomicileRepository.save(salarieAideADomicile2);

        // Then
        Assertions.assertEquals(salarieAideADomicileRepository.partCongesPrisTotauxAnneeNMoins1(), 0.1);
        salarieAideADomicileRepository.partCongesPrisTotauxAnneeNMoins1();
    }

}
