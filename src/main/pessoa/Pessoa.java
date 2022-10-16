package pessoa;

import java.util.ArrayList;

public abstract class Pessoa {
    private String nome;
    private ArrayList<Telefone> telefones;
    private ArrayList<Contrato> contratos;

    protected Pessoa(String nome) {
        this.nome = validarNome(nome);
    }

    private String validarNome(String nome) {
        return "a fazer...";
    }

    protected void registrarContrato(String[] dados){
        // A fazer...
    }

    protected void registrarTelefone(String telefone) {
        // A fazer...
    }





}
