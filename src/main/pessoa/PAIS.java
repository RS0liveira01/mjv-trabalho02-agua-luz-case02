package pessoa;

public enum PAIS {
    BR("Brasil"),
    US("Estados Unidos"),
    FR("França");

    private String nome;

    private PAIS(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
