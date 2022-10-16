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
}
