package olga.fedianina.lesson6.books;

public class Book {
    private String title;
    private int pageCount;
    private Author author;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pageCount=" + pageCount +
                ", author=" + author +
                '}';
    }
    public void setPageCount(int count){
        if (count<10){
            throw  new IllegalArgumentException("Значение не может быть <10");
        }
        pageCount = count;
    }

    public int getPageCount() {
        return pageCount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        if(author==null){
            throw new IllegalArgumentException();
        }
        this.author = author;
    }
    public Book (String title){
        this.title = title;
    }
    public Book(String title, Author author){
        this.title = title;
        setAuthor(author);
    }
}
