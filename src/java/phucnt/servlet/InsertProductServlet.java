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
import phucnt.tblProducts.CreateError;
import phucnt.tblProducts.ProductDAO;
import phucnt.ultils.Utility;
import static phucnt.ultils.Utility.numberChecker;

/**
 *
 * @author PC
 */
@WebServlet(name = "InsertProductServlet", urlPatterns = {"/InsertProductServlet"})
public class InsertProductServlet extends HttpServlet {
    private final String ERROR_PAGE = "CreateNewProduct.jsp";
    private final String CREATE_SUCCESSFUL_PAGE = "CreateSuccessful.html";
    
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
        
        boolean check = false;
        CreateError errors = new CreateError();
        
        try {
            int quantity;
            int price;
            ProductDAO dao = new ProductDAO();
            boolean IspNameExisted = dao.IsProductNametaken(productName);
            
            if(productID.trim().length() < 1 || productID.trim().length() > 4){
                errors.setProductIDLengthError("product ID must be between 1,4");
                check = true;
            }
            if(productName.trim().length() < 4 || productName.trim().length() > 10){
                errors.setProductNameLengthError("product name must be between 4,10");
                check = true;
            }
            if(!quantityS.equals("")){
                quantity = numberChecker(quantityS);
                if(quantity < 1 || quantity > 1000){
                    errors.setQuantitySizeError("quantity must be between 1,1000");
                    check = true;
                }
            } else {
                quantity = 0;
            }
            if(!priceS.equals("")){
                price = numberChecker(priceS);
                if(price < 1 || price > 1000){
                    errors.setPriceSizeError("price must be between 1,1000");
                    check = true;
                }
            } else {
                price = 0;
            }
            if(!(categoryID.equals("b1") || categoryID.equals("r1") || categoryID.equals("y1"))){
                errors.setCategoryIDLengthError("Category ID must be 1 of these 3: b1, r1, y1");
                check = true;
            }
            if(IspNameExisted){
                errors.setProductNameisExisted("Product name already existed");
                check = true;
            }
            
            if(check){
                request.setAttribute("INSERT_ERROR", errors);
            } else{
                
                boolean result = dao.InsertProduct(productID, productName, quantity, price, categoryID);
                if(result){
                    url = CREATE_SUCCESSFUL_PAGE;
                }
            }
            
        } catch(SQLException e){
            String errMsg = e.getMessage();
            log("InsertProductServlet _ SQL: " + errMsg);
            if(errMsg.contains("duplicate")){
                errors.setProductIDisExisted("product ID already existed");           
                request.setAttribute("INSERT_ERROR", errors);
            }
            response.sendError(461);
        } catch(NamingException e){
            log("InsertProductServlet _ Naming: " + e.getMessage());
            response.sendError(461);
        }
        finally{
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
