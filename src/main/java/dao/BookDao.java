package dao;

import com.Book;
import jdbc.Util;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDao {

     Connection connection = null;
 public  void  addBook(Book book) {

     connection = Util.getConnection();
     String addsql = "INSERT INTO book VALUE (?,?)";
     PreparedStatement p = null;
     try {
         p = connection.prepareStatement(addsql);
         p.setString(1, book.getName());
         p.setDouble(2, book.getPrice());
         p.execute();
     } catch (SQLException e) {
         e.printStackTrace();
     }finally {
         try {
             connection.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }

 }

@Test
public void test(){
     Book book = new Book();
     book.setName("bb");
     book.setPrice(12.3);
     addBook(book);


}

}
