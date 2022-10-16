package pessoa;

public class PessoaFisica extends Pessoa {
    private String cpf;
    private String rg;

    public PessoaFisica(String[] dados) {
        super(dados[2]);
        // A fazer...
    }

    private String validarCpf(String cpf) {
        return "a fazer...";
    }

    private String validarRg(String rg) {
        return "a fazer...";
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }
}
