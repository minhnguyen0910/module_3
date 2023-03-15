package controller;

import modle.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                delete(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            default:
                display(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String action=request.getParameter("action");
      if (action==null){
          action="";
      }
      switch (action){
          case "edit":
              edit(request,response);
              break;
          default:
              display(request,response);
      }
    }
    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        userService.editByID(new User(id, name, email, country));
        response.sendRedirect("/user");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<User> userList = userService.findAll();
        User user1 = null;
        for (User user : userList) {
            if (user.getId() == id) {
                user1 = user;
                break;
            }
        }
        request.setAttribute("user", user1);
        request.getRequestDispatcher("/edit.jsp").forward(request, response);
    }




    private void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.findAll();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/lists.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteByID(id);
        response.sendRedirect("/user");
    }

}
