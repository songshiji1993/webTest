package dao;

import com.Book;
import jdbc.Util;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookDao {

     Connection connection = null;
     PreparedStatement p = null;
 public  void  addBook(Book book) {

     connection = Util.getConnection();
     String addSql = "INSERT INTO book VALUE (?,?)";
     try {
         p = connection.prepareStatement(addSql);
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

 public void deleteBook(String bookName){

     connection = Util.getConnection();
     String deleteSql = "delete from book where name = ? ";
     try {
         p = connection.prepareStatement(deleteSql);
         p.setString(1, bookName);
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

public List<Book> queryBook(){



     return  null;
}

public Book updateBook(Book book){


     return  null;

}













@Test
public void test(){
     Book book = new Book();
     book.setName("bb");
     book.setPrice(12.3);
    // addBook(book);
        deleteBook("bb");

}

}
