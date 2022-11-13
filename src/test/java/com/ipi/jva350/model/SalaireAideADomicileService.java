package com.ipi.jva350.model;

import com.ipi.jva350.Jva350Application;
import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import com.ipi.jva350.service.SalarieAideADomicileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SalaireAideADomicileServiceTEST {
    @InjectMocks
    SalarieAideADomicileService salarieAideADomicileService;
    @Mock
    SalarieAideADomicileRepository salarieAideADomicileRepository;
    @BeforeEach
    void Init(){
    }

    @ParameterizedTest(name = "le nombre de congé de N-1 est {0}, le premier jour est {1} le dernier est {2}")
    @CsvSource({
        "0, '2022-01-03', '2022-01-03', 0", // Si aucun jour de congés dispo

    })
    void TestPonderaionDesCongésAcquisenNmoins1(double congesPayesAcquisAnneeNMoins1, LocalDate premierJourDeConge, LocalDate dernierJourDeConge, double expected){
        double result = salarieAideADomicileService.PonderaionDesCongésAcquisenNmoins1(congesPayesAcquisAnneeNMoins1, premierJourDeConge, dernierJourDeConge);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "il  a déjà pris {0} jour et il en a" +
                            " {1} dispo de l'an dernier" +
                            "le mois en cours est {2}" +
                            "le contrat à commencé le {3}"+
                            "le premier jour de congé est {4}" +
                            "le dernier jour de congé est {5}" +
                             ":: the expected result is {6} ")
    @CsvSource
            ({
                    "1, 0, '2022-01-03', '2022-01-03', '2022-01-03', '2022-01-03', 0", //Cas où il a pris enormément de jour -1 rt qu'il n'en a plus en janvier
                    "1, 0, '2022-07-03', '2022-01-03', '2022-09-03', '2022-11-03', 0",   //Date Actuel Aout
                    "1, 0, '2022-08-03', '2022-01-03', '2022-09-03', '2022-11-03', 0",   //Date Actuel en Juillet
                    "1, 0, '2022-01-03', '2022-01-03', '2022-07-03', '2022-08-30', 0",   //Congé sur Juillet Aout
                    "1, 0, '2022-01-03', '2000-01-03', '2022-07-03', '2022-08-30', 10",  //---------------------- et contrat depuis 10 ans [années d'ancienneté]
                    "1, 0, '2022-01-03', '2000-01-03', '2022-07-03', '2022-08-30', 10",  //---------------------- et contrat depuis 11 ans [années d'ancienneté]
                    "0, 1, '2022-01-03', '2022-01-03', '2022-01-03', '2022-01-03', 0",    //Cas où il a des jours de l'année précédente et aucun congés pris
                    "0, 1, '2022-01-03', '2021-01-03', '2022-01-03', '2022-01-03', 1",      //1 an d'ancienneté [années d'ancienneté]
                    "0, 1, '2022-01-03', '2022-01-03', '2022-02-03', '2022-02-03', 1",      //Fevier
                    "0.1, 50, '2022-01-03', '2022-01-03', '2022-07-03', '2022-12-03', 1",



                    //"1000, 250, '2022-01-03', '2022-01-03', '2022-02-03', '2022-02-03', 1",
            })
    void TestCalculeLimiteEntrepriseCongesPermis(double congePrisAnneeNmoins1,
                                                 double congePayerAcquisNmoins1,
                                                 LocalDate currentMonth,
                                                 LocalDate contractStart,
                                                 LocalDate firstDayOff,
                                                 LocalDate lastDayOff,
                                                 double expected)
    {
        Mockito.when(salarieAideADomicileRepository.partCongesPrisTotauxAnneeNMoins1()).thenReturn(congePrisAnneeNmoins1);
        long result = salarieAideADomicileService.calculeLimiteEntrepriseCongesPermis(currentMonth,
                                                                                    congePayerAcquisNmoins1,
                                                                                    contractStart,
                                                                                    firstDayOff,
                                                                                    lastDayOff
        );

        assertEquals(expected,result);
    }
}
