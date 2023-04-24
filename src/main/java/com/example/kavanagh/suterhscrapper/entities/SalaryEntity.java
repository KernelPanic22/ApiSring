package com.example.kavanagh.suterhscrapper.entities;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "categoria_por_funcion_especifica_abril_2023")
@Entity
public class SalaryEntity implements Serializable {

    private static final long serialVersionUID = 2070766547542608864L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "funcion")
    private String function;

    @Column(name = "categoria_uno")
    private Float categoryOne;

    @Column(name = "categoria_dos")
    private Float categoryTwo;

    @Column(name = "categoria_tres")
    private Float categoryThree;

    @Column(name = "categoria_cuatro")
    private Float categoryFour;

    @Column(name = "codigo")
    private Integer code;

}
