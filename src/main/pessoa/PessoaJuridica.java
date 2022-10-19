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

        if (cnpj.length() != 16) {
            throw new InvalidRgException();
        }

        Pattern padrao = Pattern.compile("[0-9]*");
        Matcher regex = padrao.matcher(cnpj);
        if (!regex.matches()) {
            throw new InvalidRgException();
        }

        String cnpjPrimeiraSerie = cnpj.substring(0, 2);
        String cnpjSegundaSerie = cnpj.substring(2, 5);
        String cnpjTerceiraSerie = cnpj.substring(5, 8);
        String cnpjPosBarra = cnpj.substring(8, 12);
        String cnpjDigito = cnpj.substring(13);

        String cnpjFormatado = (
                cnpjPrimeiraSerie
                + "."
                + cnpjSegundaSerie
                + "."
                + cnpjTerceiraSerie
                + "/"
                + cnpjPosBarra
                + "-"
                + cnpjDigito
        );

        return cnpjFormatado;
    }


    public String getCnpj() {
        return cnpj;
    }
}
