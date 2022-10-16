package pessoa;

import java.time.LocalDateTime;

public class Contrato {

    private Endereco endereco;
    private String protocolo;
    private LocalDateTime dataHora;
    private FUSOHORARIO fusoHorario;
    private TIPOSERVICO tipoServico;
    private TIPONOTIFICACAO tipoNotificacao;

    protected Contrato(String[] cadastro) {
        // a fazer...
    }

    private String validarProtocolo(String protocolo) {
        return "a fazer...";
    }

    private LocalDateTime validarDataHora(String[] dataHora) {
        return LocalDateTime.now();
    }

    private FUSOHORARIO determinarFusoHorario(String pais) {
        return FUSOHORARIO.BR;
    }

    private TIPOSERVICO validarTipoServico(String tipoServico) {
        return TIPOSERVICO.AGUA;
    }

    private TIPONOTIFICACAO validarTipoNotificacao(String tipoNotificacao) { return TIPONOTIFICACAO.SMS; }
}
