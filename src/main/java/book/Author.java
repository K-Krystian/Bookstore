package book;

public class Author {
    String authorId;
    String authorName;
    String age;

    public Author(String authorId, String authorName, String age) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.age = age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId='" + authorId + '\'' +
                ", authorName='" + authorName + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
