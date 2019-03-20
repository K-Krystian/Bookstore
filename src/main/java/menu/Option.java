package menu;

import book.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Option {
    ArrayList<Author> authors;
    ArrayList<Book> books;
    ArrayList<Category> categories;


    public void init() throws IOException {
        ReadFileBooks readFileBooks = new ReadFileBooks();
        books = readFileBooks.readFileBooks();
        ReadFileAuthor readFileAuthor = new ReadFileAuthor();
        authors = readFileAuthor.readFileAuthor();
        ReadFileCategory readFileCategory = new ReadFileCategory();
        categories = readFileCategory.readFileCategory();

    }


    public void chooseOption() throws IOException {

        Scanner choose = new Scanner(System.in);
        System.out.println("Dostępne opcje:\n1 - Wyświetl książki\n2 - Wyświetl autorów\n3 - Wyświetl kategorie\n4 - Dodaj autora\n5 - Dodaj nową kategorię\n6 - Wyświetl książki wydane po 2003r.\n7 - Edycja nazwy kategorii\n8 - Wyświetl książki z kategorii wzorców projektowych\n9 - Wyświetl książki danego autora\n10 - Sortuj po roku wydania rosnąco\n11 - Sortuj po roku wydania malejąco\n" +
                "0 - Wyjście z programu");
        System.out.print("Wpisz numer opcji:");
        int number = choose.nextInt();

        while (true) {

            if (number == 1) {
                System.out.println("Lista książek:\n");
                System.out.println(books);

            } else if (number == 2) {
                System.out.println("Lista autorów:\n");
                System.out.println(authors);

            } else if (number == 3) {
                System.out.println("Lista kategorii:\n");
                System.out.println(categories);

            } else if (number == 4) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Podaj ID autora: ");
                String idAuthor = scanner.nextLine();
                System.out.print("Podaj imię oraz nazwisko autora: ");
                String authorName = scanner.nextLine();
                System.out.print("Podaj wiek: ");
                String authorAge = scanner.nextLine();
                authors.add(new Author(idAuthor, authorName, authorAge));

                try (BufferedWriter bw = new BufferedWriter(new FileWriter("H:\\SDA\\gr14\\Bookstore\\src\\main\\java\\authors1.csv"))) {

                    for (Author author : authors) {
                        bw.write(author.getAuthorId() + ";" + author.getAuthorName() + ";" + author.getAge() + "\n");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (number == 5) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Podaj ID kategorii: ");
                String idCategory = scanner.nextLine();
                System.out.print("Podaj nazwę kategorii: ");
                String categoryName = scanner.nextLine();
                System.out.print("Podaj priorytet kategorii od 1 do 3: ");
                String categoryPriority = scanner.nextLine();
                categories.add(new Category(idCategory, categoryName, categoryPriority));

            } else if (number == 6) {
                BookFunctions bookFunctions = new BookFunctions();
                System.out.println(bookFunctions.anyBookAfter2003(books));
            } else if (number == 7) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Podaj ID kategorii, którą chcesz edytować: ");
                String idCategory = scanner.nextLine();
                System.out.print("Podaj nazwę, na którą chcesz zmienić kategorię: ");
                String nameCategory = scanner.nextLine();
                for (Category category : categories)
                    if (category.getIdCategory().equals(idCategory)) {
                        category.setName(nameCategory);
                    }
            } else if (number == 8) {
                List<Book> patternList = new ArrayList<>();

                for (Book book : books) {
                    if (book.getCategory().getName().equals("Wzorce projektowe")) {
                        patternList.add(book);
                    }
                }
                System.out.println(patternList);

            } else if (number == 9) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Podaj imię oraz nazwisko autora: ");
                String authorName = scanner.nextLine();
                List<Book> authorsBooks = new ArrayList<>();
                for (Book book : books) {
                    if (book.getAuthor().getAuthorName().equals(authorName)) {
                        authorsBooks.add(book);
                    }
                }
                System.out.println(authorsBooks);

            } else if (number == 10) {
                BookFunctions bookFunctions = new BookFunctions();
                List<Book> sortedList = bookFunctions.sortedByTheEarliest(books);
                System.out.println(sortedList);
            } else if (number == 11) {
                BookFunctions bookFunctions = new BookFunctions();
                List<Book> sortedList = bookFunctions.sortedByTheLatest(books);
                System.out.println(sortedList);
            } else if (number == 0) {
                System.out.println("Wyjście z programu");
                break;
            } else {
                System.out.println("Nie ma takiej opcji. Prosimy wybrać ponownie.\n");
            }

            System.out.println("Dostępne opcje:\n1 - Wyświetl książki\n2 - Wyświetl autorów\n3 - Wyświetl kategorie\n4 - Dodaj autora\n5 - Dodaj nową kategorię\n6 - Wyświetl książki wydane po 2003r.\n7 - Edycja nazwy kategorii\n8 - Wyświetl książki z kategorii wzorców projektowych\n9 - Wyświetl książki danego autora\n10 - Sortuj po roku wydania rosnąco\n11 - Sortuj po roku wydania malejąco\n" +
                    "0 - Wyjście z programu");
            System.out.print("Wpisz numer opcji:");
            number = choose.nextInt();

        }
    }
}
