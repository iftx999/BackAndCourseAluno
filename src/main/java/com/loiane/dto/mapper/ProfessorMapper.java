package com.loiane.dto.mapper;

import com.loiane.dto.ProfessorDTO;
import com.loiane.model.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public ProfessorDTO toDTO(Professor professor) {
        if (professor == null) {
            return null;
        }
        return new ProfessorDTO(professor.getIdProfessor(), professor.getNameProf(),  professor.getNascimento(), professor.getEndereco(), professor.getTelefone(), professor.getSalario(), professor.getEmail(), professor.getIdSetor() );
    }

    public Professor toEntity(ProfessorDTO professorDTO) {

        if (professorDTO == null) {
            return null;
        }

        Professor professor = new Professor();
        if (professorDTO.idProfessor() != null) {
            professor.setIdProfessor(professorDTO.idProfessor());
        }
        professor.setNameProf(professorDTO.nameProf());
        professor.setNascimento(professorDTO.nascimento());
        professor.setEndereco(professorDTO.endereco());
        professor.setTelefone(professorDTO.telefone());
        professor.setEmail(professorDTO.email());
        professor.setSalario(professorDTO.salario());
        professor.setIdSetor(professorDTO.idSetor());

        return professor;
    }
}


