import java.io.*;
import java.util.*;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        WordFrequenciesModel m = new WordFrequenciesModel(scan.nextLine());
        WordFrequenciesView v = new WordFrequenciesView(m);
        WordFrequencyController c = new WordFrequencyController(m,v);
        c.run();
    }

}
