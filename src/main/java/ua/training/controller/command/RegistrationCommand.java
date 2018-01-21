package ua.training.controller.command;

import ua.training.entity.User;
import ua.training.exception.IncorrectUserDataException;
import ua.training.exception.LoginAlreadyExistsException;
import ua.training.service.UserService;
import ua.training.util.ExceptionMessage;
import ua.training.util.constant.general.Pages;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.training.util.constant.general.Parameters.EXCEPTION;
import static ua.training.util.constant.table.UserConstants.DEFAULT_ROLE_ID;

public class RegistrationCommand implements Command {

    private UserService userService;

    public RegistrationCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            userService.register(
                    new User.UserBuilder()
                            .setFirstName(firstName)
                            .setLastName(lastName)
                            .setLogin(login)
                            .setEmail(email)
                            .setPassword(password)
                            .setRoleId(DEFAULT_ROLE_ID)
                            .buildUser()
            );
        } catch (LoginAlreadyExistsException | IncorrectUserDataException e) {
            request.getSession().setAttribute(EXCEPTION, ExceptionMessage.getMessage(e.getMessage()));
            return Pages.REGISTRATION_PAGE;
        }
        return Pages.REGISTRATION;
    }
}