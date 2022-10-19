package pessoa;

import java.util.ArrayList;
import java.util.Arrays;

import errors.InvalidNomeException;

public abstract class Pessoa {
	private String nome;
	private ArrayList<Telefone> telefones;
	private ArrayList<Contrato> contratos;

	protected Pessoa(String nome) {
		this.nome = validarNome(nome);
		this.telefones = new ArrayList<Telefone>();
		this.contratos = new ArrayList<Contrato>()
	}

	private String validarNome(String nome) {
		if(nome.isEmpty()){
			throw new InvalidNomeException();
		}

		if (nome.length() > 50) {
			throw new InvalidNomeException();
		}

		if(!nome.matches("[a-zA-Z ]+")){
			throw new InvalidNomeException();
		}

		return UtilString.tratarNominal(nome);
	}

	public void registrarContrato(String[] dados) {
		this.registrarTelefone(dados[0]);

		Contrato contrato = new Contrato (Arrays.copyOfRange(dados,1, 14));
		this.contratos.add(contrato);
	}
	public void registrarTelefone(String telefone) {
		Telefone novoTelefone = new Telefone (telefone);
		this.telefones.add(novoTelefone);
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
