package com.sinqia.fepweb.management.builder;

import com.sinqia.fepweb.management.domain.Endereco;
import com.sinqia.fepweb.management.dto.ParticipanteDTO;
import com.sinqia.fepweb.management.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoBuilder {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco build(ParticipanteDTO participanteDTO) {
        Endereco endereco = new Endereco();
        endereco.setCep(participanteDTO.getEndereco().getCep());
        endereco.setLogradouro(participanteDTO.getEndereco().getLogradouro());
        endereco.setNumero(participanteDTO.getEndereco().getNumero());
        endereco.setBairro(participanteDTO.getEndereco().getBairro());
        endereco.setUf(participanteDTO.getEndereco().getUf());
        endereco.setCidade(participanteDTO.getEndereco().getCidade());
        endereco.setComplemento(participanteDTO.getEndereco().getComplemento());
        endereco.setPontoReferencia(participanteDTO.getEndereco().getPontoReferencia());

        return enderecoRepository.save(endereco);
    }

}
