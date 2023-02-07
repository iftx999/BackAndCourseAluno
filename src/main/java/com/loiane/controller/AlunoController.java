package com.loiane.controller;

import com.loiane.dto.AlunoDTO;
import com.loiane.service.AlunoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public @ResponseBody List<AlunoDTO> list() {
        return alunoService.list();
    }

    @GetMapping("/{id}")
    public AlunoDTO findById(@PathVariable @NotNull @Positive Long id) {
        return alunoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AlunoDTO create(@RequestBody @Valid @NotNull AlunoDTO aluno) {
        return alunoService.create(aluno);
    }

    @PutMapping("/{id}")
    public AlunoDTO update(@PathVariable @NotNull @Positive Long id,
                           @RequestBody @Valid @NotNull AlunoDTO aluno) {
        return alunoService.update(id, aluno);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        alunoService.delete(id);
    }
}
