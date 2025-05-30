package baitap2021_04_02;

import java.util.ArrayList;
import java.util.Collections;

public class TestPerson {
    public static void main(String[] args) {
        ArrayList<Person> p = new ArrayList<>();
        p.add(new Person(1, "abc def", "abc@gmailcom"));
        p.add(new Person(2, "mno pqr", "mno@gmail@.com"));
        p.add(new Person(3, "ghi jkl", "ghi.gmail@com"));
        p.add(new Person(4, "hop le", "   hople@gmail.com     "));
        Collections.sort(p);
        System.out.println(p);
        for (Person i : p) {
            try {
                i.validateEmail();
                System.out.println(i);
            }
            catch (ArithmeticException e) {
                e.printStackTrace();
            }
        }
    }
}
