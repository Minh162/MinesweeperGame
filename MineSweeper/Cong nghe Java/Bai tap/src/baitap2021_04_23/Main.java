package baitap2021_04_23;

public class Main {
    private static ArrayOfObjects a = new ArrayOfObjects();

    public static void main(String[] args) {
        a = IOFromFile.readFromFile("src/baitap2021_04_23/in.txt");
        System.out.println(a);
        IOFromFile.writeToFile("src/baitap2021_04_23/result.txt", a);
    }
}
