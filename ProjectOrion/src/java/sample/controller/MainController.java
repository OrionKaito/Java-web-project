/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Orion
 */
@MultipartConfig
public class MainController extends HttpServlet {

    private static final String error = "error.jsp";
    private static final String login = "LoginController";
    private static final String searchusername = "SearchUserController";
    private static final String register = "RegisterController";
    private static final String createtour = "CreateTourController";
    private static final String createtourcategory = "CreateTourCategoryController";
    private static final String deleteruser = "DeleteUserController";
    private static final String searchtour = "SearchTourController";
    private static final String prodemote = "ProdemoteController";
    private static final String deleletour = "DeleteTourController";
    private static final String updatetour = "UpdateTourController";
    private static final String homecontroller = "HomeController";
    private static final String cart = "CartController";
    private static final String logout = "LogOutController";
    private static final String editaccount = "EditAccountController";
    private static final String updateaccount = "EditAccountController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = error;
        try {
            String action = request.getParameter("action");
            if (action.equals("Login")) {
                url = login;
            } else if (action.equals("Register")) {
                url = register;
            } else if (action.equals("Create Tour")) {
                url = createtour;
            } else if (action.equals("Create Category")) {
                url = createtourcategory;
            } else if (action.equals("Search Username")) {
                url = searchusername;
            } else if (action.equals("Delete User")) {
                url = deleteruser;
            } else if (action.equals("Search Tour")) {
                url = searchtour;
            } else if (action.equals("prodemote")) {
                url = prodemote;
            } else if (action.equals("Delete Tour")) {
                url = deleletour;
            } else if (action.equals("Edit Tour")) {
                url = updatetour;
            } else if (action.equals("Update Tour")) {
                url = updatetour;
            } else if (action.equals("Find Tour")) {
                url = homecontroller;
            } else if (action.equals("Add to cart")) {
                url = cart;
            } else if (action.equals("Log out")) {
                url = logout;
            } else if (action.equals("Edit Account")) {
                url = editaccount;
            } else if (action.equals("Update Account")) {
                url = updateaccount;
            } else if (action.equals("View Cart")) {
                url = cart;
            }else if (action.equals("Delete cart")){
                url = cart;
            }else {
                request.setAttribute("ERROR", "Action not supported");
            }
        } catch (Exception e) {
            log("ERROR at MainController: " + e.getMessage());
        } finally {
            request.setAttribute("DONE", "done");
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
