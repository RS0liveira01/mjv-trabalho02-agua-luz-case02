package pessoa;

import errors.InvalidCepException;
import errors.InvalidNumberException;
import errors.InvalidPaisException;
import errors.InvalidUfException;

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
        this.logradouro = UtilString.tratarNominal(dados[0]);
        this.numero = validarNumero(dados[1]);
        this.complemento = dados[2];
        this.bairro = UtilString.tratarNominal(dados[3]);
        this.cidade = UtilString.tratarNominal(dados[4]);
        this.uf = validarUf(dados[5]);
        this.cep = validarCep(dados[6]);
        this.pais = validarPais(dados[7]);
    }

    private String validarNumero(String numero) {
        if (!ENumero.verificaString(numero)) {
            throw new InvalidNumberException();
        };

        if (numero.length() > 6) {
            throw new InvalidNumberException();
        }

        return numero.replaceFirst("^0+(?!$)", "");
    }

    private String validarCep(String cep) {
        if (!ENumero.verificaString(cep)) {
            throw new InvalidCepException();
        };

        if (cep.length() > 8) {
            throw new InvalidCepException();
        }
        return cep;
    }

    private String validarUf(String uf) {
        if(!uf.matches("[a-zA-Z]*")) {
            throw new InvalidUfException();
        }

        if(uf.length() > 2) {
            throw new InvalidUfException();
        }

        return UtilString.tratarNominal(uf);
    }


    private PAIS validarPais(String pais) {
        try {
            PAIS paisValido = PAIS.valueOf(pais);
            return paisValido;
        } catch (IllegalArgumentException ex) {
           throw new InvalidPaisException();
        }

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
}
