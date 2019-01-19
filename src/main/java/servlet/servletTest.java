package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.Book;
import com.User;
import dao.BookDao;
import jdbc.Util;

public class servletTest extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.service(req, resp);
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        BookDao bookDao = new BookDao();

        String url = request.getRequestURI();
        String action = url.substring(url.lastIndexOf("/"),url.length());
        String password = request.getParameter("password");


        System.out.println("地址="+url);
        System.out.println("action="+action);


        if(action.equals("/add")){
            System.out.println("--------------to----------------add----------");
            String p = request.getParameter("price");
            Double price = Double.parseDouble(p);
            String bookName = request.getParameter("bookName");
            Book book = new Book(bookName,price);
            System.out.println(book.toString());

            bookDao.addBook(book);

            request.getRequestDispatcher("jsp/admin.jsp").forward(request,response);



        } if(action.equals("/delete")){
            String bookName = request.getParameter("bookName");
            bookDao.deleteBook(bookName);
            request.getRequestDispatcher("jsp/admin.jsp").forward(request,response);

        } if(action.equals("/update")){

            String bookName = request.getParameter("bookName");
            Double price = Double.parseDouble(request.getParameter("price"));
            Book book = new Book(bookName,price);
            bookDao.updateBook(book);

            request.getRequestDispatcher("jsp/admin.jsp").forward(request,response);

        } if(action.equals("/list")){

            List<Book> books = new ArrayList<>();
            books = bookDao.queryBook();
            request.setAttribute("books",books);
            request.getRequestDispatcher("jsp/list.jsp").forward(request,response);



        }if(action.equals("/Test")){
            String name = request.getParameter("name");
            User user = new User(name,password);
//        System.out.println(user.toString());
            System.out.println("-----------------------*---------------------------------");
            request.setAttribute("user",user);
            request.setAttribute("s","yyyy");
            request.getRequestDispatcher("eee.jsp").forward(request,response);
        }






















    }
}
