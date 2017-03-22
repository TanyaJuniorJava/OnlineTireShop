package controller;

import dao.entity.User;
import hibernateFactory.Factory;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sergey on 30.08.2016.
 */
public class RegistrationServlet extends APIHandlerServlet.APIRequestHandler {

    public static final RegistrationServlet instance = new RegistrationServlet();


    public static RegistrationServlet getInstance() {
        return instance;
    }

    private RegistrationServlet() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
//        System.out.println("work");
//        return null;
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User();
        user.setEmail(email);
        user.setName(login);
        user.setPassword(password);
        Factory.getInstance().getUserDao().addUser(user);

        System.out.println("login: " + login + "; email: " + email + "; password: " + password);
        return null;
    }
}