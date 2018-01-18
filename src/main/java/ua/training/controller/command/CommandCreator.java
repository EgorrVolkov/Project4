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
        commandMap.put(SIGNIN_PAGE_COMMAND, new SignInPageCommand());
        commandMap.put(REGISTRATION_COMMAND, new RegistrationCommand());
        commandMap.put(REGISTRATION_PAGE_COMMAND, new RegistrationPageCommand());
        commandMap.put(LANGUAGE_COMMAND, new LanguageCommand());
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
