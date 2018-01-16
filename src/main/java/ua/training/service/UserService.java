package ua.training.service;

import ua.training.entity.User;
/*import ua.training.exception.IncorrectUserDataException; // TODO
import ua.training.exception.LoginAlreadyExistsException;
import ua.training.exception.LoginNotFoundException;*/

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    User findByEmail(String email)/* throws LoginNotFoundException*/; // TODO

    User register(User user)/* throws LoginAlreadyExistsException, IncorrectUserDataException*/; // TODO

    User getCurrentUser(HttpServletRequest request);
}
