package pessoa;

public class Contrato {

    private Endereco[];
    private String protocolo;
    private FUSOHORARIO fusoHorario;
    private TIPOSERVICO tipoServico;
    private TIPONOTIFICACAO tipoNotificacao;

    protected Contrato(String[] cadastro){
        // a fazer..

    }

    private String validarProtocolo(String protocolo) {
        return "a fazer...";
    }

    private String determinarFusoHorario(enum fusoHorario) {
        return "a fazer...";
    }

    private String validarDataHora(String[] dataHora) {
        return "a fazer...";
    }

    private String validarTipoServico(String tipoServico) {
        return "a fazer...";
    }

    private String validarTipoNotificacao(String tipoNotificacao) {
        return "a fazer...";
    }

    private String registrarEndereco(String[] dados) {
        return "a fazer...";
    }
    
}

