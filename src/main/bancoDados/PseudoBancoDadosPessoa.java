package bancoDados;

import errors.*;
import pessoa.Contrato;
import pessoa.Pessoa;
import pessoa.PessoaFisica;
import pessoa.PessoaJuridica;

import java.util.ArrayList;
import java.util.Objects;

public class PseudoBancoDadosPessoa {
    ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

    public Pessoa registrarPessoa(String[] dadosPessoa) {
        switch(dadosPessoa.length) {
            case 3:
                try {
                    this.validarDuplicidadePessoaFisica(dadosPessoa);

                    PessoaFisica novaPessoaFisica = new PessoaFisica(dadosPessoa);
                    this.pessoas.add(novaPessoaFisica);

                    return novaPessoaFisica;
                } catch(Exception exception) {
                    if((exception instanceof DuplicatedCpfException) || (exception instanceof DuplicatedRgException)) {
                        System.out.println("Cadastro existente detectado.");

                        PessoaFisica cpfPessoa = getPessoaFisicaPorCpf(dadosPessoa[0]);
                        PessoaFisica rgPessoa = getPessoaFisicaPorRG(dadosPessoa[1]);

                        if((!Objects.equals(cpfPessoa, rgPessoa)) || (!Objects.equals(cpfPessoa.getNome(), dadosPessoa[0]))) {
                            throw new IncoherentDataException();
                        }

                        return cpfPessoa;
                    }

                    throw exception;
                }

            case 2:
                try {
                    this.validarDuplicidadePessoaJuridica(dadosPessoa);

                    PessoaJuridica novaPessoaJuridica = new PessoaJuridica(dadosPessoa);
                    this.pessoas.add(novaPessoaJuridica);

                    return novaPessoaJuridica;
                } catch(Exception exception) {
                    if(exception instanceof DuplicatedCnpjException) {
                        System.out.println("Cadastro existente detectado.");

                        PessoaJuridica cnpjPessoa = getPessoaJuridicaPorCnpj(dadosPessoa[0]);

                        if(!Objects.equals(cnpjPessoa.getNome(), dadosPessoa[0])) {
                            throw new IncoherentDataException();
                        }

                        return cnpjPessoa;
                    }

                    throw exception;
                }

            default:
                throw new UnsupportedPessoaImplementationException();
        }
    }

    public void registrarContrato(Pessoa pessoaContratante, String[] dadosContrato) {
        if(dadosContrato.length != 15)
            throw new InvalidDadosContratoException();

        this.validarDuplicidadeContrato(dadosContrato[9]);

        int posicaoPessoaContratante = this.pessoas.indexOf(pessoaContratante);

        if(posicaoPessoaContratante == -1)
            throw new PessoaNotFoundException();

        this.pessoas.get(posicaoPessoaContratante).registrarContrato(dadosContrato);
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

    public PessoaJuridica getPessoaJuridicaPorCnpj(String cnpj) {
        for(Pessoa pessoa : this.pessoas)
            if(pessoa instanceof PessoaJuridica) {
                PessoaJuridica pessoaJuridica = (PessoaJuridica) pessoa;

                if(Objects.equals(pessoaJuridica.getCnpj(), cnpj))
                    return pessoaJuridica;
            }

        throw new PessoaNotFoundException();
    }

    private void validarDuplicidadePessoaFisica(String[] dadosPessoaFisica) {
        this.pessoas.forEach((pessoa) -> {
            if(pessoa instanceof PessoaFisica) {
                PessoaFisica pessoaFisica = (PessoaFisica) pessoa;

                if(Objects.equals(pessoaFisica.getCpf(), dadosPessoaFisica[0]))
                    throw new DuplicatedCpfException();

                if(Objects.equals(pessoaFisica.getRg(), dadosPessoaFisica[1]))
                    throw new DuplicatedRgException();
            }
        });
    }

    private void validarDuplicidadePessoaJuridica(String[] dadosPessoaJuridica) {
        this.pessoas.forEach((pessoa) -> {
            if(pessoa instanceof PessoaJuridica) {
                PessoaJuridica pessoaJuridica = (PessoaJuridica) pessoa;

                if(Objects.equals(pessoaJuridica.getCnpj(), dadosPessoaJuridica[0]))
                    throw new DuplicatedCnpjException();
            }
        });
    }

    private void validarDuplicidadeContrato(String protocolo) {
        for(Pessoa pessoa : this.pessoas)
            for(Contrato contrato : pessoa.getContratos())
                if(Objects.equals(contrato.getProtocolo(), protocolo))
                    throw new DuplicatedProtocoloException();
    }

    public ArrayList<Pessoa> getPessoas() {
        return this.pessoas;
    }
}
