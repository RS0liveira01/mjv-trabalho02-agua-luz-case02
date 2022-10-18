package bancoDados;

import errors.*;
import pessoa.Pessoa;
import pessoa.PessoaFisica;
import pessoa.PessoaJuridica;

import java.util.ArrayList;
import java.util.Objects;

public class PseudoBancoDadosPessoa {
    ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

    public void registrarPessoa(Pessoa novaPessoa) {
        if(novaPessoa instanceof PessoaFisica) {
            this.validarDuplicidadePessoaFisica((PessoaFisica) novaPessoa);
        } else if(novaPessoa instanceof PessoaJuridica) {
            this.validarDuplicidadePessoaFisica((PessoaFisica) novaPessoa);
        } else {
            throw new UnsuportedPessoaImplementationException();
        }

        this.pessoas.add(novaPessoa);
    }

    public Pessoa getPessoaPorNome(String nome) {
        // Perguntar porque equals e não ==
        for(Pessoa pessoa : this.pessoas)
            if(Objects.equals(pessoa.getNome(), nome))
                return pessoa;

        throw new PessoaNotFoundException();
    }

    public PessoaFisica getPessoaFisicaPorCpf(String cpf) {
        for(Pessoa pessoa : this.pessoas)
            if(pessoa instanceof PessoaFisica) {
                PessoaFisica pessoaFisica = (PessoaFisica) pessoa;

                if(Objects.equals(pessoaFisica.getCpf(), cpf))
                    return pessoaFisica;
            }

        throw new PessoaNotFoundException();
    }

    public PessoaFisica getPessoaFisicaPorRG(String rg) {
        for(Pessoa pessoa : this.pessoas)
            if(pessoa instanceof PessoaFisica) {
                PessoaFisica pessoaFisica = (PessoaFisica) pessoa;

                if(Objects.equals(pessoaFisica.getRg(), rg))
                    return pessoaFisica;
            }

        throw new PessoaNotFoundException();
    }

    public PessoaJuridica getPessoaFisicaPorCnpj(String cnpj) {
        for(Pessoa pessoa : this.pessoas)
            if(pessoa instanceof PessoaJuridica) {
                PessoaJuridica pessoaJuridica = (PessoaJuridica) pessoa;

                if(Objects.equals(pessoaJuridica.getCnpj(), cnpj))
                    return pessoaJuridica;
            }

        throw new PessoaNotFoundException();
    }

    private void validarDuplicidadePessoaFisica(PessoaFisica novaPessoaFisica) {
        this.pessoas.forEach((pessoa) -> {
            if(pessoa instanceof PessoaFisica) {
                PessoaFisica pessoaFisica = (PessoaFisica) pessoa;

                if(Objects.equals(pessoaFisica.getCpf(), novaPessoaFisica.getCpf()))
                    throw new DuplicatedCpfException();

                if(Objects.equals(pessoaFisica.getRg(), novaPessoaFisica.getRg()))
                    throw new DuplicatedRgException();
            }
        });
    }

    private void validarDuplicidadePessoaJuridica(PessoaJuridica novaPessoaJuridica) {
        this.pessoas.forEach((pessoa) -> {
            if(pessoa instanceof PessoaJuridica) {
                PessoaJuridica pessoaFisica = (PessoaJuridica) pessoa;

                if(Objects.equals(pessoaFisica.getCnpj(), novaPessoaJuridica.getCnpj()))
                    throw new DuplicatedCnpjException();
            }
        });
    }

    public ArrayList<Pessoa> getPessoas() {
        return this.pessoas;
    }
}
