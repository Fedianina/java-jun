package olga.fedianina.hw6.task1.conditions;

public class Alpenist {
    //Альпинист создаётся с именем (не менее 3 символов) и адресом проживания (не менее 5 символов).
    private String name;
    private String adress;


    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public void setName(String name) {
        if (name == null || name.length() < 3) {
            throw new IllegalArgumentException("Имя должно содержать не менее 3х символов");
        }
        this.name = name;
    }

    public void setAdress(String adress) {
        if (name == null || adress.length() < 5) {
            throw new IllegalArgumentException("Адрес должен содержать менее 5х символов");
        }
        this.adress = adress;
    }

    public Alpenist(String name, String adress) {
        setName(name);
        setAdress(adress);
    }

    @Override
    public String toString() {
        return "Alpenist{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}

