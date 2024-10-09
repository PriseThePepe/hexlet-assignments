package exercise.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // BEGIN
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/plain");
       String name = "Guest";
       if(req.getParameter("name") != null) {
           name = req.getParameter("name");
       }
       String message = "Hello, " + name + "!";
       req.setAttribute("message",message);

        req.getRequestDispatcher("/WEB-INF/hello.jsp").forward(req, resp);
    }
    // END
}