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
import sample.dao.RegistrationDAO;

/**
 *
 * @author Orion
 */
public class ProdemoteController extends HttpServlet {

    private static final String error = "SearchUserController";
    private static final String success = "SearchUserController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = error;
        String revertRole = "";
        try {
            boolean test = true;
            String username = request.getParameter("txtUsername");
            String role = request.getParameter("txtRole");
            if (username.equals("admin")) {
                request.setAttribute("ERROR", "Can't demote or premote this account");
            } else {
                RegistrationDAO dao = new RegistrationDAO();
                if (role.equals("admin")) {
                    revertRole = "user";
                } else if (role.equals("user")) {
                    revertRole = "admin";
                } else {
                    test = false;
                    request.setAttribute("ERROR", "This role is not supported");
                }
                if (test) {
                    boolean check = dao.updateRole(username, revertRole);
                    if (check) {
                        url = success;
                        request.setAttribute("ActionDone", "Update successful");
                    } else {
                        request.setAttribute("ERROR", "Some error has occur");
                    }
                }
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
