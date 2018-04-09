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
public class EditAccountController extends HttpServlet {

    private static final String error = "error.jsp";
    private static final String update = "useraccount.jsp";
    private static final String success = "useraccount.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = error;
        try {
            String action = request.getParameter("action");
            if (action.equals("Edit Account")) {
                String username = request.getParameter("txtUsername");
                RegistrationDAO dao = new RegistrationDAO();
                List<RegistrationDTO> result = dao.findByUsernameP(username);
                request.setAttribute("INFO", result);
                url = update;
            } else if (action.equals("Update Account")) {
                String username = request.getParameter("txtUsername");
                String password = request.getParameter("txtPassword");
                String phone = request.getParameter("txtPhone");
                String email = request.getParameter("txtEmail");
                String role = "user";
                RegistrationDTO dto = new RegistrationDTO(username, password, role, email, phone);
                RegistrationDAO dao = new RegistrationDAO();
                boolean check = dao.update(dto);
                if (check) {
                    request.setAttribute("CREATEDONE", "Update successful");
                    url = success;
                } else {
                    request.setAttribute("ERROR", "Error occur!!! Can't update account, please try again later.");
                }
            }
        } catch (Exception e) {
            log("ERROR at EditAccountController " + e.getMessage());
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
