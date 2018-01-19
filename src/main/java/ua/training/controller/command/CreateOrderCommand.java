package ua.training.controller.command;

import ua.training.util.constant.general.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.training.util.constant.general.Parameters.*;

public class CreateOrderCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String deviceName = request.getParameter(DEVICE_NAME);
        String devicePrice = request.getParameter(DEVICE_PRICE); // TODO rework, need int?
        String deviceBreakage = request.getParameter(DEVICE_BREAKAGE);
        return Pages.SIGNIN;
    }
}
