package com.loiane.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.loiane.model.Course;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

public record AlunoDTO(

        @JsonProperty("idAluno") Long idAluno,




        @NotBlank @NotNull @Length(min = 5, max = 100) String nome,


        @NotBlank @NotNull @Length(min = 5, max = 100) String responsavel,

        @NotBlank @NotNull @Length(min = 5, max = 100) String contato,


        //alunos
        @NotNull Integer idade,
        @NotNull @Length(min = 11, max = 100)  String cpf,

        @JsonProperty("idCourse")
        Course idCourse
        ) {
}