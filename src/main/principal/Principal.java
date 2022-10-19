package principal;

import pessoa.Telefone;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import static java.time.format.DateTimeFormatter.ofPattern;

public class Principal {
    public static void main(String[] args) {
        String strDate = "07/23/1995";
        String dateFormat = "dd/MM/uuuu";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern(dateFormat)
                .withResolverStyle(ResolverStyle.STRICT);

        try {
            LocalDate date = LocalDate.parse(strDate, dateTimeFormatter);
            System.out.println("deu certo");;
        } catch (DateTimeParseException e) {
            System.out.println("data invalida");;

        }

    }



}

