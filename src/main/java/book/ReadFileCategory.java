package book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFileCategory {

    public ArrayList<Category> readFileCategory() throws IOException {
        FileReader fileReader = new FileReader("H:\\SDA\\gr14\\Bookstore\\src\\main\\java\\categories.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<Category> categories = new ArrayList<>();

        String category = bufferedReader.readLine();

        do {
            String[] dividedCategories = category.split("\\;");
            Category category1 = new Category(dividedCategories[0], dividedCategories[1], dividedCategories[2]);

            categories.add(category1);
            category = bufferedReader.readLine();
        } while (category != null);
        System.out.println(categories);
        bufferedReader.close();
        return categories;
    }
}
