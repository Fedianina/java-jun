package olga.fedianina.hw6.task4.people;

abstract class People {
    protected String name;
    protected int age;


    protected People(String name, int age) {
        if (name.length()<2)
            throw new IllegalArgumentException("Имя должно содержать более 2х знаков");
        setName(name);
        this.age = age;
    }

    private void setName(String name) {
        if (name.length()<2)
            throw new IllegalArgumentException("Имя должно содержать более 2х знаков");
        this.name = name;
    }


    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

