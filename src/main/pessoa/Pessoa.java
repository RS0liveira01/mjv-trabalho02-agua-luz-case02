package pessoa;

import java.util.ArrayList;

public abstract class Pessoa {
    private String nome;
    private ArrayList<Telefone> telefone;
    private ArrayList<Contrato> contrato;

    protected Pessoa(String nome) {
        this.nome = validarNome(nome);
    }

    private String validarNome(String nome) {
        return "a fazer...";
    }

    protected void registrarContrato(String[] dados){

    }

    protected void registrarTelefone(String telefone) {

    }





}
