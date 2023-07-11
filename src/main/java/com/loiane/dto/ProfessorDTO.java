package com.loiane.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DatabindException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public record ProfessorDTO(

        @JsonProperty("idProfessor") Long idProfessor,


        @NotBlank @NotNull @Length(min = 5, max = 100) String nameProf,


        @NotNull
        Date nascimento,

        @NotBlank @NotNull @Length(min = 5, max = 100) String endereco,

        @NotBlank @NotNull @Length(min = 5, max = 100) String email,

        @NotBlank @NotNull @Length(min = 5, max = 100) Double salario,



        @NotNull @Length(min = 16, max = 100)  String telefone) {
}