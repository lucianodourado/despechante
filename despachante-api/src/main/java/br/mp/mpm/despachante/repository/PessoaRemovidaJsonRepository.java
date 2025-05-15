package br.mp.mpm.despachante.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.mp.mpm.despachante.model.PessoaRemovidaJson;

public interface PessoaRemovidaJsonRepository extends JpaRepository<PessoaRemovidaJson, String> {

	PessoaRemovidaJson findByCpf(String cpf);	
		
	@Query("select s from PessoaRemovidaJson s where (cast(s.matricula as string) + s.nome + cast(s.cpf as string)) like %:filtro% ")
	List<PessoaRemovidaJson> findByFiltro(@Param("filtro") String filtro);
	
	@Query("select s from PessoaRemovidaJson s where (cast(s.matricula as string) + s.nome + cast(s.cpf as string)) like %:filtro% ")
	Page<PessoaRemovidaJson> findByFiltro(@Param("filtro") String filtro, Pageable paginacao);
	
}
