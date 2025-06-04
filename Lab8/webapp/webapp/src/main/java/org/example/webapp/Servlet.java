package org.example.webapp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class Servlet extends HttpServlet {

    private CatDAO catDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        catDAO = new CatDAO();
        catDAO.createTableIfNotExists();
        System.out.println("Servlet initialized with database connection");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Cat> cats = catDAO.getAllCats();
        request.setAttribute("cats", cats);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/cats.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String catName = request.getParameter("catName");
        String catBreed = request.getParameter("catBreed");
        String catAgeStr = request.getParameter("catAge");
        String catColor = request.getParameter("catColor");

        boolean success = false;

        if (catName != null && !catName.trim().isEmpty()) {
            try {
                int catAge = (catAgeStr != null && !catAgeStr.trim().isEmpty())
                        ? Integer.parseInt(catAgeStr) : 0;

                Cat cat = new Cat(catName.trim(),
                        catBreed != null ? catBreed.trim() : "Невідома",
                        catAge,
                        catColor != null ? catColor.trim() : "Невідомий");

                success = catDAO.addCat(cat);

            } catch (NumberFormatException e) {
                System.err.println("Invalid age format: " + catAgeStr);
            }
        }

        request.setAttribute("catName", catName);
        request.setAttribute("success", success);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/catSaved.jsp");
        dispatcher.forward(request, response);
    }
}