package book;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookFunctionsTest {
    List<Book> books = new ArrayList<>();
    BookFunctions bookFunctions = new BookFunctions();

    @Before
    public void setup() {
        Book book1 = new Book("1", "Jem dżem", "3940391820192", 1973, "T", "Ciekawy Autor", "1");
        Book book2 = new Book("2", "Mentalista", "27503292817212", 2002, "M", "Autor Mniej Ciekawy", "2");
        Book book3 = new Book("3", "Liga H", "4930292019257", 1999, "T", "Atuor jak Autor", "1");
        Book book4 = new Book("4", "Calistenika", "294857458172", 2008, "T", "To nie Autor", "3");
        Book book5 = new Book("5", "Psychologia społeczna", "102810291820", 2000, "M", "Artur Autor", "2");
        Book book6 = new Book("6", "UltraBook", "6847483927283", 1991, "T", "Twardy Autor", "3");
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
    }

    @Test
    public void testFindBook() {
        Book book = bookFunctions.findBook("6847483927283", books);
        Assert.assertEquals(book.getTitle(), "UltraBook");

    }

    @Test
    public void testFindBook2() {
        Book book = bookFunctions.findBook2("6847483927283", books);
        Assert.assertEquals(book.getTitle(), "UltraBook");
    }

    @Test
    public void testTheLastTwoBooks() {
        List<Book> theLastTwoBooks = bookFunctions.findTheLastTwoBooks(books);
//        theLastTwoBooks.get(0);
        System.out.println(theLastTwoBooks.get(0));
        System.out.println(theLastTwoBooks.get(1));
        Assert.assertEquals(theLastTwoBooks.get(0).getTitle(), "Psychologia społeczna");
        Assert.assertEquals(theLastTwoBooks.get(1).getTitle(), "UltraBook");
    }

    @Test
    public void testTheLastTwoBooks2() {
        List<Book> theLastTwoBooks2 = bookFunctions.findTheLastTwoBooks2(books);
//        theLastTwoBooks.get(0);
        System.out.println(theLastTwoBooks2.get(0));
        System.out.println(theLastTwoBooks2.get(1));
        Assert.assertEquals(theLastTwoBooks2.get(0).getTitle(), "Psychologia społeczna");
        Assert.assertEquals(theLastTwoBooks2.get(1).getTitle(), "UltraBook");
    }

    @Test
    public void testTheEarliestBook() {
        Book book = bookFunctions.theEariliestBook(books);
//        System.out.println(bookFunctions.theEariliestBook(books));
        Assert.assertEquals(books.get(0).getYear(), "1973");
    }

    @Test
    public void testTheEarliestBook2() {
        Optional<Book> book = bookFunctions.theEarliestBook2(books);
        System.out.println(bookFunctions.theEariliestBook(books));
//        Assert.assertEquals(books.get(0).getYear(), "1973");
    }

    @Test
    public void testTheLatestBook() {
        Book book = bookFunctions.theLatestBook(books);
        Assert.assertEquals(2008, book.year);
    }

    @Test
    public void testTheLatestBook2() {
        Book book = bookFunctions.theLatestBook2(books);
        Assert.assertEquals(2008, book.year);
    }

    @Test
    public void testSumOfYears() {
        int book = bookFunctions.sumOfYears(books);
        System.out.println(bookFunctions.sumOfYears(books));
        Assert.assertEquals(books.get(0).getYear()
                + books.get(1).getYear()
                + books.get(2).getYear()
                + books.get(3).getYear()
                + books.get(4).getYear()
                + books.get(5).getYear(), 11972);
    }

    @Test
    public void testSumOfYears2() {
        int book = bookFunctions.sumOfYears2(books);
        System.out.println(bookFunctions.sumOfYears2(books));
        Assert.assertEquals(books.get(0).getYear()
                + books.get(1).getYear()
                + books.get(2).getYear()
                + books.get(3).getYear()
                + books.get(4).getYear()
                + books.get(5).getYear(), 11973);
    }

    @Test
    public void testSumOfBooksAfter2007() {
        long book = bookFunctions.sumOfBooksAfter2007(books);
        System.out.println(bookFunctions.sumOfBooksAfter2007(books));
        Assert.assertEquals(books.stream().filter(x -> x.getYear() > 2007).count(), 1);

    }

    @Test
    public void testBooksAfter2000() {
        boolean book = bookFunctions.booksAfter2000(books);
        System.out.println(bookFunctions.booksAfter2000(books));
        Assert.assertEquals(books.stream().allMatch(x -> x.getYear() > 2000), false);
    }

    @Test
    public void testAverageYear() {
        double book = bookFunctions.averageYear(books);
        System.out.println(bookFunctions.averageYear(books));
        double expected = (books.get(0).getYear()
                + books.get(1).getYear()
                + books.get(2).getYear()
                + books.get(3).getYear()
                + books.get(4).getYear()
                + books.get(5).getYear()) / (double) books.size();
        Assert.assertEquals(expected, book, 0.01);
    }

    @Test
    public void testAverageYear2() {
        double book = bookFunctions.averageYear2(books);
        System.out.println(bookFunctions.averageYear2(books));
        double expected = (books.get(0).getYear()
                + books.get(1).getYear()
                + books.get(2).getYear()
                + books.get(3).getYear()
                + books.get(4).getYear()
                + books.get(5).getYear()) / (double) books.size();
        Assert.assertEquals(expected, book, 0.01);
    }

    @Test
    public void testAnyBookAfter2003() {
        List<Book> book = bookFunctions.anyBookAfter2003(books);
        System.out.println(bookFunctions.anyBookAfter2003(books));
        Assert.assertEquals(books.stream().anyMatch(x -> x.getYear() < 2003), true);
    }

    @Test
    public void testCAndAfter2007() {
        List<Book> book = bookFunctions.candAfter2007(books);
        System.out.println(bookFunctions.candAfter2007(books));

    }

    @Test
    public void testCAndAfter20072() {
        List<Book> book = bookFunctions.candAfter20072(books);
        System.out.println(bookFunctions.candAfter20072(books));
//        Assert.assertEquals(book, book);
    }

//    @Test
//    Testu nie pisałem, bo nie wiem jak zrobić metodę ;)
//    public void test10(){
//        int book = bookFunctions.plus100(books);
//        System.out.println(bookFunctions.plus100(books));
//        Assert.assertEquals((books.get(0).getYear()
//                + books.get(1).getYear()
//                + books.get(2).getYear()
//                + books.get(3).getYear()
//                + books.get(4).getYear()
//                + books.get(5).getYear())+600,55);
//    }


    @Test
    public void testDividedByTwo() {
        List<Book> book = bookFunctions.dividedByTwo(books);
        for (int i = 0; i < bookFunctions.dividedByTwo(books).size(); i++) {
            System.out.println(bookFunctions.dividedByTwo(books).get(i));
        }
    }

//     Nie wiem jak napisać test
    @Test
    public void testReturnMap() {
        Map<String, Book> book = bookFunctions.returnMap(books);

    }
//  Tutaj też mam problem z testem
    @Test
    public void testSortedByTheEarliest() {
        List<Book> book = bookFunctions.sortedByTheEarliest(books);
        List<Book> sortedList = books.stream().sorted((o1, o2) -> Integer.compare(o1.year, o2.year)).collect(Collectors.toList());

//        Assert.assertArrayEquals(sortedList,);
    }


//    @Test
//    public void test14(){
//        List<Book> book = bookFunctions.threeLists(books);
//        System.out.println(bookFunctions.threeLists(books));
//    }
}
