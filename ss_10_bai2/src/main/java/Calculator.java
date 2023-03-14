import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Calculator", value = "/")
public class Calculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       double first=Double.parseDouble(request.getParameter("first"));
       double last=Double.parseDouble(request.getParameter("last"));
       String calculator= request.getParameter("phepTinh");
       double result=0;
       if (calculator.equals("cong")){
           result=first+last;
       } else if (calculator.equals("tru")) {
           result=first-last;
       } else if (calculator.equals("nhan")) {
           result=first*last;
       }else {
           result=first/last;
       }
       request.setAttribute("results",result);
       request.setAttribute("firsts",first);
       request.setAttribute("lasts",last);
       request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
