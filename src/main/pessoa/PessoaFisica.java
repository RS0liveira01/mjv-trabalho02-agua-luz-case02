package pessoa;

import errors.InvalidCpfException;
import errors.InvalidRgException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PessoaFisica extends Pessoa {
    public String cpf;
    public String rg;

    public PessoaFisica(String[] dados) {
        super(dados[2]);

        this.cpf = this.validarCpf(dados[0]);
        this.rg = this.validarRg(dados[1]);
    }

    private String validarCpf(String cpf) {
        if (cpf.isEmpty()) {
            throw new InvalidCpfException();
        }

        if (cpf.length() > 14) {
            throw new InvalidCpfException();
        }

        if (cpf.length() < 14){
            throw new InvalidCpfException();
        }

        Pattern padrao = Pattern.compile("[0-9.--]*");
        Matcher regex = padrao.matcher(cpf);
        if (!regex.matches()) {
            throw new InvalidCpfException();
        }

        return cpf;
    }

    private String validarRg(String rg) {
        if (rg.isEmpty()) {
            throw new InvalidRgException();
        }

        if (rg.length() >8) {
            throw new InvalidRgException();
        }

        if (rg.length() <8) {
            throw new InvalidRgException();
        }

        Pattern padrao = Pattern.compile("[0-9.--]*");
        Matcher regex = padrao.matcher(cpf);
        if (!regex.matches()) {
            throw new InvalidRgException();
        }

        return rg;
    }

    public String getCpf() { return cpf; }

    public String getRg(){ return rg; }
}


