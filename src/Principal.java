import java.io.*;
import java.util.*;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        WordFrenquenciesModel m = new WordFrenquenciesModel(scan.nextLine());
        WordFrequenciesView v = new WordFrequenciesView(m);
        WordFrequencyController c = new WordFrequencyController(m,v);
        c.run();
    }

}
