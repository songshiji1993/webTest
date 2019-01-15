package servlet;

import com.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class servletTestadd extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.service(req, resp);
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");


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
            request.getRequestDispatcher("/jsp/add.jsp").forward(request,response);




        } if(action.equals("/delete")){

        } if(action.equals("/modify")){

        } if(action.equals("/list")){

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
