package filereadwrite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {
    private static final ArrayList<Point>arrListOfPoint = new ArrayList<>();

    private static void run() {
        inputFromFile();
        outputToFile();
    }

    private static void inputFromFile() {
        try {
            FileReader fr = new FileReader("src/filereadwrite/input.txt");
            BufferedReader br = new BufferedReader(fr);
            String input = br.readLine().replace("]-[", " ").replace(";", " ");
            String[] arrOfStr = input.substring(1, input.length() - 2).split(" ");
            for (int i = 0; i < arrOfStr.length; i += 2) {
                arrListOfPoint.add(new Point(Double.parseDouble(arrOfStr[0]), Double.parseDouble(arrOfStr[1])));
            }
            System.out.println(arrListOfPoint);
            br.close();
            fr.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static double sum() {
        double sum = 0.0;
        for (int i = 0; i < arrListOfPoint.size() - 1; i++) {
            for (int j = i + 1; j < arrListOfPoint.size(); j++) {
                System.out.println(arrListOfPoint.get(i).distance(arrListOfPoint.get(j)));
//                System.out.println(sum);
            }
        }
        return sum;
    }

    private static void outputToFile() {
        try {
            FileWriter fw = new FileWriter("src/filereadwrite/output.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Number of Points: " + arrListOfPoint.size() + "\n");
            bw.write("Total distance: " + sum());
            bw.close();
            fw.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        run();
    }
}
