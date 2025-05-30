package baitap2021_04_02;

public class Person implements Comparable<Person> {
    private int id;
    private String name;
    private String email;

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email.trim();
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    public void validateEmail() {
        if (!email.contains("@") || !email.contains(".")) {
            throw new ArithmeticException("Email khong hop le");
        }
        if (email.indexOf("@") != email.lastIndexOf("@")) {
            throw new ArithmeticException("Email khong hop le");
        }
        if (email.indexOf("@") > email.indexOf(".")) {
            throw new ArithmeticException("Email khong hop le");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{id: " + id + ", name: " + name + ", email: " + email + "}";
    }
}
