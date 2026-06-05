package com.demo.servlet;

import com.demo.MathUtils;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Calculator servlet — uses MathUtils to perform basic arithmetic.
 * POST /calculate  with params: a, b, op (add|subtract|multiply|divide)
 */
public class CalculatorServlet extends HttpServlet {

    private final MathUtils math = new MathUtils();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String aStr = req.getParameter("a");
        String bStr = req.getParameter("b");
        String op   = req.getParameter("op");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html><html><head>");
        out.println("<title>Calculator Result</title>");
        out.println("<link rel='stylesheet' href='css/style.css'>");
        out.println("</head><body><div class='container'>");
        out.println("<h1>🧮 Calculator</h1>");

        try {
            double a = Double.parseDouble(aStr);
            double b = Double.parseDouble(bStr);
            double result;
            String symbol;

            switch (op) {
                case "add":      result = math.add((int)a, (int)b); symbol = "+"; break;
                case "subtract": result = math.subtract((int)a, (int)b); symbol = "−"; break;
                case "multiply": result = math.multiply((int)a, (int)b); symbol = "×"; break;
                case "divide":   result = math.divide(a, b); symbol = "÷"; break;
                default: throw new IllegalArgumentException("Unknown operation: " + op);
            }

            out.println("<p class='result'>" + a + " " + symbol + " " + b + " = <strong>" + result + "</strong></p>");

        } catch (NumberFormatException e) {
            out.println("<p class='error'>⚠ Please enter valid numbers.</p>");
        } catch (IllegalArgumentException e) {
            out.println("<p class='error'>⚠ Error: " + e.getMessage() + "</p>");
        }

        out.println("<a href='index.html' class='btn'>← Back to Home</a>");
        out.println("</div></body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.sendRedirect("index.html");
    }
}
