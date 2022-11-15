package com.ipi.jva350.repository;

import com.ipi.jva350.model.SalarieAideADomicile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SalarieAideADomicileRepository extends JpaRepository<SalarieAideADomicile, Long> {

    SalarieAideADomicile findByNom(String nom);

    @Query("SELECT SUM(congesPayesPrisAnneeNMoins1)/SUM(congesPayesAcquisAnneeNMoins1) FROM SalarieAideADomicile")
    Double partCongesPrisTotauxAnneeNMoins1();
}
