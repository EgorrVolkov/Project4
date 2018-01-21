package ua.training.controller.command;

import ua.training.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

import static ua.training.util.constant.general.Commands.*;

public class CommandCreator {

    private Map<String, Command> commandMap = new HashMap<>();
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    private CommandCreator() {
        commandMap.put(SIGNIN_COMMAND, new SignInCommand(serviceFactory.createUserService()));
        commandMap.put(INDEX_COMMAND, new IndexCommand()); // TODO crutch?
        commandMap.put(SIGNIN_PAGE_COMMAND, new SignInPageCommand());
        commandMap.put(REGISTRATION_COMMAND, new RegistrationCommand(serviceFactory.createUserService()));
        commandMap.put(REGISTRATION_PAGE_COMMAND, new RegistrationPageCommand());
        commandMap.put(LANGUAGE_COMMAND, new LanguageCommand());
        commandMap.put(MANAGER_PAGE_COMMAND, new ManagerPageCommand());
        commandMap.put(ENGINEER_PAGE_COMMAND, new EngineerPageCommand());
        commandMap.put(CREATE_ORDER_PAGE_COMMAND, new CreateOrderPageCommand());
        commandMap.put(ADD_DEVICE_PAGE_COMMAND, new AddDevicePageCommand());
        commandMap.put(SELECT_MODEL_PAGE_COMMAND, new SelectModelPageCommand());
        commandMap.put(VIEW_ORDERS_PAGE_COMMAND, new ViewOrdersPageCommand());
        commandMap.put(INPUT_SERIAL_NUMBER_PAGE_COMMAND, new InputSerialNumberPageCommand());
        commandMap.put(SELECT_BREAKAGE_PAGE_COMMAND, new SelectBreakagePageCommand());
    }

    private static class CommandFactoryHolder {
        private static final CommandCreator instance = new CommandCreator();
    }

    public static CommandCreator getInstance() {
        return CommandFactoryHolder.instance;
    }

    public String action(HttpServletRequest request, HttpServletResponse response) throws RuntimeException {
        String commandName = request.getParameter(COMMAND);
        Command command;
        if(commandName == null) {
                command = commandMap.get(SIGNIN_PAGE_COMMAND);
        }
        else
            command = commandMap.get(commandName);
        return command.execute(request, response);
    }
}
