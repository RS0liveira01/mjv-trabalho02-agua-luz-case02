package pessoa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pessoa.Telefone;

public abstract class Pessoa {
	private String nome;
	private ArrayList<Telefone> telefones;
	private ArrayList<Contrato> contratos;
	private Endereco endereco;
	private Contrato contrato;

	protected Pessoa(String nome) {
		this.nome = validarNome(nome);
	}

	private void validarNome(String nome) {
		if(nome.isBlank()|| nome.isEmpty()){
			throw new InvalidNomeException("Nome vazio ou em branco");
		}
		if (nome.length()> 36) {
			throw new InvalidNomeException("Valor supera tamanho permitido");
		}
		Pattern padrao = Pattern.compile("[a-zA-Z]*");
		Matcher regex = padrao.matcher(nome);
		if(!regex.matches()){
			throw new InvalidNomeException("O nome contém números ou caracteres especiais");
		}
	}

	protected void registrarContrato(String[] dados){
		this.registrarTelefone(dados[0]);
		
		endereco.setLogradouro(dados[1]);
		endereco.setNumero(dados[2]);	
		endereco.setComplemento(dados[3]);
		endereco.setBairro(dados[4]);
		endereco.setCidade(dados[5]);
		endereco.setUf(dados[6]);
		endereco.setCep(dados[7]);
		endereco.setPais(PAIS.valueOf(dados[8]));
		contrato.setProtocolo(dados[9]);
		contrato.setDataHora(LocalDateTime.now());
		contrato.setTipoServico(TIPOSERVICO.valueOf(dados[11]));
		contrato.setTipoNotificacao(TIPONOTIFICACAO.valueOf(dados[13]));
				
	}

	protected void registrarTelefone(String telefone) {
		
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Telefone> getTelefones() {
		return telefones;
	}

	public ArrayList<Contrato> getContratos() {
		return contratos;
	}
}
