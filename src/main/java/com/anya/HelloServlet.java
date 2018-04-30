package com.anya;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet (name = "HelloServlet",
        urlPatterns = {"/hello"},
        loadOnStartup = 1)
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("landing.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(
                "username", Optional.ofNullable(request.getParameter("username"))
                        .filter(StringUtils::isNotBlank).orElse("Anonymous")
        );
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}