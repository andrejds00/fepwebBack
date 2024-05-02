package com.sinqia.fepweb.management.service;

import com.sinqia.fepweb.management.builder.EnderecoBuilder;
import com.sinqia.fepweb.management.domain.Endereco;
import com.sinqia.fepweb.management.domain.Participante;
import com.sinqia.fepweb.management.dto.ParticipanteDTO;
import com.sinqia.fepweb.management.repository.ParticipanteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipanteService {

    private final Logger log = LoggerFactory.getLogger(ParticipanteService.class);

    @Autowired
    private ParticipanteRepository participanteRepository;
    @Autowired
    private EnderecoBuilder enderecoBuilder;

    @Transactional
    public Participante registration(ParticipanteDTO participanteDTO) {

        log.info("Registrando Dados do participante: [{}]", participanteDTO);

        var participante = participanteDTO.toDomain();
        participante.setEndereco(enderecoBuilder.build(participanteDTO));

        if (participanteRepository.findOneByCpfCnpj(participante.getCpfCnpj()) != null) {
            throw new RuntimeException("Participante já cadastrado na base com esse CPF");
        } else {
            return participanteRepository.save(participante);
        }
    }

    @Transactional
    public Participante participanteUpdate(Participante participante, Long id) {
        log.info("Atualizando Dados do participante: [{}]", id);
        Optional<Participante> optional = participanteRepository.findById(id);

        if (optional.isPresent()) {
            participante.setId(optional.get().getId());
            return participanteRepository.save(participante);
        } else {
            throw new RuntimeException("Participante não localizado na base de dados");
        }
    }

    public List<Participante> getParticipantes() {
        return participanteRepository.findAll();
    }

    public List<Participante> getParticipantesById(Long id) {
        log.debug("Retornado como list para o front ter só um método de busca");
        return Arrays.asList(participanteRepository.findById(id).get());
    }

    public List<Participante> getParticipantesByCpfCnpj(String cpfCnpj) {
        log.debug("Retornado como list para o front ter só um método de busca");
        return Arrays.asList(participanteRepository.findOneByCpfCnpj(cpfCnpj.trim()));
    }

    public List<Participante> getParticipantesByName(String name) {
        return participanteRepository.findAllByNomeLikeIgnoreCase("%" + name.trim() + "%");
    }

    @Transactional
    public void deleteParticipante(Long id) {
        Optional<Participante> optional = participanteRepository.findById(id);

        if (optional.isPresent()) {
            participanteRepository.delete(optional.get());
        } else {
            throw new RuntimeException("Participante não localizado na base de dados");
        }
    }
}
