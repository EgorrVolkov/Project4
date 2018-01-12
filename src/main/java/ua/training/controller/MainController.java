package ua.training.controller;

import ua.training.controller.command.CommandCreator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class MainController extends HttpServlet {

    private static CommandCreator commandCreator = CommandCreator.getInstance();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String pageToRedirectOn;
        pageToRedirectOn = commandCreator.action(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher(pageToRedirectOn);
        dispatcher.forward(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
/*        String pageToRedirectOn;
        pageToRedirectOn = commandCreator.action(request, response);*/
    }
}
