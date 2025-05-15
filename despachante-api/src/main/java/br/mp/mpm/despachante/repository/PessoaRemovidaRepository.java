package br.mp.mpm.despachante.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.mp.mpm.despachante.model.PessoaRemovida;

public interface PessoaRemovidaRepository extends JpaRepository<PessoaRemovida, Long> {
	
	@Query("select s from PessoaRemovida s where s.matricula = :matricula ")
	PessoaRemovida findByMatricula(@Param("matricula") BigInteger matricula);

}
