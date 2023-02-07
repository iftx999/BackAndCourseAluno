package com.loiane.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record AlunoDTO(

        @JsonProperty("idAluno") Long idAluno,
        @NotBlank @NotNull @Length(min = 5, max = 100) String nome,
        @NotBlank @NotNull @Length(min = 5, max = 100) Integer idade,
        @NotNull @Length(min = 5, max = 100)  String cpf) {
}