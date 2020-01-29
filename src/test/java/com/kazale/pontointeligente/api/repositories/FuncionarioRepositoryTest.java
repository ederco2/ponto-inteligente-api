package com.kazale.pontointeligente.api.repositories;

import static org.junit.Assert.assertNotNull;

import java.security.NoSuchAlgorithmException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.kazale.pontointeligente.api.entities.Empresa;
import com.kazale.pontointeligente.api.entities.Funcionario;
import com.kazale.pontointeligente.api.enums.PerfilEnum;
import com.kazale.pontointeligente.api.utils.PasswordUtils;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioRepositoryTest {
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	private static final String EMAIL= "email@emal.com";
	private static final String cpf ="04371939933";
	
	@Before
	public void setUp() throws Exception{
		Empresa empresa= this.empresaRepository.save(obterDadosEmpresa());
		this.funcionarioRepository.save(obterDadosFuncionario(empresa));
	}
	
	@After
	public final void tearDown() {
		this.empresaRepository.deleteAll();
	}
	
	@Test
	public void testBuscarFuncionarioPorEmail() {
		Funcionario funcionario = this.funcionarioRepository.findByEmail(EMAIL);
		
		assertEquals(EMAIL, funcionario.getEmail());
	}
		
	
	@Test
	public void testBuscarFuncionarioPorCpf() {
		Funcionario funcionario = this.funcionarioRepository.findByCpf(cpf);
			
		assertEquals(cpf, funcionario.getCpf());
	}	
	
	@Test
	public void testBuscarFuncionarioPorEmailECpf() {
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(cpf,EMAIL);
			
		assertNotNull(funcionario);
	}	
	
	@Test
	public void testBuscarFuncionarioPorEmailOuCpfParaCPFInvalido() {
		Funcionario funcionario=this.funcionarioRepository.findByCpfOrEmail(cpf, "email@invalido.com");
	
		assertNotNull(funcionario);
	}
	
	@Test
	public void testBuscarFuncionarioPorEmailECpfParaCPFInvalido() {
		Funcionario funcionario=this.funcionarioRepository.findByCpfOrEmail("04371939937", EMAIL);
	
		assertNotNull(funcionario);
	}
	
	private Funcionario obterDadosFuncionario(Empresa empresa) throws NoSuchAlgorithmException{
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Fulano de Tal");
		funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
		funcionario.setSenha(PasswordUtils.gerarBCryt("123456"));
		funcionario.setCpf(cpf);
		funcionario.setEmail(EMAIL);
		funcionario.setEmpresa(empresa);
		return funcionario;
	}
	private Empresa obterDadosEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Empresa de Exemplo");
		empresa.setCnpj("22583574000172");
		return empresa;
		
	}
}
