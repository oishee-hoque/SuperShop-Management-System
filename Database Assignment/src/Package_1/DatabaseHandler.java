/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Package_1;

/**
 *
 * @author student
 */
import java.awt.Component;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DatabaseHandler {
    Connection connect = null;
    Statement statement = null;
    PreparedStatement pStatement = null;
    ResultSet result = null;

    public boolean setConnection(String dbN,String userN,String pass) {

        try {

            String dbName = dbN;
            String user = userN;
            String password = pass;
            String url = "jdbc:mysql://localhost/" + dbName;

            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, password);

            //System.out.println("Successfully Connected..");
            return true;

        } catch (Exception e) {
            return false;
        }

    }
    public ResultSet testQuery(String tbName) {

        try {

            String query = "SELECT * FROM "+tbName;
            statement = connect.createStatement();
            result = statement.executeQuery(query);
           // showResult(result);
           // System.out.println("Query is successful");
            return result;

        } catch (Exception e) {
            //System.out.println("Query is problematic..");
            //e.printStackTrace();
            return null;
        }
    }
     public ResultSet query1(String year) {

        try {

            String sql="SELECT month,sum(total) as Total FROM payment WHERE year="+ year+" group by month";
            statement = connect.createStatement();
            result = statement.executeQuery(sql);
           // System.out.println(sql);
          //  showResult(result);
            
            return result;

        } catch (Exception e) {
            //System.out.println("Query is problematic..");
            //e.printStackTrace();
            return null;
        }
    }
     public ResultSet query2(String year,String month) {

        try {

            String sql="SELECT name,sum(got.num) as Total_SALE,payment.month FROM product INNER JOIN got ON product.p_id=got.p_id INNER JOIN payment on got.pay_no=payment.pay_no WHERE payment.month='"+month+"' AND year="+year+" GROUP BY got.p_id order by Total_SALE ASC";
            statement = connect.createStatement();
            result = statement.executeQuery(sql);
            System.out.println(sql);
          //  showResult(result);
            
            return result;

        } catch (Exception e) {
            //System.out.println("Query is problematic..");
            //e.printStackTrace();
            return null;
        }
    }
     public ResultSet query3(String dis,String ar) {

        try {

            String sql="SELECT product.name,sales.num FROM product INNER JOIN sales ON product.p_id=sales.p_id INNER JOIN branch ON sales.branch_id=branch.branch_id WHERE branch.district='"+dis+"' AND branch.address='"+ar+"'";
            statement = connect.createStatement();
            result = statement.executeQuery(sql);
            System.out.println(sql);
          //  showResult(result);
            
            return result;

        } catch (Exception e) {
            //System.out.println("Query is problematic..");
            //e.printStackTrace();
            return null;
        }
    }
     public ResultSet query4(String dis,String ar) {

        try {

            String sql="SELECT Employee_name,Age,Phone_no,Catagory,Gender,Salary FROM employee INNER JOIN branch ON employee.branch_id=branch.branch_id WHERE branch.district='"+dis+"' AND branch.address='"+ar+"'";
            statement = connect.createStatement();
            result = statement.executeQuery(sql);
            System.out.println(sql);
          //  showResult(result);
            
            return result;

        } catch (Exception e) {
            //System.out.println("Query is problematic..");
            //e.printStackTrace();
            return null;
        }
    }
     public ResultSet query5(String year) {

        try {

            String sql="SELECT branch.district,branch.address,sum(total) as Total,payment.year FROM branch INNER JOIN payment on branch.branch_id=payment.branch_id WHERE payment.year="+year +" Group BY payment.branch_id Order BY Total DESC";
            statement = connect.createStatement();
            result = statement.executeQuery(sql);
           // System.out.println(sql);
          //  showResult(result);
            
            return result;

        } catch (Exception e) {
            //System.out.println("Query is problematic..");
            //e.printStackTrace();
            return null;
        }
    }
    public boolean closeDatabase(){
        try {
            connect.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void showResult(ResultSet result) {

        try {
            ArrayList<String> colName = new ArrayList<String>();
            for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
                colName.add(result.getMetaData().getColumnName(i));
            }

            while (result.next()) {
                String ss = "";
                for (String col : colName) {
                    ss += result.getString(col);
                    ss += " ";
                }
                System.out.println(ss);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public boolean insertData(String query){
        
        try{
          //  String query = "INSERT INTO student VALUES(?,?,?,?)";
            /*pStatement = connect.prepareStatement(query);
            pStatement.setString(1, id);
            pStatement.setString(2, name);
            pStatement.setString(3, dept);
            pStatement.setString(4, totCred);*/
            statement = connect.createStatement();
            statement.executeUpdate(query);
            //pStatement.executeUpdate();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean updateData(String query){
        
        System.out.println(query);
        try{
          //  String query = "INSERT INTO student VALUES(?,?,?,?)";
            /*\pStatement = connect.prepareStatement(query);
            pStatement.setString(1, id);
            pStatement.setString(2, name);
            pStatement.setString(3, dept);
            pStatement.setString(4, totCred);*/
            
            statement = connect.createStatement();
            statement.executeUpdate(query);
            //pStatement.executeUpdate();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean deleteData(String tb,String col,String data){
        try {
//            
            String query = "DELETE FROM "+tb+" WHERE "+col+"= '"+data+"'";
            pStatement = connect.prepareStatement(query);
            pStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public DatabaseMetaData getTableName()
    {
        try {
            DatabaseMetaData md = connect.getMetaData();
            return md;
        } catch (Exception e) {
            return null;
        }     
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
