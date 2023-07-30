package com.loiane.dto.mapper;

import com.loiane.dto.SetorDTO;
import com.loiane.model.Setor;

public class SetorMapper {

    public SetorDTO toDTO(Setor setor) {
        if (setor == null) {
            return null;
        }
        return new SetorDTO(setor.getIdSetor(), setor.getSetorName());
    }

    public Setor toEntity(SetorDTO setorDTO) {

        if (setorDTO == null) {
            return null;
        }

        Setor setor = new Setor();
        if (setorDTO.idSetor() != null) {
            setor.setIdSetor(setorDTO.idSetor());
        }
        setor.setIdSetor(setorDTO.idSetor());
        setor.setSetorName(setorDTO.setorName());

        return setor;
    }
}


