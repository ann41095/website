package com.anya;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet (name = "LoginServlet",
        urlPatterns = {"/login"},
        loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(
                "username", Optional.ofNullable(request.getParameter("username"))
                        .filter(StringUtils::isNotBlank).orElse("Anonymous")
        );
        request.getRequestDispatcher("welcome.jsp").forward(request,response);
    }
}