package baitap2021_04_23;

import java.util.ArrayList;

public class ArrayOfObjects {
    private final ArrayList<Integer> a;

    public ArrayOfObjects() {
        a = new ArrayList<>();
    }

    public int min() {
        int min = a.get(0);
        for (Integer i : a) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    public int max() {
        int max = a.get(0);
        for (Integer i : a) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public int sum() {
        int sum = 0;
        for (Integer i : a) {
            sum += i;
        }
        return sum;
    }

    public void add(int x) {
        a.add(x);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Integer i : a) {
            res.append(i).append(" ");
        }
        return res.toString();
    }
}
