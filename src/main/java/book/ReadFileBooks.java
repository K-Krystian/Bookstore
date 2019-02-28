package book;

import book.Book;
import book.Category;
import book.ReadFileCategory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadFileBooks {

    public void readFileBooks() throws IOException {
        FileReader fileReader = new FileReader("H:\\SDA\\gr14\\Bookstore\\src\\main\\java\\books.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<Book> books = new ArrayList<>();
        String text = bufferedReader.readLine();
        ArrayList<Category> categories = new ReadFileCategory().readFileCategory();
        do {
            String[] dividedString = text.split("\\;");

            String categoryID = dividedString[6];
            for (Category category : categories) {
                if (category.getIdCategory() == "3"){

                }
            }
            Book book1 = new Book(dividedString[0], dividedString[1], dividedString[2], dividedString[3],
                    dividedString[4], dividedString[5], null);
            books.add(book1);
            text = bufferedReader.readLine();
        } while (text != null);

        System.out.println(books);
        bufferedReader.close();
    }
}

