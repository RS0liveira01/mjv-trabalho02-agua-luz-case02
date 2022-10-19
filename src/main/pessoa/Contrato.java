package pessoa;

import errors.InvalidDateFormatException;
import errors.InvalidPhoneNumberException;
import errors.InvalidProtocolException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import static java.time.format.DateTimeFormatter.ofPattern;

public class Contrato {

    private Endereco endereco;
    private String protocolo;
    private LocalDateTime dataHora;
    private FUSOHORARIO fusoHorario;
    private TIPOSERVICO tipoServico;
    private TIPONOTIFICACAO tipoNotificacao;

    public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public void setFusoHorario(FUSOHORARIO fusoHorario) {
		this.fusoHorario = fusoHorario;
	}

	public void setTipoServico(TIPOSERVICO tipoServico) {
		this.tipoServico = tipoServico;
	}

	public void setTipoNotificacao(TIPONOTIFICACAO tipoNotificacao) {
		this.tipoNotificacao = tipoNotificacao;
	}

	public Contrato(String[] dados) {
        // a fazer...
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

    private LocalDateTime validarDataHora(String[] dataHora) {
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

        return LocalDateTime.now();
    }

    private FUSOHORARIO determinarFusoHorario(String pais) {

        private PAIS validarPais(String pais) {

            try {
                PAIS paisValido = PAIS.valueOf(pais);
                return paisValido;
            } catch (IllegalArgumentException ex) {
                throw new InvalidPaisException();
            }

        }




        return FUSOHORARIO.BR;
    }

    private TIPOSERVICO validarTipoServico(String tipoServico) {
        return TIPOSERVICO.AGUA;
    }

    private TIPONOTIFICACAO validarTipoNotificacao(String tipoNotificacao) { return TIPONOTIFICACAO.SMS; }

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
