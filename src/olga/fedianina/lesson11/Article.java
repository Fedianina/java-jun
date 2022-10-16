package olga.fedianina.lesson11;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Article {
    private String title;
    private String text;
    private final LocalDateTime created;
    private Country country;


    public Article (String title){
        this.title = title;
        created = LocalDateTime.now();// когда создается объект ему присваивается текущее дата и время

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
