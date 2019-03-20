package book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFileAuthor {

    public ArrayList<Author> readFileAuthor() throws IOException {
        FileReader fileReader = new FileReader("H:\\SDA\\gr14\\Bookstore\\src\\main\\java\\authors.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<Author> authors = new ArrayList<>();

        String author = bufferedReader.readLine();

        do {
            String[] dividedString = author.split("\\;");

            Author author1 = new Author(dividedString[0], dividedString[1], dividedString[2]);
            authors.add(author1);
            author = bufferedReader.readLine();
        } while (author != null);

        System.out.println(authors);
        bufferedReader.close();
        return authors;
    }

}
