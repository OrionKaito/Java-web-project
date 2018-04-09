/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.dao.TourDAO;
import sample.dto.CartObj;
import sample.dto.TourDTO;

/**
 *
 * @author Orion
 */
public class CartController extends HttpServlet {

    private static final String error = "error.jsp";
    private static final String add = "HomeController";
    private static final String view = "view.jsp";
    private static final String delete = "CartController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = error;
        try {
            String att = (String)request.getAttribute("SEARCH");
            String action = request.getParameter("action");
            if (action.equals("Add to cart")) {
                HttpSession session = request.getSession();
                CartObj cart = (CartObj) session.getAttribute("cart");
                if (cart == null) {
                    cart = new CartObj("Orion");
                }
                String id = request.getParameter("txtID");
                String name = request.getParameter("txtName");
                int price = Integer.parseInt(request.getParameter("txtPrice"));
                TourDTO dto = new TourDTO(id, name, price);
                cart.addToCart(dto);
                session.setAttribute("cart", cart);
                url = add;
            } else if (action.equals("View Cart") || att != null) {
                HttpSession session = request.getSession();
                CartObj cart = (CartObj) session.getAttribute("cart");
                List<TourDTO> list = new ArrayList<>();
                if (cart != null) {
                    for (TourDTO dto : cart.getCart().values()) {
                        list.add(dto);
                    }
                }
                request.setAttribute("INFO", list);
                url = view;
            } else if (action.equals("Delete cart")) {
                HttpSession session = request.getSession();
                CartObj cart = (CartObj) session.getAttribute("cart");
                String id = request.getParameter("txtID");
                cart.remove(id);
                session.setAttribute("cart", cart);
                request.setAttribute("SEARCH", "search");
                url = delete;
            }
        } catch (Exception e) {
            log("ERROR at AddToCartController: " + e.getMessage());
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
