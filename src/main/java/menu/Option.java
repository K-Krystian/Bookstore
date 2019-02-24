package menu;

import book.Book;
import book.ReadFileAuthor;
import book.ReadFileCategory;

import java.io.IOException;
import java.util.Scanner;

public class Option {
    public void chooseOption() throws IOException {

        Scanner choose = new Scanner(System.in);
        System.out.println("Dostępne opcje:\n1 - Wyświetl książki\n2 - Wyświetl autorów\n3 - Wyświetl kategorie\n" +
                "0 - Wyjście z programu");
        System.out.print("Wpisz numer opcji:");
        int number = choose.nextInt();

        while (true) {

            if (number == 1) {
                ReadFileBooks readFileBooks = new ReadFileBooks();
                System.out.println("Lista książek:\n");
                readFileBooks.readFileBooks();

            } else if (number == 2) {
                ReadFileAuthor readFileAuthor = new ReadFileAuthor();
                System.out.println("Lista autorów:\n");
                readFileAuthor.readFileAuthor();

            } else if (number == 3){
                ReadFileCategory readFileCategory = new ReadFileCategory();
                System.out.println("Lista kategorii:\n");
                readFileCategory.readFileCategory();
            } else if (number == 0){
                System.out.println("Wyjście z programu");
                break;
            }
            else {
                System.out.println("Nie ma takiej opcji. Prosimy wybrać ponownie.\n");
            }

            System.out.println("Dostępne opcje:\n1 - Wyświetl książki\n2 - Wyświetl autorów\n3 - Wyświetl kategorie\n" +
                    "0 - Wyjście z programu");
            System.out.print("Wpisz numer opcji:");
            number = choose.nextInt();

        }
    }
}
