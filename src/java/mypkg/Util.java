package mypkg;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
    public static Connection connect(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/pgdata";
            con=DriverManager.getConnection(url,"root","root");
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
    
}
