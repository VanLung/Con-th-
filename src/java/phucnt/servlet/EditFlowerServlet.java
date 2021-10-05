/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucnt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phucnt.tblProducts.CartObject;
import phucnt.tblProducts.QuantityError;
import phucnt.ultils.Utility;

/**
 *
 * @author PC
 */
@WebServlet(name = "EditFlowerServlet", urlPatterns = {"/EditFlowerServlet"})
public class EditFlowerServlet extends HttpServlet {

    private final String VIEWCART_CONTROLLER = "viewCartServlet";

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
        String url = VIEWCART_CONTROLLER;

        String productID = request.getParameter("productID");
        String productName = request.getParameter("productName");
        String quantityS = request.getParameter("productQuantity");
        boolean check = false;
        QuantityError EditquanErr = new QuantityError();
        try {
            HttpSession session = request.getSession();
            CartObject cart = (CartObject) session.getAttribute("CART");

            int quantity = 0;
            if (!quantityS.equals("")) {
                quantity = Utility.numberChecker(quantityS);
                if (quantity < 0 || quantity > 1000) {
                    EditquanErr.setEditQuantityError("Quantity must be within 1,1000");
                    check = true;
                }
            }
            if (check) {
                request.setAttribute("EDIT_QUANERR", EditquanErr);
            } else {
                cart.addFlower(productID, quantity);
                session.setAttribute("CART", cart);
            }
            request.setAttribute("EDIT_QUANTITY_INFO", productName);
            request.getRequestDispatcher(url).forward(request, response);
        } finally {
//            request.getRequestDispatcher(url).forward(request, response);
//            response.sendRedirect(url);
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
