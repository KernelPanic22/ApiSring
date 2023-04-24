package com.example.kavanagh.suterhscrapper.repository;

import com.example.kavanagh.suterhscrapper.entities.SalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface SalaryRepository extends JpaRepository<SalaryEntity, Long> {

    @Query(value = "SELECT * FROM suterhdb.categoria_por_funcion_especifica as a\n" +
            "INNER JOIN (SELECT MAX(fecha_planilla) as fecha_planilla  FROM suterhdb.categoria_por_funcion_especifica ) as b\n" +
            "on a.fecha_planilla = b.fecha_planilla", nativeQuery = true)
    List<SalaryEntity> getSalaries();
}
