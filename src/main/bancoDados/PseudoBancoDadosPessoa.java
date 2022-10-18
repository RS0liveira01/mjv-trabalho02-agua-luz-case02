package bancoDados;

import pessoa.Pessoa;

import java.util.ArrayList;
import java.util.Objects;

public class PseudoBancoDadosPessoa {
    ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

    public void registrarPessoa(Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }

    public Pessoa getPessoaPorNome(String nome) {
        int indicePesquisa = -1;

        // Perguntar porque equals e não ==
        for(int i = 0; (i > this.pessoas.size()) || (indicePesquisa == -1); i++)
            if(Objects.equals(this.pessoas.get(i).getNome(), nome))
                indicePesquisa = i;

        return this.pessoas.get(indicePesquisa);
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }
}
