package utils;

public class ENumero {
    public static Boolean verificaString (String texto) {
        try {
            Double.parseDouble(texto);
            
            return true;
        } catch(Exception exception) {
            return false;
        }
    }
}
