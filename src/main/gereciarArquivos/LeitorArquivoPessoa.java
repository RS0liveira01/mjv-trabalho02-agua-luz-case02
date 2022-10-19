package gereciarArquivos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LeitorArquivoPessoa {
    public static ArrayList<String[]> lerArquivo(String pathArquivo) throws IOException {
        ArrayList<String[]> infoContratos = new ArrayList<String[]>();
        Path pathToFile = Paths.get(pathArquivo);
        BufferedReader bufferLeitor = Files.newBufferedReader(pathToFile);

        String line = bufferLeitor.readLine();

        while(line != null) {
            infoContratos.add(line.split(";"));
            line = bufferLeitor.readLine();
        }

        return infoContratos;
    }
}
