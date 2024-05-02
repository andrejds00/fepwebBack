package com.sinqia.fepweb.management.controller;

import com.sinqia.fepweb.management.domain.Participante;
import com.sinqia.fepweb.management.dto.ParticipanteDTO;
import com.sinqia.fepweb.management.service.ParticipanteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/participante")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    @PostMapping("/inserir")
    @ResponseStatus(HttpStatus.CREATED)
    public Participante criarParticipante(@RequestBody ParticipanteDTO participanteDTO) {

        return participanteService.registration(participanteDTO);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Participante atualizarParticipante(@RequestBody ParticipanteDTO participanteDTO, @PathVariable Long id) {

        return participanteService.participanteUpdate(participanteDTO.toDomain(), id);
    }

    @GetMapping
    public List<Participante> findAll() {
        return participanteService.getParticipantes();
    }

    @GetMapping("/{id}")
    public List<Participante> findById(@PathVariable Long id) {
        return participanteService.getParticipantesById(id);
    }

    @GetMapping("/cpf")
    public List<Participante> findByDocument(@RequestParam("cpf") String cpfCnpj) {
        return participanteService.getParticipantesByCpfCnpj(cpfCnpj);
    }

    @GetMapping("/nome")
    public List<Participante> findByName(@RequestParam("nome") String name) {
        return participanteService.getParticipantesByName(name);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        participanteService.deleteParticipante(id);

        return null;
    }
}
