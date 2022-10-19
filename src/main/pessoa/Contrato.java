package pessoa;

import errors.InvalidDateFormatException;
import errors.InvalidProtocolException;
import utils.ENumero;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Arrays;

public class Contrato {

    private Endereco endereco;
    private String protocolo;
    private LocalDateTime dataHora;
    private FUSOHORARIO fusoHorario;
    private TIPOSERVICO tipoServico;
    private TIPONOTIFICACAO tipoNotificacao;

	public Contrato(String[] dados) {
        this.endereco = new Endereco(Arrays.copyOfRange(dados, 0, 8));
        this.protocolo = validarProtocolo(dados[7]);
        this.fusoHorario = FUSOHORARIO.valueOf(dados[7]);
        this.dataHora = validarDataHora(dados[8], dados[9]);
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

        return protocolo.replaceFirst("^0+(?!$)", "");
    }

    private LocalDateTime validarDataHora(String data, String hora) {
        String dia = data.substring(0, 2);
        String mes = data.substring(2, 4);
        String ano = data.substring(4);
        String horas = hora.substring(0, 2);
        String minutos = hora.substring(2);

        String dataFormatada = (
                dia
                + "-"
                + mes
                + "-"
                + ano
                + " "
                + horas
                + ":"
                + minutos
        );

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return LocalDateTime.parse(dataFormatada, formatador);
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

    public String dataHoraToSting() {
        return dataHora.toString().replace("T", " ");
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
