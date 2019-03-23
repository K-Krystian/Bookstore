package book;

public class Book {
    String id;
    String title;
    String isbn;
    int year;
    String typeOfBinding;
    Author author;
    Category category;


    public String getId() {
        return id;
    }

    public String getTypeOfBinding() {
        return typeOfBinding;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    public Book(String id, String title, String isbn, int year, String typeOfBinding, Author author, Category category) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.year = year;
        this.typeOfBinding = typeOfBinding;
        this.author = author;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", year='" + year + '\'' +
                ", id=" + id +
                ", typeOfBinding='" + typeOfBinding + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
