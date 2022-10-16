package pessoa;

public class PessoaJuridica extends Pessoa {

    private String cnpj;

    public PessoaJuridica(String[] dados) {
        super(dados[1]);
        // A fazer...
    }

    private String validarCnpj(String cnpj) { return "A fazer..."; }

    public String getCnpj() {
        return cnpj;
    }
}
