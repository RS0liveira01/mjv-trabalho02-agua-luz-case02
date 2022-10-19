package gereciarArquivos;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LeitorArquivoPessoa {
    public static ArrayList<String[]> lerArquivo(String pathArquivo) {
        ArrayList<String[]> infoContratos = new ArrayList<String[]>();
        Path pathToFile = Paths.get(pathArquivo);

        try {
            BufferedReader bufferLeitor = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = bufferLeitor.readLine();

            while(line != null) {
                infoContratos.add(line.split(";"));
                line = bufferLeitor.readLine();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        return infoContratos;
    }
}
