package com.kazale.pontointeligente.api.services;


import java.util.Optional;

import com.kazale.pontointeligente.api.entities.Funcionario;

public interface FuncionarioService {
	
	/**
	 * Persiste um funcionario na base de dados
	 * 
	 * @param funcionario
	 * @return Funcionario
	 */
	Funcionario persistir(Funcionario funcionario);
	
	/**
	 * Busca e retirna um funcionario dado um cpf
	 * @param cpf
	 * return optional <Funcionario>
	 */
	
	Optional<Funcionario> buscarPorCpf(String cpf);
	
	/**
	 * Busca e retirna um funcioanrio dado um email.
	 * @param email
	 * return Optinal<funcionario>
	 */
	Optional<Funcionario> buscarPorEmail(String email);
	/**
	 * busca e retorna um funcionario por ID.
	 * 
	 * @param id
	 * @return Optinal <Funcionario>
	 */
	Optional<Funcionario> buscarPorId(Long id);
}
