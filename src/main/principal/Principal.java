package principal;

import pessoa.Telefone;

import java.util.Arrays;

public class Principal {
    public static void main(String[] args) {

        String[] dados = {"teste 1", "teste 2", "teste 3"};

        String[] testes = Arrays.copyOfRange(dados, 1, 3 );
        for (String teste : testes){
            System.out.println(teste);
        }
    }

}
