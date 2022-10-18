//Bev

package pessoa;

import errors.InvalidDddNumberException;
import errors.InvalidPhoneNumberException;

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

        return ddd;
    }

    private String validarNumero(String numero) {
        //Checagem de mais de 8 ou 9 dígitos
        if((numero.length() != 8) && (numero.length() != 9)) {
            throw new InvalidPhoneNumberException();
        }

        //Checagem se o número só possui números
        if(!ENumero.verificaString(numero)) {
            throw new InvalidPhoneNumberException();
        }

        return numero;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }
}

