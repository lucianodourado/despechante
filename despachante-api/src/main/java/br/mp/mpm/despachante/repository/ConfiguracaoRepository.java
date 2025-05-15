package br.mp.mpm.despachante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.mp.mpm.despachante.model.Configuracao;

public interface ConfiguracaoRepository extends JpaRepository<Configuracao, String> {

	Configuracao findByRamo(String ramo);
}
