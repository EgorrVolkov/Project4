package ua.training.service;

import ua.training.service.impl.UserServiceImpl;

public class ServiceFactory {
    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return new ServiceFactory();
    }

/*    public OrderService createOrderService() { // TODO
        return OrderServiceImpl.getInstance();
    }*/

    public UserService createUserService() {
        return UserServiceImpl.getInstance();
    }
}
