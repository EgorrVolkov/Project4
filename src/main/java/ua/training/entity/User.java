package ua.training.entity;

import ua.training.dao.UserDao;
import ua.training.dao.factory.DaoFactory;
import ua.training.dao.factory.DataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class User implements Entity<Long> {
    private Long id;
    private String email;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private int roleId;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleNameByUserId() {
        DataSource dataSource = DataSourceFactory.getInstance().getDataSource();
        try (Connection connection = dataSource.getConnection()) {
            DaoFactory daoFactory = DaoFactory.getDaoFactory(connection);
            UserDao userDao = daoFactory.createUserDao();
            return userDao.getRoleNameByUserId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static final class UserBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private String login;
        private String email;
        private String password;
        private int roleId;

        public UserBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder setLogin(String login) {
            this.login = login;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setRoleId(int roleId) {
            this.roleId = roleId;
            return this;
        }

        public User buildUser() {
            User user = new User();
            user.setId(id);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setLogin(login);
            user.setEmail(email);
            user.setPassword(password);
            user.setRoleId(roleId);
            return user;
        }
    }
}
