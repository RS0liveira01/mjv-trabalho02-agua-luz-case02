package pessoa;

import errors.InvalidCnpjException;
import errors.InvalidRgException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PessoaJuridica extends Pessoa {

    private String cnpj;

    public PessoaJuridica(String[] dados) {
        super(dados[1]);

        this.cnpj = this.validarCnpj(dados[0]);
    }

    private String validarCnpj(String cnpj) {
        if (cnpj.isEmpty()) {
            throw new InvalidCnpjException();
        }

        if (cnpj.length() < 18) {
            throw new InvalidRgException();
        }

        if (cnpj.length() > 18) {
            throw new InvalidRgException();
        }

        Pattern padrao = Pattern.compile("[0-9.-/-]*");
        Matcher regex = padrao.matcher(cnpj);
        if (!regex.matches()) {
            throw new InvalidRgException();
        }

        return cnpj;
    }


    public String getCnpj() {
        return cnpj;
    }
}
