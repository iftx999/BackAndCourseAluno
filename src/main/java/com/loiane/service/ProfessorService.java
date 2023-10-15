package com.loiane.service;

import com.loiane.dto.ProfessorDTO;
import com.loiane.dto.mapper.ProfessorMapper;
import com.loiane.exception.RecordNotFoundException;
import com.loiane.repository.ProfesorRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Validated
@Service

public class ProfessorService {
    private final ProfesorRepository profesorRepository;

    private final ProfessorMapper professorMapper;


    public ProfessorService(ProfesorRepository profesorRepository, ProfessorMapper professorMapper) {
        this.profesorRepository = profesorRepository;
        this.professorMapper = professorMapper;
    }

    public List<ProfessorDTO> list() {
        return profesorRepository.findAll()
                .stream()
                .map(professorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProfessorDTO findById(@PathVariable @NotNull @Positive Long idProfessor) {
        return profesorRepository.findById(idProfessor).map(professorMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(idProfessor));
    }

    public ProfessorDTO create(@Valid @NotNull ProfessorDTO professorDTO) {
        System.out.println(professorDTO);
        ProfessorDTO dto = professorMapper.toDTO(profesorRepository.save(professorMapper.toEntity(professorDTO)));
        return dto;
    }

    public ProfessorDTO update(@NotNull @Positive Long idProfessor, @Valid @NotNull ProfessorDTO professorDTO) {
        System.out.println(professorDTO);
        return profesorRepository.findById(idProfessor)
                .map(recordFound -> {
                   // recordFound.setIdProfessor(professorDTO.idProfessor());
                    recordFound.setNameProf(professorDTO.nameProf());
                    recordFound.setTelefone(professorDTO.telefone());
                    recordFound.setEmail(professorDTO.email());
                    recordFound.setEndereco(professorDTO.endereco());
                    recordFound.setSalario(professorDTO.salario());
                    recordFound.setIdSetor(professorDTO.idSetor());
                    return professorMapper.toDTO(profesorRepository.save(recordFound));
                }).orElseThrow(() -> new RecordNotFoundException(idProfessor));
    }

    public void delete(@PathVariable @NotNull @Positive Long idProfessor) {
        profesorRepository.delete(profesorRepository.findById(idProfessor)
                .orElseThrow(() -> new RecordNotFoundException(idProfessor)));
    }


    public List<ProfessorDTO> getAllColaboradores() {
        return profesorRepository.findAllBy();
    }
}


