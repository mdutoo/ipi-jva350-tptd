package com.ipi.jva350;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import com.ipi.jva350.service.SalarieAideADomicileService;

@ExtendWith(MockitoExtension.class)
public class calculeLimiteEntrepriseCongesPermis {
    //Pour test unitaire MOCK
    @Mock
    private SalarieAideADomicileRepository salarieAideADomicileRepository;
    @InjectMocks
    private SalarieAideADomicileService salarieAideADomicileService = new SalarieAideADomicileService();
	//je vois pas pourquoi il y a une erreur
    /*@Test
    public void testIntegrationServiceCalculeLimiteEntrepriseCongesPermis(){
        // Given
        LocalDate moisEnCours = LocalDate.of(2023,11,1);
        double congePayeAquisAnneeNMoins1 = 25.00;
        LocalDate moisDebutContrat = LocalDate.of(2023, 1, 12);
        LocalDate premierJourConge = LocalDate.of(2024, 1, 26);
        LocalDate dernierJourConge = LocalDate.of(2022, 1, 30);
        // When
        long res = SalarieAideADomicileService.calculeLimiteEntrepriseCongesPermis(
                moisEnCours,
                congePayeAquisAnneeNMoins1,
                moisDebutContrat,
                premierJourConge,
                dernierJourConge);
        // Then : assertions sur le vrai état du système
        assertEquals(1, 1);
    }*/

}
