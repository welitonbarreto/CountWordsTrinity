import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;


public class WordFrenquenciesModel {

    private HashMap<String,Integer> contadorFrequencias;
    private HashSet<String> stopWords = new HashSet<>();

    public WordFrenquenciesModel(String pathToFile) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader("src/stop_words.txt"));
        String[] linha = buffRead.readLine().split(",");

        for(String palavra:linha){
            this.stopWords.add(palavra);
        }
        buffRead.close();
        update(pathToFile);
    }


    public void update(String pathToFile) throws IOException{

        String texto = new String(Files.readAllBytes(Path.of(pathToFile))).toLowerCase();
        String[] palavrasFiltradas = texto.split("[^a-z$]");
        contadorFrequencias = new HashMap<>();

        for (String palavra : palavrasFiltradas ) {
            if (palavra.length() >= 2 && !this.stopWords.contains(palavra)) {
                if (contadorFrequencias.containsKey(palavra)) {
                    int valor = contadorFrequencias.get(palavra) + 1;
                    contadorFrequencias.put(palavra, valor);
                } else {
                    contadorFrequencias.put(palavra, 1);
                }
            }
        }
    }

    public HashMap<String, Integer> getFreqs() {
        return contadorFrequencias;
    }
}
