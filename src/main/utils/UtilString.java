package utils;

import java.util.Objects;

public class UtilString {
    public static String tratarNominal(String nominal) {
        String[] partesNominal = nominal.toLowerCase().split(" ");
        StringBuilder nominalFormatado = new StringBuilder();

        for(String parteNominal : partesNominal)
            if(!Objects.equals(parteNominal, "de"))
                nominalFormatado.append(" " + primeiraLetraParaMaiuscula(parteNominal));
            else
                nominalFormatado.append(" " + parteNominal);

        return nominalFormatado.toString().substring(2);
    }

    private static String primeiraLetraParaMaiuscula(String palavra) {
        String palavraFormatada = palavra.substring(0, 1).toUpperCase();

        if(palavra.length() > 1)
            palavraFormatada += palavra.substring(2);

        return palavraFormatada;
    }
}
