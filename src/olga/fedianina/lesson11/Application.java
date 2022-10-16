package olga.fedianina.lesson11;

public class Application {
    public static void main(String[] args) {
        Article article1 = new Article("Путешествие по Австарилии");
        article1.setCountry(Country.AUSTRALIA);
        Article article2 = new Article("Путешествие по Франции");
        article2.setCountry(Country.FRANCE);


        Country france = Country.valueOf("FRANCE");
        System.out.println(france.ordinal());

        Priority low = Priority.LOW;
        System.out.println(low.getCode()); // 1
        low.setCode(2);
        System.out.println(low.getCode());//2

        


    }
}
