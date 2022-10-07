package olga.fedianina.hw6.task2.condition;

public class Foodstuff {
    //Свойства: название продукта / белки / жиры / углеводы / калории
    //Минимум 4 конструктора
    //Реализовать необходимые проверки входящих данных
    //Создать не менее 4 экземпляров данного класса (объектов)
    private String task;
    private double protein;
    private double fat;
    private double carbone;
    private double calory;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        if (task.length() < 3)
            throw new IllegalArgumentException("Название продукта должно содержать не менее 3х символов");
        this.task = task;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        if (protein < 0.0) {
            throw new IllegalArgumentException("Количество белков должно быть не менее 0.0");
        }
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        if (fat < 0.0) {
            throw new IllegalArgumentException("Количество жиров должно быть не менее 0.0");
        }
        this.fat = fat;
    }

    public double getCarbone() {
        return carbone;
    }

    public void setCarbone(double carbone) {
        if (carbone < 0.0) {
            throw new IllegalArgumentException("Количество углеводов должно быть не менее 0.0");
        }
        this.carbone = carbone;
    }

    public double getCalory() {

        return calory;
    }

    public void setCalory(double calory) {
        if (calory < 0.0) {
            throw new IllegalArgumentException("Количество калорий должно быть не менее 0.0");
        }
        this.calory = calory;
    }

    public Foodstuff(String task, double protein, double fat, double carbone, double calory) {
        setTask(task);
        setProtein(protein);
        setFat(fat);
        setCarbone(carbone);
        setCalory(calory);
    }

    public Foodstuff(String task, double protein) {
        setTask(task);
        setProtein(protein);
    }

    public Foodstuff(double fat, double carbone, double calory) {
        setFat(fat);
        setCarbone(carbone);
        setCalory(calory);
    }

    public Foodstuff( ) {

    }
    public Foodstuff(String task) {
        setTask(task);
    }

    @Override
    public String toString() {
        return "Foodstuff{" +
                "task='" + task + '\'' +
                '}';
    }
}


