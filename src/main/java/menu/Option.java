package menu;

import java.util.Scanner;

public class Option {
    public void chooseOption() {

        Scanner choose = new Scanner(System.in);
        System.out.println("Dostępne opcje:\n1.Wyświetl\n2.Wyjście");
        System.out.print("Wpisz numer opcji:");
        int number = choose.nextInt();

        while (true) {

            if (number == 1) {
                System.out.println("Wybrałeś opcję 1");

            } else if (number == 2) {
                System.out.println("Wybrałeś opcję 2. Wyjście z programu");
                break;
            } else {
                System.out.println("Wprowadzono błędną liczbę. Wybierz jedną z dostępnych opcji");
            }

            System.out.println("  \nDostępne opcje:\n1.Wyświetl\n2.Wyjście");
            System.out.print("Wpisz numer opcji:");
             number = choose.nextInt();

        }
    }
}
