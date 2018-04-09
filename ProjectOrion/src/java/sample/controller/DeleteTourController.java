/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.dao.TourDAO;
import sample.dao.TourVSTourCategoryDAO;

/**
 *
 * @author Orion
 */
public class DeleteTourController extends HttpServlet {

    private static final String error = "SearchTourController";
    private static final String success = "SearchTourController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = error;
        boolean check = false, check2 = false;
        try {
            String id = request.getParameter("txtID");
            TourDAO dao = new TourDAO();
            TourVSTourCategoryDAO tvtdao = new TourVSTourCategoryDAO();
            check2 = tvtdao.deleteRelateCategory(id);
            check = dao.deleteTour(id);
            if (check && check2) {
                url = success;
                request.setAttribute("ActionDone", "Delete successful");
            } else {
                request.setAttribute("ERROR", "Some error has occur");
            }
        } catch (Exception e) {
            log("ERROR at DeleteUserController " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
