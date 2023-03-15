package controller;

import model.User;
import service.IUserService;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "sort":
                sort(request, response);
            default:
                showList(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                search(request, response);
                break;
            case "create":
                create(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            default:
                showList(request, response);
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.delete(id);
        response.sendRedirect("/user");
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country = request.getParameter("country");
        List<User> list = userService.findByCountry(country);
        request.setAttribute("listUser", list);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> list = userService.findAll();
        request.setAttribute("listUser", list);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String country = request.getParameter("country");
        String email=request.getParameter("email");
        userService.insert(new User(id, name, country,email));
        response.sendRedirect("/user");
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("create.jsp");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("user", userService.findByID(id));
        request.getRequestDispatcher("/update.jsp").forward(request, response);

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String country = request.getParameter("country");
        String email=request.getParameter("email");
        User user = new User(id, name, country,email);
        userService.edit(id, user);
        response.sendRedirect("/user");
    }

    private void sort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> list = userService.sortByName();
        request.setAttribute("listUser", list);
        request.getRequestDispatcher("list.jsp").forward(request, response);

    }
}
