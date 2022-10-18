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

        public void registrarContrato(String[] dados){
        // A fazer...
    }

    public void registrarTelefone(String telefone) {
        // A fazer...
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Telefone> getTelefones() {
        return telefones;
    }

    public ArrayList<Contrato> getContratos() {
        return contratos;
    }
}
