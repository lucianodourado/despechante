package br.mp.mpm.despachante.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.mp.mpm.despachante.model.PessoaInterno;
import br.mp.mpm.despachante.model.PessoaRemovida;

public interface PessoaInternoRepository  extends JpaRepository<PessoaInterno, Long> {

	@Query("select s from PessoaInterno s where (cast(s.matricula as string) + s.nomeCivil + cast(s.cpf as string)) like %:filtro% ")
	List<PessoaInterno> findByFiltro(@Param("filtro") String filtro);
	
	@Query("select s from PessoaInterno s where (cast(s.matricula as string) + s.nomeCivil + cast(s.cpf as string)) like %:filtro% ")
	Page<PessoaInterno> findByFiltro(@Param("filtro") String filtro, Pageable paginacao);
	
	@Query("select s from PessoaInterno s where s.matricula = :matricula ")
	PessoaRemovida findByMatricula(@Param("matricula") BigInteger matricula);
	
}
