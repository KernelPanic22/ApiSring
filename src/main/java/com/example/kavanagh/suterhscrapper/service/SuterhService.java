package com.example.kavanagh.suterhscrapper.service;

import com.example.kavanagh.suterhscrapper.DTO.SalaryDTO;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface SuterhService {
    ResponseEntity<List<SalaryDTO>> getSalaries();
}
