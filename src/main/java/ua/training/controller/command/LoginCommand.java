package ua.training.controller.command;

import ua.training.util.constant.general.Pages;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return Pages.LOGIN;
    }
}
