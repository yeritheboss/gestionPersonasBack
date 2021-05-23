/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.main;

import java.sql.*;


/**
 *
 * @author gerangelberroteran
 */
public class Main {
    public static void main(String[] args){
    String url="jdbc:mysql://localhost:3306/test?autoReconncect=true&useSSL=false";
    String user= "root";
    String password= "51720134b";
    String sql= "select * from test.persona";
  
    try{
          
    Connection myConn= DriverManager.getConnection(url, user, password);
            Statement mystmt= myConn.createStatement();
            ResultSet rs= mystmt.executeQuery(sql);
            
            while(rs.next()){
                System.out.println("persona: " + rs.getString("id_persona"));
            System.out.println("datos: " + rs.getString("nombre")+" " +rs.getString("apellido")+" " +rs.getString("telefono")
            +" "+rs.getString("email")
            );
            
            }
        }catch(SQLException e){
            e.printStackTrace();
        
        
        }
    
    }
}
