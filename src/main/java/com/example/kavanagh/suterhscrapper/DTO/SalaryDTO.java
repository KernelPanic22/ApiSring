package com.example.kavanagh.suterhscrapper.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
@Builder
public class SalaryDTO {
    @JsonProperty("funcion")
    String function;

    @JsonProperty("codigo")
    Integer code;

    @JsonProperty("cat_1")
    Float categoryOne;

    @JsonProperty("cat_2")
    Float categoryTwo;

    @JsonProperty("cat_3")
    Float categoryThree;

    @JsonProperty("cat_4")
    Float categoryFour;
}
