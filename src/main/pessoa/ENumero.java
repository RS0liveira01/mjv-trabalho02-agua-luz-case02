package pessoa;

public static class ENumero (){
    public static Boolean verificaString (String texto) {
        try {
            Double.parseDouble(texto);
            return true;
        }
        catch () {
            return false;
        }
    }
}
