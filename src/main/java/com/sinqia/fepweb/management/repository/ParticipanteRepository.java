package com.sinqia.fepweb.management.repository;

import com.sinqia.fepweb.management.domain.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

    Participante findOneByCpfCnpj(String cpfCnpj);

    List<Participante> findAllByNomeLikeIgnoreCase(String name);
}
