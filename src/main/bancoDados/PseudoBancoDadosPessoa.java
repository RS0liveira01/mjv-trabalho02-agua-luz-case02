package bancoDados;

import errors.PessoaNotFoundException;
import pessoa.Pessoa;
import pessoa.PessoaFisica;

import java.util.ArrayList;
import java.util.Objects;

public class PseudoBancoDadosPessoa {
    ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

    public void registrarPessoa(Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }

    public Pessoa getPessoaPorNome(String nome) {
        // Perguntar porque equals e não ==
        for(int i = 0; i < this.pessoas.size(); i++)
            if(Objects.equals(this.pessoas.get(i).getNome(), nome))
                return this.pessoas.get(i);

        throw new PessoaNotFoundException();
    }

        return this.pessoas.get(indicePesquisa);
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }
}
