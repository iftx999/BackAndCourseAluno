package com.loiane.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DatabindException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public record SetorDTO(

        @JsonProperty("id") Long id,


        @NotBlank @NotNull @Length(min = 5, max = 100) String setor


        ) {
}