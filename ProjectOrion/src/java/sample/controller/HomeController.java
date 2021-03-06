/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.dao.TourDAO;
import sample.dto.TourDTO;

/**
 *
 * @author Orion
 */
public class HomeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int page = 1, maxResult = 4, total = 0;
        try {
            if (request.getParameter("page") != null) {
                page = (int) Integer.parseInt(request.getParameter("page"));
            }
            String search = "";
            if (request.getParameter("txtSearch") != null){
                search = request.getParameter("txtSearch");
            }
            request.setAttribute("lastSearch", search);
            TourDAO dao = new TourDAO();

            List<TourDTO> result;
            if (search.equals("") || search.length() == 0) {
                result = dao.getAllTourPaging((page - 1) * maxResult, maxResult);
                total = dao.countTour();
            } else {
                result = dao.findByLikeNamePaging(search, (page - 1) * maxResult, maxResult);
                total = dao.countTourSearch(search);
            }
            int noOfPages = (int) Math.ceil(total * 1.0 / maxResult);
            request.setAttribute("total", total);
            request.setAttribute("INFO", result);
            request.setAttribute("page", page);
            request.setAttribute("noOfPages", noOfPages);
        } catch (Exception e) {
            log("ERROR at SearchUserController " + e.getMessage());
        } finally {
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
