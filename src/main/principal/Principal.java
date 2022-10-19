package principal;

import bancoDados.PseudoBancoDadosPessoa;
import errors.InvalidNomeException;
import errors.UnsupportedPessoaImplementationException;
import gereciarArquivos.LeitorArquivoPessoa;
import pessoa.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Principal {
    public static void main(String[] args) {
        PseudoBancoDadosPessoa bancoDados = new PseudoBancoDadosPessoa();
        ArrayList<String[]> infoContratos;

        try {
            infoContratos = LeitorArquivoPessoa.lerArquivo("agua-luz-output/agua-luz-contratos.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(infoContratos.size() != 0) {
            for (String[] infoContrato : infoContratos) {
                Pessoa pessoa;
                try {
                    switch(infoContrato.length) {
                        case 18:
                            pessoa = bancoDados.registrarPessoa(Arrays.copyOfRange(infoContrato, 0, 3));

                            bancoDados.registrarContrato(pessoa, Arrays.copyOfRange(infoContrato, 3, 18));

                            break;

                        case 17:
                            pessoa = bancoDados.registrarPessoa(Arrays.copyOfRange(infoContrato, 0, 2));

                            bancoDados.registrarContrato(pessoa, Arrays.copyOfRange(infoContrato, 2, 17));

                            break;

                        default:
                            throw new UnsupportedPessoaImplementationException();
                    }
                } catch(Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
        }

        ArrayList<Pessoa> pessoasRegistradas = bancoDados.getPessoas();
        if(pessoasRegistradas.size() != 0) {
            for(Pessoa pessoa : pessoasRegistradas) {
                if(pessoa instanceof PessoaFisica) {
                    PessoaFisica pessoaFisica = (PessoaFisica) pessoa;
                    System.out.println(
                            pessoaFisica.getNome()
                            + " do CPF "
                            + pessoaFisica.getCpf()
                            + " e RG "
                            + pessoaFisica
                            + " possui as seguintes informações:"
                    );
                } else if(pessoa instanceof PessoaJuridica) {
                    PessoaJuridica pessoaJuridica = (PessoaJuridica) pessoa;
                    System.out.println(
                            pessoaJuridica.getNome()
                            + " do CNPJ "
                            + pessoaJuridica.getCnpj()
                            + " possui as seguintes informações:"
                    );
                }

                System.out.print("Telefone(s):");
                for(Telefone telefone : pessoa.getTelefones()) {
                    System.out.print(" (" + telefone.getDdd() + ") ");

                    String numero = telefone.getNumero();
                    if(numero.length() == 9) {
                        System.out.print(numero.substring(0, 5) + "-" + numero.substring(6));
                    } else {
                        System.out.print(numero.substring(0, 4) + "-" + numero.substring(5));
                    }
                }
                System.out.print("\n\n");

                System.out.println("Contratos:");
                for(Contrato contrato : pessoa.getContratos()) {
                    System.out.println("Protocolo: " + contrato.getProtocolo());
                    System.out.println(
                            "Serviço de "
                            + contrato.getTipoServico().getSigla()
                            + " no valor de R$ "
                            + contrato.getTipoServico().getValor()
                    );
                    System.out.println("Serviço marcado para o horário: ");

                    Endereco endereco = contrato.getEndereco();
                    System.out.println("\nEndereço:");
                    System.out.println(
                            endereco.getLogradouro()
                            + ", n° "
                            + endereco.getNumero()
                    );
                    System.out.println(
                            endereco.getBairro()
                            + ", "
                            + endereco.getCidade()
                            + " - "
                            + endereco.getUf()
                            + ", "
                            + endereco.getPais()
                    );
                    System.out.println(endereco.getComplemento());
                    System.out.println(
                            "CEP: "
                            + endereco.getCep().substring(0, 2)
                            + "."
                            + endereco.getCep().substring(2,5)
                            + "-"
                            + endereco.getCep().substring(6)
                    );

                    System.out.println(
                            "O cliente deve ser notificadp através de "
                            + contrato.getTipoNotificacao().getTipo()
                    );
                }
            }
        } else {
            System.out.println("Nenhum cadastro feito! :(");
        }
    }
}
