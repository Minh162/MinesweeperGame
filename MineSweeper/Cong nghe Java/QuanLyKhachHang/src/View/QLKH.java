package View;

import java.sql.*;
import Model.ConnectDB;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class QLKH extends javax.swing.JFrame {

    final String header[] = {"Mã khách hàng", "Họ Tên", "Số điện thoại"};
    final DefaultTableModel tb = new DefaultTableModel(header, 0);
    
    ConnectDB connectionDB = new ConnectDB();
    Connection connection;
    
    public QLKH() {
        initComponents();
        loadTable();
    }
    
    // function load data from database
    public void loadTable(){
        try{
            connection = connectionDB.getConnection();
//            connection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLKhachHang;user=Hoang;password=07102003;encrypt=true;trustServerCertificate=true");
            int number;
            Vector row;
            String sql = "select * from KhachHang";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metadata = resultSet.getMetaData();
            number = metadata.getColumnCount(); // đếm số cột
            tb.setRowCount(0); // đặt lại số hàng về 0 khi có sự thay đổi dữ liệu
            while(resultSet.next()){
                row = new Vector();
                for(int i = 0; i <= number; i++){
                    row.addElement(resultSet.getString(i));
                }
                tb.addRow(row);
                tableKH.setModel(tb);tb.addRow(row);
            }
            statement.close();
            resultSet.close();
            connection.close();
        } catch (Exception e){
        }
        tableKH.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e){
                if(tableKH.getSelectedRow() >= 0){
                   txtMa.setText(tableKH.getValueAt(tableKH.getSelectedRow(), 1) + "");
                   txtTen.setText(tableKH.getValueAt(tableKH.getSelectedRow(), 2) + "");
                   txtSDT.setText(tableKH.getValueAt(tableKH.getSelectedRow(), 3) + "");
                }
            }
        });
        
    }
    
    // hàm này sẽ xóa trắng sau khi thêm, sửa, xóa
    private void deleteOld(){
        txtMa.setText("");
        txtTen.setText("");
        txtSDT.setText("");
        loadTable();
        txtMa.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKH = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("QLKH");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 7, -1, 22));

        jLabel2.setText("maKH");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 56, 37, -1));

        jLabel3.setText("tenKH");
        jLabel3.setName("tenKH"); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 96, 37, -1));

        jLabel4.setText("SDT");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 136, 37, -1));

        txtMa.setName("txtMa"); // NOI18N
        getContentPane().add(txtMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 53, 215, -1));
        txtMa.getAccessibleContext().setAccessibleName("txtMa");

        txtTen.setName("txtTen"); // NOI18N
        getContentPane().add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 93, 215, -1));
        txtTen.getAccessibleContext().setAccessibleName("txtTen");

        txtSDT.setName("txtSDT"); // NOI18N
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });
        getContentPane().add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 133, 215, -1));
        txtSDT.getAccessibleContext().setAccessibleName("txtSDT");

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        getContentPane().add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 211, -1, -1));
        btnCreate.getAccessibleContext().setAccessibleName("btnCreate");

        btnUpdate.setText("Update");
        btnUpdate.setName("btnUpdate"); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 211, -1, -1));
        btnUpdate.getAccessibleContext().setAccessibleName("btnUpdate");

        btnDelete.setText("Delete");
        btnDelete.setName("btnDelete"); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 271, -1, -1));
        btnDelete.getAccessibleContext().setAccessibleName("btnDelete");

        btnRead.setText("Read");
        btnRead.setName("btnRead"); // NOI18N
        getContentPane().add(btnRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 271, -1, -1));
        btnRead.getAccessibleContext().setAccessibleName("btnRead");

        tableKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "maKH", "tenKH", "SDT"
            }
        ));
        tableKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableKH);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 41, 428, 303));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        connection = connectionDB.getConnection();
        try{
            if(txtMa.getText().equals("") || txtTen.getText().equals("") || txtSDT.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Bạn cần nhập đủ dữ liệu");
            } else {
                Statement statement = connection.createStatement();
                String update_sql = "update KhachHang set tenKH = '"+txtTen.getText()+"', SDT = '"+txtSDT.getText()+"' where maKH = '"+txtMa.getText()+"'";
                int kq = statement.executeUpdate(update_sql);
                if(kq > 0){
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                    deleteOld();
                }
                statement.close();
            }
            connection.close();
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        connection = connectionDB.getConnection();
        try{
            if(txtMa.getText().equals("") || txtTen.getText().equals("") || txtSDT.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Bạn cần nhập đủ dữ liệu");
                // đây là bẫy lối nhập thiếu dữ liệu
            } else {
                // Bẫy lỗi trùng khóa chính
                StringBuffer sb = new StringBuffer();
                String sql_check_pk = "select makh from KhachHang where makh = '"+txtMa.getText()+"'";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql_check_pk);
                if(resultSet.next()){
                    sb.append("Khách này đã tồn tại!");
                }
                if(sb.length() > 0){
                    JOptionPane.showMessageDialog(this, sb.toString());
                } else {
                    String add_sql = "insert into KhachHang values ('"+txtMa.getText()+"','"+txtTen.getText()+"','"+txtSDT.getText()+"')";
                    statement = connection.createStatement();
                    int kq = statement.executeUpdate(add_sql);
                    if(kq > 0){
                        JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
                        deleteOld();
                    }
                }
                statement.close();
                resultSet.close();
            }
            connection.close();
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_btnCreateActionPerformed

    // đưa dữ liệu lên textField
    private void tableKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKHMouseClicked
        int nrow = tableKH.getSelectedRow();
        if(nrow >= 0){
            txtMa.setText(tableKH.getValueAt(nrow, 0) + "");
            txtTen.setText(tableKH.getValueAt(nrow, 1) + "");
            txtSDT.setText(tableKH.getValueAt(nrow, 2) + "");
            txtMa.setEnabled(false); // khóa nên không thể sửa
        }
    }//GEN-LAST:event_tableKHMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        connection = connectionDB.getConnection();
        try {
            String delete_sql = "delete KhachHang where maKH = '"+txtMa.getText()+"'";
            Statement statement = connection.createStatement();
            int check = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn xóa chứ?", "Thông báo!", JOptionPane.YES_NO_OPTION);
            if(check == JOptionPane.YES_OPTION){
                statement.executeUpdate(delete_sql);
                deleteOld();
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
            }
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLKH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableKH;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
