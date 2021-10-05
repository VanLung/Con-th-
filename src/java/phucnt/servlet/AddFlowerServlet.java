/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucnt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phucnt.tblProducts.CartObject;
import phucnt.tblProducts.ProductDAO;
import phucnt.tblProducts.ProductDTO;
import phucnt.tblProducts.QuantityError;
import phucnt.ultils.Utility;

/**
 *
 * @author PC
 */
@WebServlet(name = "AddFlowerServlet", urlPatterns = {"/AddFlowerServlet"})
public class AddFlowerServlet extends HttpServlet {

    private final String SHOW_FLOWER_CONTROLLER = "ShowFlowerServlet";

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
        String url = SHOW_FLOWER_CONTROLLER;

        String productID = request.getParameter("pID");
        String productName = request.getParameter("pName");
        String quantityS = request.getParameter("pQuantity");

        boolean check = false;
        QuantityError quanErr = new QuantityError();
        try {
            int quantity = 0;
            HttpSession session = request.getSession();
            CartObject cart = (CartObject) session.getAttribute("CART");
            ProductDAO dao = new ProductDAO();
            ProductDTO product = dao.getProductInfo(productID, quantity);

            if (cart == null) {
                cart = new CartObject();
            }

            if (!quantityS.equals("")) {
                quantity = Utility.numberChecker(quantityS);
                if (quantity < 0 || quantity > 1000) {
                    quanErr.setEnterQuantityError("Quantity must be within 1,1000");
                    check = true;
                }
            }
            if (check) {
                request.setAttribute("QUANERR", quanErr);
            } else {
                cart.addFlower(productID, quantity);
                session.setAttribute("CART", cart);
                url += "?addStatus=true&productAdded=" + product.getProductName();
            }
            request.setAttribute("QUANTITY_INFO", productName);
            request.getRequestDispatcher(url).forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddFlowerServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(461);
        } catch (NamingException ex) {
            Logger.getLogger(AddFlowerServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(461);
        } finally {

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
