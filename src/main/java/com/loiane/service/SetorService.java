package com.loiane.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class SetorService {


    public SetorService(SetorRepository setorRepository, SetorMapper setorMapper) {
        this.SetorRepository = setorRepository;
        this.SetorMapper = setorMapper;
    }

    public List<SetorDTO> list() {
        return SetorRepository.findAll()
                .stream()
                .map(SetorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SetorDTO findById(@PathVariable @NotNull @Positive Long idProfessor) {
        return SetorRepository.findById(idProfessor).map(SetorMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(idProfessor));
    }

    public SetorDTO create(@Valid @NotNull SetorDTO SetorDTO) {
        SetorDTO dto = SetorMapper.toDTO(SetorRepository.save(SetorMapper.toEntity(SetorDTO)));
        return dto;
    }

    public SetorDTO update(@NotNull @Positive Long idProfessor, @Valid @NotNull SetorDTO SetorDTO) {
        return SetorRepository.findById(idProfessor)
                .map(recordFound -> {
                    recordFound.setNameProf(SetorDTO.nameProf());
                    recordFound.setTelefone(SetorDTO.telefone());
                    recordFound.setEmail(SetorDTO.email());
                    recordFound.setEndereco(SetorDTO.endereco());
                    recordFound.setSalario(SetorDTO.salario());
                    return SetorMapper.toDTO(SetorRepository.save(recordFound));
                }).orElseThrow(() -> new RecordNotFoundException(idProfessor));
    }

    public void delete(@PathVariable @NotNull @Positive Long idProfessor) {
        SetorRepository.delete(SetorRepository.findById(idProfessor)
                .orElseThrow(() -> new RecordNotFoundException(idProfessor)));
    }
}


