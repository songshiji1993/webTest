import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.User;

public class servletTest extends HttpServlet {

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=UTF-8");
//
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
//
//        User user = new User(name,password);
//        System.out.println(user.toString());
//        System.out.println("-----------------------*---------------------------------");
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doPost(request, response);
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=UTF-8");
//
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
//
//        User user = new User(name,password);
//        System.out.println(user.toString());
//        System.out.println("-----------------------*---------------------------------");
////        response.getR
//    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.service(req, resp);
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String url = request.getRequestURI();
        String action = url.substring(url.lastIndexOf("/"),url.length());
        String password = request.getParameter("password");


        System.out.println("地址="+url);
        System.out.println("action="+action);
        User user = new User(name,password);
//        System.out.println(user.toString());
        System.out.println("-----------------------*---------------------------------");
        request.setAttribute("user",user);
        request.setAttribute("s","yyyy");
        request.getRequestDispatcher("eee.jsp").forward(request,response);

        if(action.equals("/add")){
            System.out.println("--------------to----------------add----------");
            String p = request.getParameter("price");
            Double price = Double.parseDouble(p);
            String bookName = request.getParameter("bookName");
            request.getRequestDispatcher("/jsp/add.jsp").forward(request,response);




        } if(action.equals("/delete")){

        } if(action.equals("/modify")){

        } if(action.equals("/list")){

        }






















    }
}
