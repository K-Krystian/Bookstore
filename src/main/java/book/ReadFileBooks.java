package book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFileBooks {

    public ArrayList<Book> readFileBooks() throws IOException {
        FileReader fileReader = new FileReader("H:\\SDA\\gr14\\Bookstore\\src\\main\\java\\books.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<Book> books = new ArrayList<>();
        String text = bufferedReader.readLine();
        ArrayList<Category> categories = new ReadFileCategory().readFileCategory();
        ArrayList<Author> authors = new ReadFileAuthor().readFileAuthor();
        do {
            String[] dividedString = text.split("\\;");
            Author author = authors.stream().filter(y -> y.getAuthorId().equals(dividedString[5])).findFirst().get();
            Category category = categories.stream().filter(x -> x.getIdCategory().equals(dividedString[6])).findFirst().get();

            Book book1 = new Book(dividedString[0], dividedString[1], dividedString[2], Integer.parseInt(dividedString[3]),
                    dividedString[4], author, category);
            books.add(book1);
            text = bufferedReader.readLine();
        } while (text != null);

        System.out.println(books);
        bufferedReader.close();
        return books;
    }
}

