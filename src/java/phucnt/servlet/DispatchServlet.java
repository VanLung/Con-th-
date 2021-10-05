/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucnt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class DispatchServlet extends HttpServlet {

    private final String ERROR_PAGE = "error.html";
    private final String LOGIN_CONTROLLER = "loginServlet";
    private final String CREATE_ACCOUNT_CONTROLLER = "CreateAccountServlet";
    private final String LOGOUT_CONTROLLER = "logoutServlet";
    private final String STARTUP_CONTROLLER = "StartupServlet";
    private final String SEARCH_CONTROLLER = "SearchServlet";
    private final String DELETE_CONTROLLER = "DeleteProductServlet";
    private final String UPDATE_CONTROLLER = "UpdateProductServlet";
    private final String INSERT_CONTROLLER = "InsertProductServlet";
    private final String ADD_FLOWER_CONTROLLER = "AddFlowerServlet";
    private final String EDIT_FLOWER_CONTROLLER = "EditFlowerServlet";
    private final String REMOVE_FLOWER_CONTROLLER = "RemoveFlowerServlet";
    private final String CHECKOUT_CONTROLLER = "CheckOutServlet";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = ERROR_PAGE;
        String action = request.getParameter("action");

        try {
            if (action == null) {
                url = STARTUP_CONTROLLER;
            } else if (action.equals("Login")) {
                url = LOGIN_CONTROLLER;
            } else if (action.equals("Create New Account")) {
                url = CREATE_ACCOUNT_CONTROLLER;
            } else if (action.equals("Logout")) {
                url = LOGOUT_CONTROLLER;
            } else if (action.equals("Search")) {
                url = SEARCH_CONTROLLER;
            } else if (action.equals("Delete")) {
                url = DELETE_CONTROLLER;
            } else if (action.equals("Update")){
                url = UPDATE_CONTROLLER;
            } else if (action.equals("Insert")){
                url = INSERT_CONTROLLER;
            } else if (action.equals("Add")){
                url = ADD_FLOWER_CONTROLLER;
            } else if (action.equals("Edit View Cart")){
                url = EDIT_FLOWER_CONTROLLER;
            } else if (action.equals("Remove From Cart")){
                url = REMOVE_FLOWER_CONTROLLER;
            } else if (action.equals("Check Out")){
                url = CHECKOUT_CONTROLLER;
            }

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
            out.close();
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
