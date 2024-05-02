package com.sinqia.fepweb.management.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_participante")
@Getter
@Setter
public class Participante {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "participante_seq")
    @SequenceGenerator(name = "participante_seq", sequenceName = "participante_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "cod_externo")
    private Long codExterno;

    @Column(name = "cpf_cnpj")
    private String cpfCnpj;

    @Column(name = "documento")
    private String documento;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "estado_civil")
    private String estadoCivil;

    @Column(name = "telefone1")
    private String telefone1;

    @Column(name = "telefone2")
    private String telefone2;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "ativa")
    private boolean ativa;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    public Participante() {
    }

    public Participante(Long codExterno, String cpfCnpj, String documento, String nome, String email, String sexo, String estadoCivil, String telefone1, String telefone2, LocalDate dataNascimento, boolean ativa, LocalDate dataCadastro) {
        this.codExterno = codExterno;
        this.cpfCnpj = cpfCnpj;
        this.documento = documento;
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.dataNascimento = dataNascimento;
        this.ativa = ativa;
        this.dataCadastro = dataCadastro;
    }
}
