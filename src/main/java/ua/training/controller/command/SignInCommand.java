package ua.training.controller.command;

import ua.training.entity.Role;
import ua.training.entity.User;
import ua.training.exception.LoginNotFoundException;
import ua.training.service.UserService;
import ua.training.util.ExceptionMessage;
import ua.training.util.constant.general.Pages;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.training.util.constant.general.Global.*;
import static ua.training.util.constant.general.Parameters.*;
import static ua.training.util.constant.general.Parameters.EXCEPTION;


public class SignInCommand implements Command {

    private UserService userService;

    public SignInCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        User user = null;
        try {
            user = userService.findByLogin(login);
        } catch (LoginNotFoundException e) {
            request.getSession().setAttribute(EXCEPTION,
                    ExceptionMessage.getMessage(e.getMessage()));
            return Pages.SIGNIN_PAGE;
        }
        if (user == null || !user.getPassword().equals(password)) {
            request.getSession().setAttribute(EXCEPTION,
                    ExceptionMessage.getMessage(ExceptionMessage.WRONG_PASSWORD_ERROR));
            return Pages.SIGNIN_PAGE;
        }
        request.getSession().setAttribute(X_AUTH_TOKEN, user.getId());
        setUserRolesIntoSession(request, user);
        return Pages.SIGNIN;
    }

    private void setUserRolesIntoSession(HttpServletRequest request, User user) {
        for (Role role : user.getRoles()) {
            if (ADMIN_ROLE.equals(role.getName())) {
                request.getSession().setAttribute(ADMIN, true);
            } else if (USER_ROLE.equals(role.getName())) {
                request.getSession().setAttribute(USER, true);
            }
        }
    }
}
