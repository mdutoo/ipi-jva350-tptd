package com.ipi.jva350.service;

import com.ipi.jva350.exception.SalarieException;
import com.ipi.jva350.model.SalarieAideADomicile;
import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class SalarieAideADomicileServiceMockTest {

    @InjectMocks
    private SalarieAideADomicileService salarieAideADomicileService;

    @Mock
    private SalarieAideADomicileRepository salarieAideADomicileRepository;

    @Test
    public void testClotureMois() throws SalarieException {
        // Given
        SalarieAideADomicile salarieAideADomicile = new SalarieAideADomicile();

        salarieAideADomicile.setJoursTravaillesAnneeN(20);
        salarieAideADomicile.setCongesPayesAcquisAnneeN(4);
        salarieAideADomicile.setMoisEnCours(LocalDate.parse("2022-01-31"));

        Mockito.when(salarieAideADomicileRepository.save(salarieAideADomicile)).thenAnswer(AdditionalAnswers.returnsFirstArg());
        // When
        salarieAideADomicileService.clotureMois(salarieAideADomicile, 20);
        // Then
        ArgumentCaptor<SalarieAideADomicile> salarieAideADomicileArgumentCaptor = ArgumentCaptor.forClass(SalarieAideADomicile.class);
        Mockito.verify(salarieAideADomicileRepository, Mockito.times(1)).save(salarieAideADomicileArgumentCaptor.capture());
        Assertions.assertEquals(salarieAideADomicileArgumentCaptor.getValue().getCongesPayesAcquisAnneeN(), 6.5);

    }

}
