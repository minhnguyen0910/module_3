package vn.codegym;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculateDiscountServlet", urlPatterns = "/CalculateDiscountServlet")
public class CalculateDiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       double price= Double.parseDouble(request.getParameter("price"));
       double percent= Double.parseDouble(request.getParameter("percent"));
       double discountAmount=price*percent*0.01;
       double discountPrice=price-discountAmount;
       request.setAttribute("amount",discountAmount);
       request.setAttribute("prices",discountPrice);
       request.getRequestDispatcher("web.jsp").forward(request,response);
    }
}
