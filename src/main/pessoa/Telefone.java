package pessoa;

protected enum DDI{
    BR("+55"), US("+1"), FR("+33")
};
public class Telefone {
    private String ddd;
    private String numero;
    private DDI ddi;

    public Telefone(String telefone) {
        // a fazer...
    }

    private String validarNumero(String numero) {
        return "a fazer...";
    }

    private String validarDdd(String ddd) {
        return "a fazer...";
    }

    private String validarDdi(String ddi) {
        return "a fazer...";
    }

}

