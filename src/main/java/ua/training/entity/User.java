package ua.training.entity;

import ua.training.entity.proxy.UserProxy;

import java.util.List;

public class User implements Entity<Long> {
    private Long id;
    private String email;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private List<Role> roles;
    //private List<Order> orders;

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    /*public List<Order> getOrders() {
        return orders;
    }*/

    /*public void setOrders(List<Order> orders) {
        this.orders = orders;
    }*/

    public static final class UserBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private String login;
        private String email;
        private String password;
        private List<Role> roles;
        //private List<Order> orders;

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

        public UserBuilder setRoles(List<Role> roles) {
            this.roles = roles;
            return this;
        }

/*        public UserBuilder setOrders(List<Order> orders) {
            this.orders = orders;
            return this;
        }*/

        public User buildUser() {
            User user = new User();
            user.setId(id);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setLogin(login);
            user.setEmail(email);
            user.setPassword(password);
            user.setRoles(roles);
            //user.setOrders(orders);
            return user;
        }

        public User buildUserProxy() {
            UserProxy user = new UserProxy();
            user.setId(id);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setLogin(login); // TODO necessary?
            user.setEmail(email);
            user.setPassword(password);
            user.setRoles(roles);
            //user.setOrders(orders);
            return user;
        }
    }
}
