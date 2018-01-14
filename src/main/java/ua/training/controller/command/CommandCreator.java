package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ua.training.util.constant.general.Commands.*;

public class CommandCreator {

    private Map<String, Command> commandMap = new HashMap<>();

    private CommandCreator() {
        commandMap.put(LOGIN_COMMAND, new LoginCommand());
        commandMap.put(LOGIN_PAGE_COMMAND, new LoginPageCommand());
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
        // TODO refactor, move all logic components into own methods!!!
        String commandName = request.getParameter(COMMAND);

        Command command;
        if(commandName == null) {
            if(request.getSession().getAttribute("page") != null) { // TODO REWORK, lambdas!!!!
                // TODO maybe make a method for this expression: request.getSession().getAttribute("page") ?
                Pattern findPageName = Pattern.compile("[^/.]+(?=\\.[^.]+)");
                Matcher pageURL = findPageName.matcher((String)request.getSession().getAttribute("page")); // TODO refactor.rename, it's not URL probably!
                if(pageURL.find())
                    command = commandMap.get(pageURL.group(0));
                else command = commandMap.get(ERROR_PAGE); // TODO stub, rework somehow!
            }
            else
                command = commandMap.get(LOGIN_PAGE_COMMAND);
        }
        else
            command = commandMap.get(commandName);
        return command.execute(request, response);
    }
}
