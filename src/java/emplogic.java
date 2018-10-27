
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aditya
 */
class emplogic {
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/prac?autoReconnect=true&useSSL=false", "root", "root123");
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.print(e);
                    
        }
        return con;  
    }
    public static int save(empgetset e){
        int status=0;
        try{
            Connection con=emplogic.getConnection();
            PreparedStatement ps=con.prepareStatement("insert in practice(username,pass) values(?,?)");
            ps.setString(1,e.getEmpname());
            ps.setString(1,e.getPassword());
            status=ps.executeUpdate();  
              
            con.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }  
          
        return status; 
    }
}
