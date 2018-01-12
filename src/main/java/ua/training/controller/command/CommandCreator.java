package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static ua.training.util.constant.general.Commands.*;

public class CommandCreator {

    private Map<String, Command> commandMap = new HashMap<>();

    private CommandCreator() {
        commandMap.put(LOGIN_COMMAND, new LoginCommand());
        commandMap.put(REGISTRATION_PAGE_COMMAND, new RegistrationPageCommand());
    }

    private static class CommandFactoryHolder {
        private static final CommandCreator instance = new CommandCreator();
    }

    public static CommandCreator getInstance() {
        return CommandFactoryHolder.instance;
    }

    public String action(HttpServletRequest request, HttpServletResponse response) throws RuntimeException {
        String commandName = request.getParameter(COMMAND);
        Command command = commandMap.get(commandName);
        return command.execute(request, response);
    }
}
