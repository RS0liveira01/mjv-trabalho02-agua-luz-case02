package pessoa;

import errors.InvalidDddNumberException;
import errors.InvalidPhoneNumberException;
import utils.ENumero;

public class Telefone {
    private String ddd;
    private String numero;

    public Telefone(String telefone) {
        String ddd = telefone.substring(0, 2);
        this.ddd = validarDdd(ddd);

        String numero = telefone.substring(2);
        this.numero = validarNumero(numero);
    }

    private String validarDdd(String ddd) {
        //Checagem de mais de dois digitos
        if(ddd.length() != 2) {
            throw new InvalidDddNumberException();
        }

        //Checagem se o DDD só possui números
        if(!ENumero.verificaString(ddd)) {
            throw new InvalidDddNumberException();
        }



        return "(" + ddd + ")";
    }

    private String validarNumero(String numero) {
        //Checagem se o número só possui números
        if(!ENumero.verificaString(numero)) {
            throw new InvalidPhoneNumberException();
        }

        //Checagem de mais de 8 ou 9 dígitos e retorna o valro formatado
        switch(numero.length()) {
            case 9:
                return (
                        numero.substring(0, 5)
                        + "-"
                        + numero.substring(6)
                );

            case 8:
                return (
                        numero.substring(0, 4)
                                + "-"
                                + numero.substring(5)
                );

            default:
                throw new InvalidPhoneNumberException();
        }
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }
}

