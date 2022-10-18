package bancoDados;

import errors.PessoaNotFoundException;
import pessoa.Pessoa;
import pessoa.PessoaFisica;
import pessoa.PessoaJuridica;

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

    public PessoaJuridica getPessoaFisicaPorCnpj(String cnpj) {
        for(int i = 0; i < this.pessoas.size(); i++)
            if(this.pessoas.get(i) instanceof PessoaJuridica) {
                PessoaJuridica pessoaJuridica = (PessoaJuridica) this.pessoas.get(i);

                if(Objects.equals(pessoaJuridica.getCnpj(), cnpj))
                    return pessoaJuridica;
            }

        throw new PessoaNotFoundException();
    }

    private void validarDuplicidadePessoaFisica(PessoaFisica novaPessoaFisica) {
        this.pessoas.forEach((pessoa) -> {
            if (pessoa instanceof PessoaFisica) {
                PessoaFisica pessoaFisica = (PessoaFisica) pessoa;

                if (Objects.equals(pessoaFisica.getCpf(), novaPessoaFisica.getCpf()))
                    throw new DuplicatedCpfException();

                if (Objects.equals(pessoaFisica.getRg(), novaPessoaFisica.getRg()))
                    throw new DuplicatedRgException();
            }
        }
    }
    public ArrayList<Pessoa> getPessoas() {
        return this.pessoas;
    }
}
