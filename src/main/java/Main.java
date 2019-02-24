import menu.Option;
import menu.ReadFile;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        Option option = new Option();
//        option.chooseOption();

        ReadFile readFile = new ReadFile();
        readFile.readFile();

        Book book = new Book("tytyl", "213", "35340");
    }
}
