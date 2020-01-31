package com.kazale.pontointeligente.api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.kazale.pontointeligente.api.entities.Lancamento;

public interface LancamentoService {

	/**
	 * Retorna uma lista paginada de lancamentos de um determinado funcionario.
	 * 
	 * @param funcioanrioId
	 * @param pageRequest
	 * @return Page <Lancamento>
	 */
	
	Page<Lancamento> buscarPorFuncionarioID(Long funcionarioId, PageRequest pageRequest);
	
	/**
	 * Retorba um lancamento por ID
	 * 
	 * @Param id
	 * @return Optional<Lancamento>
	 */
	
	Optional<Lancamento> buscarPorId(Long id);
	
	/**
	 * Persiste um lancamento na base de dados
	 * 
	 * @param lancamento
	 * return Lancamento
	 *
	 */
	
	Lancamento persistir(Lancamento lancamento);
	
	/**
	 * Remove um lancamendo da base de dados
	 * 
	 * @param id
	 */
	void remover(Long id);
}
