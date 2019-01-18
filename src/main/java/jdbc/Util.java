package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    //test为masql数据库名字
    private  static  String url  = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&amp;characterEncoding=utf-8";
    private  static  String accout  = "root";
    private  static  String password  = "root";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");//加载驱动
            con = DriverManager.getConnection(
                    url, accout, password
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;

    }



    public static void closeConnection(Connection con){
        if(con !=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

        Connection connection = getConnection();


    }



}
