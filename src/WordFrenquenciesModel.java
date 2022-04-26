import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;


public class WordFrenquenciesModel {

    private HashMap<String,Integer> freqs = new HashMap<>();
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

        String texto = new String(Files.readAllBytes(Path.of("src/pride-and-prejudice.txt"))).toLowerCase();

        for (String palavra : texto.split("[^a-z$]")) {
            if (palavra.length() >= 2 && !this.stopWords.contains(palavra)) {
                if (freqs.containsKey(palavra)) {
                    int valor = freqs.get(palavra) + 1;
                    freqs.put(palavra, valor);
                } else {
                    freqs.put(palavra, 1);
                }
            }
        }


        //for(String palavra: this.freqs.keySet()){
        //    int valor = this.freqs.get(palavra);
        //    System.out.println(palavra + " " +  String.valueOf(valor));
        //}
    }





}
