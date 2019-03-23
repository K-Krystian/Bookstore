package book;

public class Category {
    String idCategory;
    String name;
    String priority;

    public Category(String idCategory, String name, String priority) {
        this.idCategory = idCategory;
        this.name = name;
        this.priority = priority;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", name='" + name + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
