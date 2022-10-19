package pessoa;

public enum TIPOSERVICO {
    A("AGUA", 115.0),
    L("LUZ", 127.0);

    private String sigla;
    private Double valor;

    private TIPOSERVICO (String sigla, Double valor){
        this.sigla = sigla;
        this.valor = valor;
    }

    public String getSigla() {
        return sigla;
    }

    public Double getValor() {
        return valor;
    }

    public static TIPOSERVICO valueOfSigla(String sigla){
        for(TIPOSERVICO ts : values()) {
            if(ts.getSigla().equals(sigla))
                return ts;
        }
        throw new IllegalArgumentException("Não foi possível localizar um tipo serviço com a sigla " + sigla);
    }
}
