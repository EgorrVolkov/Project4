package ua.training.controller.command;

import ua.training.entity.Role;
import ua.training.entity.User;
import ua.training.service.UserService;
import ua.training.util.constant.general.Pages;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.training.util.constant.general.Global.*;
import static ua.training.util.constant.general.Parameters.*;


public class LoginCommand implements Command {

    private UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);
        User user = null;
        user = userService.findByEmail(email); // TODO try-catch LoginNotFoundException
        setUserRolesIntoSession(request, user);
        return Pages.LOGIN;
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
