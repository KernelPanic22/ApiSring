package com.example.kavanagh.suterhscrapper.service.impl;

import com.example.kavanagh.suterhscrapper.DTO.SalaryDTO;
import com.example.kavanagh.suterhscrapper.entities.SalaryEntity;
import com.example.kavanagh.suterhscrapper.repository.SalaryRepository;
import com.example.kavanagh.suterhscrapper.service.SuterhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SuterhServiceImpl implements SuterhService {

    @Autowired
    private SalaryRepository salaryRepository;

    /**
     * @param  No params
     * @return Retorna todas las funciones de la planilla salarial con sus respectivas categorias
     *         y su codigo de la siguiente manera:
     *         {
     *         "funcion": "string",
     *         "codigo": 0,
     *         "cat_1": 0,
     *         "cat_2": 0,
     *         "cat_3": 0,
     *         "cat_4": 0
     *         }
     */
    @Override
    public ResponseEntity<List<SalaryDTO>> getSalaries() {
        List<SalaryEntity> list = salaryRepository.getSalaries();
        if(list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(Stream.of(SalaryDTO.builder()
                            .function("No hay datos en la base de datos, verificar la importacion de datos de la pagina de suterh.")
                            .code(0)
                            .categoryOne(0f)
                            .categoryTwo(0f)
                            .categoryThree(0f)
                            .categoryFour(0f)
                            .build()).collect(Collectors.toList()));
        }

        List<SalaryDTO> result = list.stream().map(salaryEntity -> {
            return SalaryDTO.builder()
                    .function(salaryEntity.getFunction())
                    .code(salaryEntity.getCode())
                    .categoryOne(salaryEntity.getCategoryOne())
                    .categoryTwo(salaryEntity.getCategoryTwo())
                    .categoryThree(salaryEntity.getCategoryThree())
                    .categoryFour(salaryEntity.getCategoryFour())
                    .build();
        }).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

}
