package com.loiane.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.loiane.model.Setor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public record ProfessorDTO(

        @JsonProperty("idProfessor") Long idProfessor,


        @NotBlank @NotNull @Length(min = 5, max = 100) String nameProf,


        @NotNull
        @JsonFormat(pattern = "dd/MM/yyyy")
        Date nascimento,

        @NotBlank @NotNull @Length(min = 5, max = 100) String endereco,

        @NotBlank @NotNull @Length(min = 5, max = 100) String email,

       @NotNull  Double salario,



        @NotNull @Length(min = 16, max = 100)  String telefone,

         @JsonProperty("idSetor")
        Setor idSetor) {
}