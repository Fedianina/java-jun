package olga.fedianina.lesson6;
import olga.fedianina.lesson6.books.Author;
import olga.fedianina.lesson6.books.Book;
public class Application {
    public static void main(String[] args) {
        // объект типа автор
        // экземпляр класса автор
        Author author1 = new Author();
        Author author2 = new Author();


        author1.name = "Baphomet";
        author1.surname = "Hell";

        author2.name = "Tom";
        author2.surname = "Reddl";
        author1.printFullName();
        String fullName = author2.getFullName();

        Book book1 = new Book("fed", author1);
        Book book2 = new Book("mkl;", author2);
        book1.setPageCount(22);
        System.out.println(book1.getPageCount());
        book1.setAuthor(author1);



    }
}
