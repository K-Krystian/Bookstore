package menu;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReadFile {

    public void readFile() throws IOException {
        FileReader fileReader = new FileReader("H:\\SDA\\gr14\\Bookstore\\src\\main\\java\\books.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String text = bufferedReader.readLine();
        do {
            String[] dividedString = text.split("\\;");
            for (int i = 0; i <dividedString.length ; i++) {
                System.out.println(dividedString[i]);
            }

            Book book = new Book();
            text = bufferedReader.readLine();
        } while(text != null);

        bufferedReader.close();
    }
}

