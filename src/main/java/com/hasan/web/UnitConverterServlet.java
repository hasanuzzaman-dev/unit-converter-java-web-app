package com.hasan.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/convert")
public class UnitConverterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/convert.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var unit = req.getParameter("unit");

        if (unit != null && unit.length() > 0) {
            double unitInMeter = Double.parseDouble(unit);
            double unitInCentimeter = unitInMeter * 100;

            req.setAttribute("result", unitInCentimeter);
        }

        req.getRequestDispatcher("/WEB-INF/result.jsp").forward(req, resp);
    }
}
