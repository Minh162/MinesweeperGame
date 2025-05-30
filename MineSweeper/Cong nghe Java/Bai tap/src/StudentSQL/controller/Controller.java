package StudentSQL.controller;

import StudentSQL.model.ConnectToSQLServer;
import StudentSQL.model.SinhVien;

import java.util.ArrayList;

public class Controller {
    private ArrayList<SinhVien> a;

    public Controller() {
        a = new ArrayList<>();
        new ConnectToSQLServer().getData();
        try {
            while (ConnectToSQLServer.rs.next()) {
                a.add(new SinhVien(ConnectToSQLServer.rs.getString(1), ConnectToSQLServer.rs.getString(2), ConnectToSQLServer.rs.getString(3)));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        System.out.println(a);
    }
}
