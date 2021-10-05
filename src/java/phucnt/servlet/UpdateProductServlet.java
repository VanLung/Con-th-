/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phucnt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phucnt.tblProducts.ProductDAO;
import phucnt.tblProducts.UpdateError;
import static phucnt.ultils.Utility.numberChecker;

/**
 *
 * @author PC
 */
@WebServlet(name = "UpdateProductServlet", urlPatterns = {"/UpdateProductServlet"})
public class UpdateProductServlet extends HttpServlet {

    private final String ERROR_PAGE = "error.html";

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

        String productID = request.getParameter("txtProductID");
        String productName = request.getParameter("txtProductName");
        String quantityS = request.getParameter("txtQuantity");
        String priceS = request.getParameter("txtPrice");
        String categoryID = request.getParameter("txtCategoryID");
        String searchValue = request.getParameter("lastSearchValue");

        boolean check = false;

        UpdateError errors = new UpdateError();

        try {
            //cái này còn thiếu phần catch lỗi

            //trước tiên check xem chuỗi rỗng hay ko, ko rỗng thì mới làm
//            if (!productID.equals("") && !categoryID.equals("")
//                    && !quantityS.equals("") && !priceS.equals("")) {
//                //parse ở đây
//                ProductDAO dao = new ProductDAO();
//
//                //chuyển thành integer
//                int quantity = numberChecker(quantityS);
//                int price = numberChecker(priceS);
//                //nếu đúng là chính số đó, sai là -1
//                if (quantity != -1 && price != -1) {
//                    result = dao.UpdateProduct(productID, quantity, price, categoryID);
//                }
//
//                if (result) {
//                    url = "DispatchServlet"
//                            + "?action=Search"
//                            + "&txtSearchValue=" + searchValue;
//                }
//
//            }
            int quantity;
            int price;
            if (!quantityS.equals("")) {
                quantity = numberChecker(quantityS);
                if (quantity < 1 || quantity > 1000) {
                    errors.setUpdateQuantityError("quantity must be within 1,1000");
                    check = true;
                }
            } else {
                quantity = 0;
            }
            if (!priceS.equals("")) {
                price = numberChecker(priceS);
                if (price < 1 || price > 1000) {
                    errors.setUpdatePriceError("price must be within 1,1000");
                    check = true;
                }
            } else {
                price = 0;
            }
            
            if(!(categoryID.equals("b1") || categoryID.equals("r1")
                    || categoryID.equals("y1"))){
                errors.setUpdateCategoryIDError("Category ID must be"
                                    + " 1 of these 3: b1, r1, y1");
                check = true;
            }
            if (check) {
                request.setAttribute("UPDATE_ERROR", errors);
//                request.setAttribute("UPDATE_PRODUCTID", productID);
                url = "DispatchServlet"
                        + "?action=Search"
                        + "&txtSearchValue=" + searchValue;
            } else {
                ProductDAO dao = new ProductDAO();
                boolean result = dao.UpdateProduct(productID, quantity,
                        price, categoryID);
                if (result) {
                    url = "DispatchServlet"
                            + "?action=Search"
                            + "&txtSearchValue=" + searchValue;
                }
            }
            request.setAttribute("UPDATE_INFO", productName);
            request.getRequestDispatcher(url).forward(request, response);
        } catch (SQLException e) {
            log("UpdateProductServlet_SQL: " + e.getMessage());
            response.sendError(461);
        } catch (NamingException e) {
            log("UpdateProductServlet_Naming: " + e.getMessage());
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
