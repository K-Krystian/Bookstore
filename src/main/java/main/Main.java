package main;

import book.Book;
import book.BookFunctions;
import menu.Option;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Option option = new Option();
        option.init();
        option.chooseOption();
    }
}
