package Task8;

public class User {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString () {
        return name + ", возраст " + age + " лет";
    }
}
