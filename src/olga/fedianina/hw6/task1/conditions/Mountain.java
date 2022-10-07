package olga.fedianina.hw6.task1.conditions;

public class Mountain {
    //Гора создаётся с названием (не менее 4 символов), страной (не менее 4 символов) и высотой (не менее 100 метров)
    private String title;
    private String country;
    private int height;

    public String getTitle() {
        return title;
    }

    public String getCountry() {
        return country;
    }

    public int getHeight() {
        return height;
    }

    public void setTitle(String title) {
        if (title.length() < 4) {
            throw new IllegalArgumentException("Название горы должно содержать не менее 4х символов");
        }
        this.title = title;
    }

    public void setCountry(String country) {
        if ( country.length()<4){
            throw new IllegalArgumentException("Название страны должно содержать не менее 4х символов");
        }
        this.country = country;
    }

    public void setHeight(int height) {
        if (height<100){
            throw new IllegalArgumentException("Высота должна быть не менее 100 метров");
        }
        this.height = height;
    }

    public Mountain(String title, String country, int height) {
        setTitle(title);
        setCountry(country);
        setHeight(height);
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "title='" + title + '\'' +
                ", country='" + country + '\'' +
                ", height=" + height +
                '}';
    }
}
