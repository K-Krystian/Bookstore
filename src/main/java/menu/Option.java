package menu;

import book.*;

import java.io.BufferedReader;
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


    public void chooseOption() {

        Scanner choose = new Scanner(System.in);
        System.out.println("Dostępne opcje:\n1 - Wyświetl książki\n2 - Wyświetl autorów\n3 - Wyświetl kategorie\n4 - Dodaj autora\n5 - Dodaj nową kategorię\n6 - Wyświetl książki wydane po 2003r.\n7 - Edycja nazwy kategorii\n8 - Wyświetl książki z kategorii wzorców projektowych\n9 - Wyświetl książki danego autora\n10 - Sortuj po roku wydania rosnąco\n11 - Sortuj po roku wydania malejąco\n12 - Usuwanie po id książki, autora lub kategorii\n13 - Zapis stanu danych\n" +
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

                try (BufferedWriter bw = new BufferedWriter(new FileWriter("H:\\SDA\\gr14\\Bookstore\\src\\main\\java\\authors.csv"))) {

                    for (Author author : authors) {
                        bw.write(author.getAuthorId() + ";" + author.getAuthorName() + ";" + author.getAge() + "\n");
                    }
                    System.out.println("Udało się zapisać plik\n");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Nie udało się zapisać pliku");
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

                try (BufferedWriter bw = new BufferedWriter(new FileWriter("H:\\SDA\\gr14\\Bookstore\\src\\main\\java\\categories.csv"))) {

                    for (Category category : categories) {
                        bw.write(category.getIdCategory() + ";" + category.getName() + ";" + category.getPriority() + "\n");
                    }
                    System.out.println("Udało się zapisać plik\n");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Nie udało się zapisać pliku");
                }

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
            } else if (number == 12) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Wybierz:\n1 - Aby usunąć książkę\n2 - Aby usunąć autora\n3 - Aby usunąć kategorię");
                int kind = Integer.valueOf(scanner.nextLine());
                if (kind == 1) {
                    System.out.println("Podaj ID książki, którą chcesz usunać");
                    String id = scanner.nextLine();
//                    books.removeIf(book -> book.getId().equals(id));
                    Book temp = null;
                    for (Book book : books) {
                        if (book.getId().equals(id)) {
                            temp = book;
                        }
                    }
                    books.remove(temp);

                } else if (kind == 2) {
                    System.out.println("Podaj ID autora, którego chcesz usunąć");
                    String id = scanner.nextLine();
//                    books.removeIf(book -> book.getId().equals(id));
                    Author temp = null;
                    for (Author author : authors) {
                        if (author.getAuthorId().equals(id)) ;
                        temp = author;
                    }

                } else if (kind == 3) {
                    System.out.println("Podaj ID kategorii, którą chcesz usunąć");
                    String id = scanner.nextLine();
                    List<Book> categoryList = new ArrayList<>();
                    for (Category category : categories) {
                        if (category.getIdCategory().equals(id)) ;
                        categoryList.remove(id);
                    }
                }

            } else if (number == 13) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("H:\\SDA\\gr14\\Bookstore\\src\\main\\java\\authors1.csv"))) {
                    for (Author author : authors) {
                        bw.write(author.getAuthorId() + ";" + author.getAuthorName() + ";" + author.getAge() + "\n");
                    }
                    System.out.println("Zapisano autorów");
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                Book ma konstruktory na podstawie klas Author i Category - inaczej zapisuje do pliku
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("H:\\SDA\\gr14\\Bookstore\\src\\main\\java\\books1.csv"))) {
                    for (Book book : books) {
                        bw.write(book.getId() + ";" + book.getTitle() + ";" + book.getIsbn() + ";" + book.getYear() + ";" + book.getTypeOfBinding() + ";" + book.getAuthor() + ";" + book.getCategory() + "\n");
                    }
                    System.out.println("Zapisano książki");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("H:\\SDA\\gr14\\Bookstore\\src\\main\\java\\categories1.csv"))) {
                    for (Category category : categories) {
                        bw.write(category.getIdCategory()+ ";" + category.getName() + ";" + category.getPriority() + "\n");
                    }
                    System.out.println("Zapisano kategorię");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (number == 14) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Podaj ID autora, którego chcesz edytować");
                String idAuthor = scanner.nextLine();
                System.out.println("Podaj wiek autora");
                String authorAge = scanner.nextLine();
                for (Author author : authors) {
                    if (author.getAuthorId().equals(idAuthor)) {
                        author.setAge(authorAge);
                    }

                }
            } else if (number == 0) {
//                Do zrobienia zapis do pliku przed wyjściem 
                System.out.println("Wyjście z programu");
                break;
            } else {
                System.out.println("Nie ma takiej opcji. Prosimy wybrać ponownie.\n");
            }

            System.out.println("Dostępne opcje:\n1 - Wyświetl książki\n2 - Wyświetl autorów\n3 - Wyświetl kategorie\n4 - Dodaj autora\n5 - Dodaj nową kategorię\n6 - Wyświetl książki wydane po 2003r.\n7 - Edycja nazwy kategorii\n8 - Wyświetl książki z kategorii wzorców projektowych\n9 - Wyświetl książki danego autora\n10 - Sortuj po roku wydania rosnąco\n11 - Sortuj po roku wydania malejąco\n12 - Usuwanie po id książki, autora lub kategorii\n13 - Zapis stanu danych\n" +
                    "0 - Wyjście z programu");
            System.out.print("Wpisz numer opcji:");
            number = choose.nextInt();

        }
    }
}
