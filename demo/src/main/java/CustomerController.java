import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Customer", value = "/Customer")
public class CustomerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList=new ArrayList<>();
        customerList.add(new Customer("Phạm Hoàng Hải", "1993","Huế","https://lh3.googleusercontent.com/KxFFI-K8kF89UYIeCQkIU-VF1JEXHuf1Zd0tpzAmN1eScy0e-8fs_mw2FpwdR-_FQI7jnyP1ahJT3sK4KZKWOCoZuLKKECBKLB0YR5MZ=w752"));
        customerList.add(new Customer("Nguyễn Minh Lãnh","1990","Quảng Nam","https://lh3.googleusercontent.com/KxFFI-K8kF89UYIeCQkIU-VF1JEXHuf1Zd0tpzAmN1eScy0e-8fs_mw2FpwdR-_FQI7jnyP1ahJT3sK4KZKWOCoZuLKKECBKLB0YR5MZ=w752"));
        customerList.add(new Customer("Lê Văn Chính","2003","Quảng Bình","https://lh3.googleusercontent.com/KxFFI-K8kF89UYIeCQkIU-VF1JEXHuf1Zd0tpzAmN1eScy0e-8fs_mw2FpwdR-_FQI7jnyP1ahJT3sK4KZKWOCoZuLKKECBKLB0YR5MZ=w752"));
        customerList.add(new Customer("Nguyễn Văn Minh","1999","Nghệ An","https://lh3.googleusercontent.com/KxFFI-K8kF89UYIeCQkIU-VF1JEXHuf1Zd0tpzAmN1eScy0e-8fs_mw2FpwdR-_FQI7jnyP1ahJT3sK4KZKWOCoZuLKKECBKLB0YR5MZ=w752"));
        customerList.add(new Customer("Nguyễn Quốc Anh","2001","Quảng Trị","https://lh3.googleusercontent.com/KxFFI-K8kF89UYIeCQkIU-VF1JEXHuf1Zd0tpzAmN1eScy0e-8fs_mw2FpwdR-_FQI7jnyP1ahJT3sK4KZKWOCoZuLKKECBKLB0YR5MZ=w752"));
        request.setAttribute("listCustomer",customerList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
