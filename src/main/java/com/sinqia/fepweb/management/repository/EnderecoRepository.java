package com.sinqia.fepweb.management.repository;

import com.sinqia.fepweb.management.domain.Endereco;
import com.sinqia.fepweb.management.domain.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
