package pessoa;

import errors.InvalidProtocolException;
import utils.ENumero;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Contrato {

    private Endereco endereco;
    private String protocolo;
    private LocalDateTime dataHora;
    private FUSOHORARIO fusoHorario;
    private TIPOSERVICO tipoServico;
    private TIPONOTIFICACAO tipoNotificacao;

	public Contrato(String[] dados) {
        this.endereco = new Endereco(Arrays.copyOfRange(dados, 0, 7));
        this.protocolo = validarProtocolo(dados[7]);
        this.dataHora = validarDataHora(dados[8], dados[9]);
        this.fusoHorario = FUSOHORARIO.valueOf(dados[7]);
        this.tipoServico = TIPOSERVICO.valueOf(dados[10]);
        this.tipoNotificacao = TIPONOTIFICACAO.valueOf(dados[12]);
    }

    private String validarProtocolo(String protocolo) {

        //validar se protocolo possui 7 digitos
        if(protocolo.length() != 7) {
            throw new InvalidProtocolException();
        }

        //validar se protocolo possui somente numeros
        if(!ENumero.verificaString(protocolo)) {
            throw new InvalidProtocolException();
        }

        return protocolo;
    }

    private LocalDateTime validarDataHora(String data, String hora) {
        /*
        //validar se hora e minutos são válidos

        //validar se o formato de data é valido
        String strDate = String.valueOf(dataHora);
        String dateFormat = "dd/MM/uuuu";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern(dateFormat)
                .withResolverStyle(ResolverStyle.STRICT);

        try {
            LocalDate date = LocalDate.parse(strDate, dateTimeFormatter);
        } catch (DateTimeParseException e) {
            throw new InvalidDateFormatException();
        }
        */

        return LocalDateTime.now();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public FUSOHORARIO getFusoHorario() {
        return fusoHorario;
    }

    public TIPOSERVICO getTipoServico() {
        return tipoServico;
    }

    public TIPONOTIFICACAO getTipoNotificacao() {
        return tipoNotificacao;
    }
}
