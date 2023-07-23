package com.loiane.dto.mapper;

import com.loiane.dto.SetorDTO;
import com.loiane.model.Setor;

public class SetorMapper {

    public SetorDTO toDTO(Setor setor) {
        if (setor == null) {
            return null;
        }
        return new SetorDTO(setor.getId(), setor.getSetor());
    }

    public Setor toEntity(SetorDTO setorDTO) {

        if (setorDTO == null) {
            return null;
        }

        Setor setor = new Setor();
        if (setorDTO.id() != null) {
            setor.setId(setorDTO.id());
        }
        setor.setId(setorDTO.id());
        setor.setSetor(setorDTO.setor());

        return setor;
    }
}


