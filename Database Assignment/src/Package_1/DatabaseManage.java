/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package_1;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Anonymous
 */
public class DatabaseManage extends javax.swing.JFrame {

    /**
     * Creates new form DatabaseManage
     */
    DatabaseHandler dbhOb;
    public DatabaseManage() {
        initComponents();
        
    }
    public DatabaseManage(DatabaseHandler ob){
        initComponents();
        
        dbhOb = ob;
        showTable();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dbClose = new javax.swing.JButton();
        showResult = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        tableList = new javax.swing.JComboBox<>();
        insertData = new javax.swing.JButton();
        delRec = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        go = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dbClose.setText("Close Database");
        dbClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbCloseActionPerformed(evt);
            }
        });
        getContentPane().add(dbClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 140, 30));

        showResult.setText("Show Result");
        showResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showResultActionPerformed(evt);
            }
        });
        getContentPane().add(showResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 140, 30));

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        dataTable.setPreferredSize(new java.awt.Dimension(300, 600));
        jScrollPane1.setViewportView(dataTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 530, 500));

        tableList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select A Table" }));
        tableList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableListActionPerformed(evt);
            }
        });
        getContentPane().add(tableList, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 140, 30));

        insertData.setText("Insert Data");
        insertData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertDataActionPerformed(evt);
            }
        });
        getContentPane().add(insertData, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 140, 30));

        delRec.setText("Delete Record");
        delRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delRecActionPerformed(evt);
            }
        });
        getContentPane().add(delRec, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 140, 30));

        jButton1.setText("Update Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 140, 30));

        go.setText("Query");
        go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goActionPerformed(evt);
            }
        });
        getContentPane().add(go, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 140, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Package_1/supershop-logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 4, 130, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents
DatabaseHandler ob = new DatabaseHandler();
    private void dbCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbCloseActionPerformed
        // TODO add your handling code here:
        if(dbhOb.closeDatabase())
        {
             JOptionPane.showMessageDialog(null,"Successfully Closed Your Database !!");
             new DatabaseManage().setVisible(true);
        }
        else
        {
             JOptionPane.showMessageDialog(null,"There have problem in closing Database !!");
        }
        
    }//GEN-LAST:event_dbCloseActionPerformed

    private void showResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showResultActionPerformed
        // TODO add your handling code here:
        String tbName = tableList.getSelectedItem().toString();
        if(tbName.equalsIgnoreCase("Select A Table"))
        {
            JOptionPane.showMessageDialog(null,"Please select a table !!");
        }
        else
        {
            
            try {
                //dataTable.setModel(DbUtils.resultSetToTableModel(rs));
                ResultSet rs = dbhOb.testQuery(tbName);
              //  System.out.println("yes");
                dataTable.setModel(buildTableModel(rs));
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseManage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }//GEN-LAST:event_showResultActionPerformed

    private void insertDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertDataActionPerformed
        // TODO add your handling code here:
        //this.setVisible(false);
        String tbName = tableList.getSelectedItem().toString();
        if(tbName.equalsIgnoreCase("Select A Table"))
        {
            JOptionPane.showMessageDialog(null,"Please select a table !!");
        }
        else
        {
            
           System.out.println(tbName);
          if(tbName.equals("employee"))
              new Employee(dbhOb).setVisible(true);
          else if(tbName.equals("payment"))
              new Payment(dbhOb).setVisible(true);
          else if(tbName.equals("branch"))
              new Branch(dbhOb).setVisible(true);
          else if(tbName.equals("onsale"))
              new onSale(dbhOb).setVisible(true);
          else if(tbName.equals("product"))
              new Product(dbhOb).setVisible(true);
          else if(tbName.equals("got"))
              new Got(dbhOb).setVisible(true);
          else if(tbName.equals("sales"))
              new Sales(dbhOb).setVisible(true);
        }
        //new AddStudentData(dbhOb).setVisible(true);
    }//GEN-LAST:event_insertDataActionPerformed

    private void delRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delRecActionPerformed
        // TODO add your handling code here:
       int r = dataTable.getSelectedRow();
       String data = dataTable.getValueAt(r, 0).toString();
       String col = dataTable.getColumnName(0).toString();
       String tbName = tableList.getSelectedItem().toString();
       if(dbhOb.deleteData(tbName, col, data))
       {
          // 
           JOptionPane.showMessageDialog(null,"Deleted !!");
       }
        ResultSet rs = dbhOb.testQuery(tbName);
        dataTable.setModel(DbUtils.resultSetToTableModel(rs));
    }//GEN-LAST:event_delRecActionPerformed

    private void tableListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableListActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_tableListActionPerformed

    private void goActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
        new QueryGen(dbhOb).setVisible(true);
    }//GEN-LAST:event_goActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int r = dataTable.getSelectedRow();
       String data = dataTable.getValueAt(r, 0).toString();
       String col = dataTable.getColumnName(0).toString();
       String tbName = tableList.getSelectedItem().toString();
        
        new Product(dbhOb,data,col,tbName).setVisible(true);
        //ResultSet rs = dbhOb.testQuery(tbName);
        //dataTable.setModel(DbUtils.resultSetToTableModel(rs));        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    ArrayList<String> tbName = new ArrayList<String>();
    public void showTable()
    {
         try {
            DatabaseMetaData md = dbhOb.getTableName();
            ResultSet rst = md.getTables(null, null, "%", null);
            tbName.add("Select A Table");
            while (rst.next()) {
              tbName.add(rst.getString(3));
            }
            
            tableList.setModel(new DefaultComboBoxModel( tbName.toArray()));
        }
        catch(Exception e){
            e.printStackTrace();
        }       
    }
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DatabaseManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatabaseManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatabaseManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatabaseManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                new DatabaseManage().setVisible(true);
            }
        });
    }
     public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
                System.out.println(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dataTable;
    private javax.swing.JButton dbClose;
    private javax.swing.JButton delRec;
    private javax.swing.JButton go;
    private javax.swing.JButton insertData;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton showResult;
    private javax.swing.JComboBox<String> tableList;
    // End of variables declaration//GEN-END:variables
}
