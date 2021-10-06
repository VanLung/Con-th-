/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package phucnt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;
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

@WebServlet(name = "AddToCartServlet", urlPatterns = {"/AddToCartServlet"})
public class AddToCartServlet extends HttpServlet {

    private final String HOME_PAGE = "ShowProductServlet";

    private final String PARAM_ID = "txtProductID";

    private final String ATTR_CART = "CART";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String txtProID = request.getParameter(PARAM_ID);
        String url = HOME_PAGE;
        try {
            HttpSession session = request.getSession();
            if (session != null) {
                CartObject cart = (CartObject) session.getAttribute(ATTR_CART);
                if (cart == null) {
                    cart = new CartObject();
                }
                ProductDAO productDAO = new ProductDAO();
                int proID = Integer.parseInt(txtProID);
                ProductDTO product = productDAO.showByID(proID);
                cart.addPhone(product);
                session.setAttribute(ATTR_CART, cart);
                request.getRequestDispatcher(url).forward(request, response);
            }
        } catch (NumberFormatException ex) {
            log("AddToCartServlet _ NumberFormat: " + ex.getMessage());
            response.sendError(461);
        } catch (SQLException ex) {
            log("AddToCartServlet _ SQL: " + ex.getMessage());
            response.sendError(461);
        } catch (NamingException ex) {
            log("AddToCartServlet _ Naming: " + ex.getMessage());
            response.sendError(461);
        } finally {
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
