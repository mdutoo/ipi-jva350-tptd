package com.ipi.jva350.model;

import com.ipi.jva350.Jva350Application;
import com.ipi.jva350.service.SalarieAideADomicileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SalaireAideADomicileServiceTEST {
    @InjectMocks
    SalarieAideADomicileService salarieAideADomicileService;
    @Mock
    SalarieAideADomicile salarieAideADomicile;
    @BeforeEach
    void Init(){
        
    }
    @Test
    void TestCalculeLimiteEntrepriseCongesPermis(){
        SalarieAideADomicileService salaireAideADomicileService = new SalarieAideADomicileService();
        long result = salaireAideADomicileService.calculeLimiteEntrepriseCongesPermis(LocalDate.now(),0,
                                                                        LocalDate.of(2022,02,01),
                                                                        LocalDate.now(), LocalDate.now());
        assertEquals(0,result);
    }
}
