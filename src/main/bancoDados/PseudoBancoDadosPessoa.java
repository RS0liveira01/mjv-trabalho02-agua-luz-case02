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

    public PessoaFisica getPessoaFisicaPorCpf(String cpf) {
        for(int i = 0; i < this.pessoas.size(); i++)
            if(this.pessoas.get(i) instanceof PessoaFisica) {
                PessoaFisica pessoaFisica = (PessoaFisica) this.pessoas.get(i);

                if(Objects.equals(pessoaFisica.getCpf(), cpf))
                    return pessoaFisica;
            }

        throw new PessoaNotFoundException();
    }

    public PessoaFisica getPessoaFisicaPorRG(String rg) {
        for(int i = 0; i < this.pessoas.size(); i++)
            if(this.pessoas.get(i) instanceof PessoaFisica) {
                PessoaFisica pessoaFisica = (PessoaFisica) this.pessoas.get(i);

                if(Objects.equals(pessoaFisica.getRg(), rg))
                    return pessoaFisica;
            }

        throw new PessoaNotFoundException();
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }
}
