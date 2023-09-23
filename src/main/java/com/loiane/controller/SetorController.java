package com.loiane.controller;

import com.loiane.dto.SetorDTO;
import com.loiane.repository.SetorRepository;
import com.loiane.service.SetorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/setor")
public class SetorController {

    @Autowired
    private SetorService setorService;
    @Autowired
    private SetorRepository setorRepository;

    @GetMapping
    public @ResponseBody List<SetorDTO> list() {
        return setorService.list();
    }

    @GetMapping("/{id}")
    public SetorDTO findById(@PathVariable @NotNull @Positive Long idSetor) {
        return setorService.findById(idSetor);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public SetorDTO create(@RequestBody @Valid @NotNull SetorDTO setor) {
        return setorService.create(setor);
    }

    @PutMapping("/{id}")
    public SetorDTO update(@PathVariable @NotNull @Positive Long id,
                           @RequestBody @Valid @NotNull SetorDTO setor)
    {
        return setorService.update(id, setor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        setorService.delete(id);
    }
}


