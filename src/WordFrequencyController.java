import java.io.IOException;
import java.util.Scanner;

public class WordFrequencyController {
    private WordFrenquenciesModel model;
    private WordFrequenciesView view;

    public WordFrequencyController(WordFrenquenciesModel model,WordFrequenciesView view){
        this.model = model;
        this.view = view;
        this.view.render();

    }

    public void run() throws IOException {
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Next file: ");
            String filename = scan.nextLine();
            this.model.update(filename);
            this.view.render();
        }

    }


}
