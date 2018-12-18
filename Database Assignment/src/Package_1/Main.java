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
public class Main {
    public static void main (String arg[]){
      
       DatabaseHandler d=new DatabaseHandler();
        d.setConnection("supershop","root","");
        Welcome db=new Welcome(d);
      // DatabaseManage db = new DatabaseManage(d);
        //db.insertData();
       // db.testQuery();
       // db.closeConnection();
        //QueryGen d= new QueryGen();
        db.setVisible(true);
       
    }
}
