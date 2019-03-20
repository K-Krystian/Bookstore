package book;

public class Book {
    String id;
    String title;
    String isbn;
    int year;
    String typeOfBinding;
    Author author;
    Category category;

    public Book(String id, String jem_dżem, String isbn, int year, String t, String ciekawy_autor, String s) {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeOfBinding() {
        return typeOfBinding;
    }

    public void setTypeOfBinding(String typeOfBinding) {
        this.typeOfBinding = typeOfBinding;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public int setYear(int year) {
        this.year = year;
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
