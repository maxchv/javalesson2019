package org.itstep;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class HomeServlet extends HttpServlet {

    public static final String LOGIN = "admin";
    public static final String PASSWORD = "123";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // получение данных отправленных пользователем
        String login = req.getParameter("login");
        String password = req.getParameter("password");
//        Enumeration<String> parameterNames = req.getParameterNames();
//        while(parameterNames.hasMoreElements()) {
//            String name = parameterNames.nextElement();
//            String[] values = req.getParameterValues(name);
//            System.out.println(name + " = " + String.join(", " , values));
//        }


        // формирование ответа пользователю
        PrintWriter writer = resp.getWriter();
        if (validData(login, password)) {
            writer.println("<h1 style='color: green'>Welcome " + login + "</h1>");
        } else {
            resp.setStatus(401);
            writer.println("<h1 style='color: red'>Wrong login or password</h1>" +
                    "<script>" +
                    "setTimeout(() => window.location = 'http://localhost:8080', 10000);" +
                    "</script>");
        }
    }

    private boolean validData(String login, String password) {
        return LOGIN.equals(login) && PASSWORD.equals(password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
