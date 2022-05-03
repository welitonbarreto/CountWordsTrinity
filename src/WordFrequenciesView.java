import java.util.*;

public class WordFrequenciesView{
    private WordFrequenciesModel model;

    public WordFrequenciesView(WordFrequenciesModel model){
        this.model = model;
    }

    public void render(){
        HashMap<String,Integer> contadorFrequencias = model.getFreqs();

        List<Map.Entry<String, Integer>> list = new ArrayList<>(contadorFrequencias.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);

        for(int i = 0;i < 25;i++){
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println(entry.getKey()+ " " + entry.getValue());
        }

    }
}
