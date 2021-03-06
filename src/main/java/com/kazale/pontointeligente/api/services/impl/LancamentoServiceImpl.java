package com.kazale.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.kazale.pontointeligente.api.entities.Lancamento;
import com.kazale.pontointeligente.api.repositories.LancamentoRepository;
import com.kazale.pontointeligente.api.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService{
	
	private static final Logger log=LoggerFactory.getLogger(LancamentoServiceImpl.class);
	
	@Autowired
	private LancamentoRepository lancamentoRepository;


	public Page<Lancamento> buscarPorFuncionarioID(Long funcionarioId,
			PageRequest pageRequest) {			
			log.info("Busncado lancamentos para o funcionario ID{}", funcionarioId);
			return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);		
	}

	
	public Optional<Lancamento> buscarPorId(Long id) {
		log.info("Buscando um lancamento polo ID{}", id);
		return this.lancamentoRepository.findById(id);
	}


	public Lancamento persistir(Lancamento lancamento) {
		log.info("Persistindo um lancamento:{}", lancamento);
		return this.lancamentoRepository.save(lancamento);
	}


	public void remover(Long id) {
		log.info("Removento o lancamento ID{}", id);
		this.lancamentoRepository.deleteById(id);
		//analisar caso der erro
	}
	
	
	
}
