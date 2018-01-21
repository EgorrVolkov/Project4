package ua.training.service.impl;

import ua.training.dao.UserDao;
import ua.training.dao.factory.DaoFactory;
import ua.training.dao.factory.DataSourceFactory;
import ua.training.entity.User;
import ua.training.exception.IncorrectUserDataException;
import ua.training.exception.LoginAlreadyExistsException;
import ua.training.exception.LoginNotFoundException;
import ua.training.service.UserService;
import ua.training.util.ConnectionUtil;
import ua.training.util.ExceptionMessage;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import static ua.training.util.ExceptionMessage.*;
import static ua.training.util.constant.general.Parameters.X_AUTH_TOKEN;

public class UserServiceImpl implements UserService {

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        return new UserServiceImpl();
    }

    @Override
    public User findByLogin(String login) throws LoginNotFoundException {
        User user = null;
        DataSource dataSource = DataSourceFactory.getInstance().getDataSource();
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            DaoFactory daoFactory = DaoFactory.getDaoFactory(connection);
            UserDao userDao = daoFactory.createUserDao();
            user = userDao.findByLogin(login);
            if (user == null) {
                throw new LoginNotFoundException(login, ExceptionMessage.LOGIN_NOT_FOUND_ERROR);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User register(User user) throws LoginAlreadyExistsException, IncorrectUserDataException {
        validation(user);
        User savedUser = null;
        DataSource dataSource = DataSourceFactory.getInstance().getDataSource();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            DaoFactory daoFactory = DaoFactory.getDaoFactory(connection);
            UserDao userDao = daoFactory.createUserDao();
            savedUser = userDao.save(user);
            connection.commit();
        } catch (SQLIntegrityConstraintViolationException e) {
            ConnectionUtil.rollback(connection);
            throw new LoginAlreadyExistsException(ExceptionMessage.LOGIN_EXIST_ERROR);
        } catch (SQLException e) {
            ConnectionUtil.rollback(connection);
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(connection);
        }
        return savedUser;
    }

    @Override
    public User getCurrentUser(HttpServletRequest request) {
        Long id = (Long) request.getSession().getAttribute(X_AUTH_TOKEN);
        User user = null;
        DataSource dataSource = DataSourceFactory.getInstance().getDataSource();
        try (Connection connection = dataSource.getConnection()) {
            DaoFactory daoFactory = DaoFactory.getDaoFactory(connection);
            UserDao userDao = daoFactory.createUserDao();
            user = userDao.findOne(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void validation(User user) throws IncorrectUserDataException {
        if (!isLoginValid(user.getLogin())) {
            throw new IncorrectUserDataException(LOGIN_PATTERN_ERROR);
        }
        if (!isPasswordValid(user.getPassword())) {
            throw new IncorrectUserDataException(PASSWORD_PATTERN_ERROR);
        }
    }

    boolean isLoginValid(String login) {
        final String regex = "[A-Za-z0-9-]+";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher m = p.matcher(login);
        return m.matches();
    }

    boolean isPasswordValid(String password) {
        final String regex = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher m = p.matcher(password);
        return m.matches();
    }
}
