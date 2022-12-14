package pessoa;

import errors.InvalidCnpjException;
import errors.InvalidRgException;

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

        if (cnpj.length() != 14) {
            throw new InvalidRgException();
        }

        if (!cnpj.matches("[0-9]*")) {
            throw new InvalidRgException();
        }

        String cnpjPrimeiraSerie = cnpj.substring(0, 2);
        String cnpjSegundaSerie = cnpj.substring(3, 5);
        String cnpjTerceiraSerie = cnpj.substring(6, 8);
        String cnpjPosBarra = cnpj.substring(9, 12);
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
