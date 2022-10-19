package pessoa;

import java.time.LocalDateTime;

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

	protected Contrato(String[] dados) {
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
