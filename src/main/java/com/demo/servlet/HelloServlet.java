package com.demo.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Simple servlet — returns a greeting page.
 * URL: /hello?name=World
 */
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String name = req.getParameter("name");
        if (name == null || name.isBlank()) {
            name = "World";
        }

        String time = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head>");
        out.println("<title>Hello Servlet</title>");
        out.println("<link rel='stylesheet' href='css/style.css'>");
        out.println("</head><body>");
        out.println("<div class='container'>");
        out.println("<h1>👋 Hello, " + escapeHtml(name) + "!</h1>");
        out.println("<p>Servlet responded at: <strong>" + time + "</strong></p>");
        out.println("<a href='index.html' class='btn'>← Back to Home</a>");
        out.println("</div></body></html>");
    }

    private String escapeHtml(String s) {
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }
}
