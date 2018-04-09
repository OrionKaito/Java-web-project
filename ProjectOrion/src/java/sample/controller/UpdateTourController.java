/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import sample.dao.TourCategoryDAO;
import sample.dao.TourDAO;
import sample.dao.TourVSTourCategoryDAO;
import sample.dto.TourCategoryDTO;
import sample.dto.TourDTO;
import sample.dto.TourVSTourCategoryDTO;
import sample.ulti.ulti;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 5)
public class UpdateTourController extends HttpServlet {

    private static final String SAVE_DIR = "images";
    private static final String error = "error.jsp";
    private static final String update = "updatetour.jsp";
    private static final String success = "SearchTourController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = error;
        try {
            String search = request.getParameter("txtSearch");
            request.setAttribute("lastSearch", search);
            String action = request.getParameter("action");
            TourDAO dao = new TourDAO();
            if (action.equals("Edit Tour")) {
                url = update;
                String id = request.getParameter("txtID");
                List<TourDTO> dto = dao.findByID(id);
                request.setAttribute("INFO", dto);

                TourCategoryDAO categoryDAO = new TourCategoryDAO();
                List<TourCategoryDTO> result = categoryDAO.getAllCategoryName();
                request.setAttribute("CATEGORY", result);

                TourVSTourCategoryDAO tvtdao = new TourVSTourCategoryDAO();
                List<TourVSTourCategoryDTO> otherResult = tvtdao.findRelateCategory(id);
                request.setAttribute("TVTINFO", otherResult);
            } else if (action.equals("Update Tour")) {
                try {
                    
                    String filepath, filename;
                    Part part = request.getPart("image");
                    filename = ulti.extractfilename(part);
                    if (filename.equals("") || filename.length() == 0) {
                        filepath = request.getParameter("txtFilepath");
                        filename = request.getParameter("txtFilename");
                    } else {
                        //Create object instance for image
                        String savepath = "C:\\Users\\Orion\\Desktop\\Study reresource\\PRJ321\\ProjectOrion\\web"
                                + File.separator + SAVE_DIR;
                        File fileSaveDir = new File(savepath);
                        if (!fileSaveDir.exists()) {
                            fileSaveDir.mkdir();
                        }
                        filename = ulti.extractfilename(part);
                        part.write(savepath + File.separator + filename);
                        filepath = savepath + File.separator + filename;
                    }
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
                    java.sql.Date sqlDate = (java.sql.Date) new java.sql.Date(utilDate.getTime());

                    TourDTO dto = new TourDTO(tourID, tourname, price, description, filepath, start, arrival, maxCustomer, sqlDate, filename);
                    TourVSTourCategoryDAO tvtdao = new TourVSTourCategoryDAO();
                    tvtdao.deleteRelateCategory(tourID);
                    TourDAO Tdao = new TourDAO();
                    boolean check = Tdao.update(dto);
                    boolean check1 = true;
                    if (!check && !check1) {
                        request.setAttribute("ERROR", "Error occur!!! Can't update tour, please try again later.");
                    } else {
//                Insert categoryid and tourid into TourVSTourCategory table
                        String[] categoryID = request.getParameterValues("chekCategory");
                        TourVSTourCategoryDAO tvtDAO = new TourVSTourCategoryDAO();
                        for (String tourcategoryID : categoryID) {
                            check1 = tvtDAO.insert(tourID, tourcategoryID);
                            if (!check1) {
                                break;
                            }
                        }
                    }
                    if (!check && !check1) {
                        url = error;
                        request.setAttribute("ERROR", "Error occur!!! Can't create new tour, please try again later.");
                    } else {
                        url = success;
                        request.setAttribute("ActionDone", "Update tour successful");
                    }
                } catch (Exception e) {
                }
            } else {
                request.setAttribute("ERROR", "Some error has occur");
            }
        } catch (Exception e) {
            log("ERROR at UpdateTourController " + e.getMessage());
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
