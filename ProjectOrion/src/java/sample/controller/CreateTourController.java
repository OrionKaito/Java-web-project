/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import sample.dao.TourDAO;
import sample.dao.TourVSTourCategoryDAO;
import sample.dto.TourDTO;
import sample.ulti.ulti;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 5)
public class CreateTourController extends HttpServlet {

    private static final String SAVE_DIR = "images";
    private static final String ERROR = "ProcessCreateTourController";
    private static final String SUCCESS = "ProcessCreateTourController";
    private static final String INVALID = "ProcessCreateTourController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            //Create object instance for image
            String savepath = "C:\\Users\\Orion\\Desktop\\Study reresource\\PRJ321\\ProjectOrion\\web"
                    + File.separator + SAVE_DIR;
            File fileSaveDir = new File(savepath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }

            Part part = request.getPart("image");
            String filename = ulti.extractfilename(part);
            part.write(savepath + File.separator + filename);

            String filepath = savepath + File.separator + filename;
            String tourID = request.getParameter("txtID");
            String tourname = request.getParameter("txtTourname");
            int price = Integer.parseInt(request.getParameter("intPrice"));
            String description = request.getParameter("txtDescription");
            String start = request.getParameter("txtStart");
            String arrival = request.getParameter("txtArrival");
            int maxCustomer = Integer.parseInt(request.getParameter("intMax"));
            String[] Strdate = request.getParameterValues("txtDate");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = sdf.parse(Strdate[0]);
            java.sql.Date sqlDate = (java.sql.Date)new java.sql.Date(utilDate.getTime());

            TourDTO dto = new TourDTO(tourID, tourname, price, description, filepath, start, arrival, maxCustomer, sqlDate, filename);
            TourDAO dao = new TourDAO();
            boolean check = dao.createTour(dto);
            boolean check1 = true;
            if (!check) {
                request.setAttribute("ERROR", "Error occur!!! Can't create new tour, please try again later.");
            } else {
//                Insert categoryid and tourid into TourVSTourCategory table
                String[] categoryID = request.getParameterValues("chekCategory");
                TourVSTourCategoryDAO tvtDAO = new TourVSTourCategoryDAO();
                for (String tourcategoryID : categoryID) {
                    check1 = tvtDAO.insert(tourID, tourcategoryID);
                    if(!check1) {
                        break;
                    }
                }
            }
            if (!check && !check1) {
                url = ERROR;
                request.setAttribute("ERROR", "Error occur!!! Can't create new tour, please try again later.");
            } else {
                url = SUCCESS;
                request.setAttribute("CREATEDONE", "Create tour successful");
            }

        } catch (Exception e) {
            url = ERROR;
            log("ERROR at CreateTourController " + e.getMessage());
            if (e.getMessage().contains("duplicate")) {
                url = INVALID;
                request.setAttribute("ERROR", "ID is exiested");
            }
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
