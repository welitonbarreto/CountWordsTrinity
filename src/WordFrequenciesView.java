import java.util.*;

public class WordFrequenciesView{
    private WordFrenquenciesModel model;

    public WordFrequenciesView(WordFrenquenciesModel model){
        this.model = model;
    }

    public void render(){
        HashMap<String,Integer> freqs = model.getFreqs();

        List<Map.Entry<String, Integer>> list = new ArrayList<>(freqs.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);

        for(int i = 0;i < 25;i++){
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println(entry.getKey()+ " " + entry.getValue());
        }

    }




}
