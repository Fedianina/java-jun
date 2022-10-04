package olga.fedianina.lesson6.books;

public class Author {
    public String name;
    public String surname;
    public void printFullName(){
        System.out.println(name + " "+ surname);
    }
    public String getFullName(){
        return name + " " + surname;

    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
