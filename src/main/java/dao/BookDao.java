package dao;

import com.Book;
import jdbc.Util;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
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

public List<Book> queryBook() {
    connection = Util.getConnection();
    String sql = "select * from book";
    List<Book> books = new ArrayList<>();

    Statement st = null;
    try {
        st = connection.createStatement();
        ResultSet resultSet = st.executeQuery(sql);
        Book book;
        while (resultSet.next()) {
            book = new Book();
            book.setName(resultSet.getString("name"));
            book.setPrice(resultSet.getDouble("price"));
            books.add(book);
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    return books;
}

public Book updateBook(Book book){
    connection = Util.getConnection();
    String sql = "UPDATE book SET price=? WHERE name=?;";
    try {
        p = connection.prepareStatement(sql);
        p.setDouble(1,book.getPrice());
        p.setString(2,book.getName());
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


    return  null;

}













@Test
public void test(){
     Book book = new Book();
     List<Book> books = new ArrayList<>();
     books = queryBook();
    for (Book b:books
         ) {
        System.out.println(b.toString());

    }
     book.setName("bb");
     book.setPrice(12.3);
    // addBook(book);
//        deleteBook("bb");

}

}
