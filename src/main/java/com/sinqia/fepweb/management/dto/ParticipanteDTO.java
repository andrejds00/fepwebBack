package com.sinqia.fepweb.management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinqia.fepweb.management.domain.Endereco;
import com.sinqia.fepweb.management.domain.Participante;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class ParticipanteDTO {

    @JsonProperty("codExterno")
    private Long codExterno;

    @JsonProperty("cpfCnpj")
    private String cpfCnpj;

    @JsonProperty("documento")
    private String documento;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("email")
    private String email;

    @JsonProperty("sexo")
    private String sexo;

    @JsonProperty("estadoCivil")
    private String estadoCivil;

    @JsonProperty("telefone1")
    private String telefone1;

    @JsonProperty("telefone2")
    private String telefone2;

    @JsonProperty("dataNascimento")
    private LocalDate dataNascimento;

    @JsonProperty("ativa")
    private boolean ativa;

    @JsonProperty("dataCadastro")
    private LocalDate dataCadastro;

    @JsonProperty("endereco")
    private Endereco endereco;

    public Participante toDomain() {
        return new Participante(codExterno, cpfCnpj, documento, nome.toUpperCase(), email, sexo, estadoCivil, telefone1, telefone2, dataNascimento, ativa, dataCadastro);
    }

}
