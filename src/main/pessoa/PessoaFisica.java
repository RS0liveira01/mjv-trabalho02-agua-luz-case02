package pessoa;

import errors.InvalidCpfException;
import errors.InvalidRgException;

public class PessoaFisica extends Pessoa {
    public String cpf;
    public String rg;

    public PessoaFisica(String[] dados) {
        super(dados[2]);

        this.cpf = this.validarCpf(dados[0]);
        this.rg = this.validarRg(dados[1]);
    }

    private String validarCpf(String cpf) {
        if (cpf.isEmpty()) {
            throw new InvalidCpfException();
        }

        if (cpf.length() != 11) {
            throw new InvalidCpfException();
        }

        if (!cpf.matches("[0-9]*")) {
            throw new InvalidCpfException();
        }

        String cpfPrimeiraSerie = cpf.substring(0, 3);
        String cpfSegundaSerie = cpf.substring(4, 6);
        String cpfTerceiraSerie = cpf.substring(7, 9);
        String cpfDigito = cpf.substring(10);

        String cpfForamatado = (
                cpfPrimeiraSerie
                + "."
                + cpfSegundaSerie
                + "."
                + cpfTerceiraSerie
                + "-"
                + cpfDigito
        );

        return cpfForamatado;
    }

    private String validarRg(String rg) {
        if (rg.isEmpty()) {
            throw new InvalidRgException();
        }

        if (!rg.matches("[0-9-]*")) {
            throw new InvalidRgException();
        }

        switch(rg.length()) {
            case 10:
                String rgPrimeiraSerie = rg.substring(0, 2);
                String rgSegundaSerie = rg.substring(3, 5);
                String rgTerceiraSeria = rg.substring(6);

                String rgFormatado = (
                        rgPrimeiraSerie
                        + "."
                        + rgSegundaSerie
                        + "."
                        + rgTerceiraSeria
                );

                return rgFormatado;

            case 7:
                return rg;

            default:
                throw new InvalidRgException();
        }
    }

    public String getCpf() { return cpf; }

    public String getRg(){ return rg; }
}


