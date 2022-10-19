package pessoa;

public class Endereco {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private PAIS pais;

    protected Endereco(String[] dados) {
        // a fazer...
    }

    private String validarNumero(String numero) {
        return "a fazer...";
    }

    private String validarCep(String cep) {
        return "a fazer...";
    }

    private String validarUf(String uf) {
        return "a fazer...";
    }

    private PAIS validarPais(String pais) {
        return PAIS.BR;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }

    public PAIS getPais() {
        return pais;
    }

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setPais(PAIS pais) {
		this.pais = pais;
	}
}
