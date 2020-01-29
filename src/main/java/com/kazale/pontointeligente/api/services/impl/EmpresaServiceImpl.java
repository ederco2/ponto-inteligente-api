package com.kazale.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kazale.pontointeligente.api.entities.Empresa;
import com.kazale.pontointeligente.api.repositories.EmpresaRepository;
import com.kazale.pontointeligente.api.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService{
	
		private static final Logger log= LoggerFactory.getLogger(EmpresaServiceImpl.class);
		
		@Autowired
		private EmpresaRepository empresaRepository;
		
		@Override
		public Optional<Empresa> buscarporCnpj(String cnpj){
			log.info("Biscando empresa para o CPNJ:{} ",cnpj);
			return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
		}		
		
		@Override
		public Empresa persistir(Empresa empresa) {
			log.info("Persistindo empresa:{} ",empresa);
			return this.empresaRepository.save(empresa);
		}
}
