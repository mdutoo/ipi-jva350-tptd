package com.ipi.jva350;

import com.ipi.jva350.exception.SalarieException;
import com.ipi.jva350.model.SalarieAideADomicile;
import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import com.ipi.jva350.service.SalarieAideADomicileService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SalarieAideADomicileServiceTest {

    @Autowired
    SalarieAideADomicileRepository Repo;

    @Test
    public void creerSalarieAideADomicile() throws SalarieException {
        SalarieAideADomicile salarie=new SalarieAideADomicile();
        salarie.setNom("Joris");
        Repo.save(salarie);
        SalarieAideADomicileService service=new SalarieAideADomicileService();
        salarie.setNom("Ali");
        service.creerSalarieAideADomicile(salarie);
        Assertions.assertThat(Repo.findByNom(salarie.getNom())).isEqualTo(salarie);
    }
    @Test
    public void cloturemois() throws SalarieException {
        SalarieAideADomicile salarie=new SalarieAideADomicile();
        salarie.setNom("Joris");
        Repo.save(salarie);
        salarie.setNom("valentin");
        SalarieAideADomicileService service=new SalarieAideADomicileService();
        service.creerSalarieAideADomicile(salarie);
        service.clotureMois(salarie,10);
        Assertions.assertThat(Repo.findByNom(salarie.getNom())).isEqualTo(salarie);



    }
}
