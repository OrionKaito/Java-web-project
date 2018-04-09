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
import sample.dao.RegistrationDAO;
import sample.dto.RegistrationDTO;

/**
 *
 * @author Orion
 */
public class SearchUserController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int page = 1, maxResult = 10, total = 0;
        try {
            if (request.getParameter("page") != null) {
                page = (int) Integer.parseInt(request.getParameter("page"));
            }

            String search = request.getParameter("txtSearch");
            request.setAttribute("lastSearch", search);
            RegistrationDAO dao = new RegistrationDAO();

            List<RegistrationDTO> result;
            if (search.equals("")) {
                result = dao.getAllUsernamePaging((page - 1) * maxResult, maxResult);
                total = dao.countAccount();
            } else {
                result = dao.findByLikeUsernamePaging(search, (page - 1) * maxResult, maxResult);
                total = dao.countAccountSearch(search);
            }
            int noOfPages = (int) Math.ceil(total * 1.0 / maxResult);
            request.setAttribute("total", total);
            request.setAttribute("INFO", result);
            request.setAttribute("page", page);
            request.setAttribute("noOfPages", noOfPages);
        } catch (Exception e) {
            log("ERROR at SearchUserController " + e.getMessage());
        } finally {
            request.getRequestDispatcher("managecustomer.jsp").forward(request, response);
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
