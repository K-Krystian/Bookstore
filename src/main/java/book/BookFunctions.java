package book;

import java.util.*;
import java.util.stream.Collectors;

public class BookFunctions {

    public Book findBook(String isbn, List<Book> books) {
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                return book;
            }

        }
        return null;
    }

    public Book findBook2(String isbn, List<Book> books) {
        return books.stream().filter(book ->
                book.isbn.equals(isbn)).
                findFirst().orElse(null);
    }

    public List<Book> findTheLastTwoBooks(List<Book> books) {
        return books.subList(books.size() - 2, books.size());
    }

    public List<Book> findTheLastTwoBooks2(List<Book> books) {
        return books.stream().skip(books.size() - 2).
                collect(Collectors.toList());
    }

    public Book theEariliestBook(List<Book> books) {
        books.sort(Comparator.comparing(Book::getYear));

        return books.get(0);
    }

    public Optional<Book> theEarliestBook2(List<Book> books) {

        return books.stream().
                sorted(Comparator.comparing(Book::getYear)).
                findFirst();
    }

    public Book theLatestBook(List<Book> books) {
        books.sort(Comparator.comparing(Book::getYear).reversed());
        return books.get(0);
    }

    public Book theLatestBook2(List<Book> books) {
        return books.stream().
                sorted(Comparator.comparing(Book::getYear).
                        reversed()).findFirst().get();
    }

    public int sumOfYears(List<Book> books) {
        int suma = 0;
        for (Book book : books) {
            suma += book.getYear();
        }
        return suma;
    }

    public int sumOfYears2(List<Book> books) {
        int suma = books.stream().mapToInt(Book::getYear).sum();
        return suma;

    }

    public long sumOfBooksAfter2007(List<Book> books) {
        return books.stream().filter(x -> x.getYear() > 2007).count();
    }

    public boolean booksAfter2000(List<Book> books) {
        return books.stream().allMatch(x -> x.getYear() > 2000);
    }

    public double averageYear(List<Book> books) {
        double average = 0;
        for (Book book : books) {
            average += book.getYear();
        }
        return average / books.size();
    }

    public double averageYear2(List<Book> books) {
        double average = books.stream().mapToDouble(Book::getYear).sum();
        return average / books.size();
    }
//  Zwraca mi pustą listę. Nie mogę dojśc do tego, co było
//    wcześniej, bo ta metoda działała.
    public List<Book> anyBookAfter2003(List<Book> books) {
        List<Book> rList = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() > 2003) {
                rList.add(book);
            }
        }
        return rList;
    }

    public List<Book> candAfter2007(List<Book> books) {
        List<Book> cList = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() > 2007 && book.getTitle().startsWith("C"))
                cList.add(book);
        }
        return cList;
    }

    public List<Book> candAfter20072(List<Book> books) {
        List<Book> cList = books.stream().filter(book ->
                book.getYear() > 2007 && book.getTitle().
                        startsWith("C")).
                collect(Collectors.toList());
        return cList;
    }

//    Nie wiem jak ugryźć temat dodania 100 lat do roku wydania
//    public int plus100 (List<Book> books){
//
//        }

    public List<Book> dividedByTwo(List<Book> books) {
        List<Book> dList = new ArrayList<>();
        for (Book book : books) {
            if ((book.getYear() % 2) == 0)
                dList.add(book);
        }
        return dList;

    }

    public List<Book> dividedByTwo2(List<Book> books) {
        List<Book> dList = books.stream().
                filter(book -> (book.getYear() % 2) == 0).
                collect(Collectors.toList());
        return dList;
    }

    public Map<String, Book> returnMap(List<Book> books) {
        Map<String, Book> stringIntegerMap = new HashMap<>();
        for (Book book : books) {
            stringIntegerMap.put(book.getIsbn(), book);

        }
        return stringIntegerMap;
    }

    public Map<String, Book> returnMap2(List<Book> books) {
        Map<String, Book> stringIntegerMap = books.stream().
                collect(Collectors.
                        toMap(Book::getIsbn, book -> book));
        return stringIntegerMap;
    }

    public List<Book> sortedByTheEarliest(List<Book> books) {

        List<Book> sortedList = books.stream().sorted((o1, o2) -> Integer.compare(o1.year, o2.year)).collect(Collectors.toList());

        return sortedList;
    }

    public List<Book> sortedByTheLatest(List<Book> books) {

        List<Book> sortedList = books.stream().sorted((o2, o1) -> Integer.compare(o1.year, o2.year)).collect(Collectors.toList());

        return sortedList;
    }
//    Nie wiem jak stworzyć te 3 listy
//    public List<Book> threeLists(List<Book> books) {
//        List<Book> sub1 = new ArrayList<>();
//        sub1 = books.subList(0, 1);
//        List<Book> sub2 = new ArrayList<>();
//        sub2 = books.subList(2, 3);
//        List<Book> sub3 = new ArrayList<>();
//        sub3 = books.subList(4, 5);
//
//
//        System.out.println(sub1);
//        System.out.println(sub2);
//        System.out.println(sub3);
//        return null;
}



