package com.example.kavanagh.suterhscrapper.controller;

import com.example.kavanagh.suterhscrapper.DTO.SalaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.kavanagh.suterhscrapper.service.SuterhService;
import java.util.List;

@RestController
@RequestMapping("/suterh")
public class SuterhController {

    @Autowired
    private SuterhService suterhService;

    @GetMapping("/planilla-salarial")
    @ResponseBody
    public ResponseEntity<List<SalaryDTO>> getPlanillaSalarial() {
        return suterhService.getSalaries();
    }
}
