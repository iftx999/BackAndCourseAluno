package com.loiane.service;

import com.loiane.dto.SetorDTO;
import com.loiane.dto.mapper.SetorMapper;
import com.loiane.exception.RecordNotFoundException;
import com.loiane.repository.SetorRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Validated
@Service
public class SetorService {

    @Autowired
    private SetorRepository setorRepository;
    @Autowired
    private SetorMapper setorMapper;

    public SetorService(SetorRepository setorRepository, SetorMapper setorMapper) {
        this.setorRepository = setorRepository;
        this.setorMapper = setorMapper;
    }

    public List<SetorDTO> list() {
        return setorRepository.findAll()
                .stream()
                .map(setorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SetorDTO findById(@PathVariable @NotNull @Positive Long id) {
        return setorRepository.findById(id).map(setorMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public SetorDTO create(@Valid @NotNull SetorDTO setorDTO) {
        SetorDTO dto = setorMapper.toDTO(setorRepository.save(setorMapper.toEntity(setorDTO)));
        return dto;
    }

    public SetorDTO update(@NotNull @Positive Long id, @Valid @NotNull SetorDTO setorDTO) {
        return setorRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setSetorName(setorDTO.setorName());

                    return setorMapper.toDTO(setorRepository.save(recordFound));
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable @NotNull @Positive Long id) {
        setorRepository.delete(setorRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}


