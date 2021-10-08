package mb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mb.tblProducts.ProductCreateError;
import mb.tblProducts.ProductDAO;

@WebServlet(name = "AddProductServlet", urlPatterns = {"/AddProductServlet"})
public class AddProductServlet extends HttpServlet {

    private final String ADD_PRODUCT_PAGE = "CreateNewProduct.jsp";
    private final String SUCCESS_ADD_PAGE = "CreateSuccessful.html";
    private final String HOME_PAGE = "Home.jsp";

    private final String PARAM_NAME = "proName";
    private final String PARAM_DESC = "description";
    private final String PARAM_PRICE = "price";
    private final String PARAM_STOCK = "stock";
    private final String PARAM_MANUFACT = "manufacturer";
    private final String PARAM_CATEGORY = "category";
    private final String PARAM_CONDITION = "condition";
    private final String PARAM_IMG = "imgLink";

    private final String ATTR_USER = "LOGIN_USER";
    private final String ATTR_ERROR_ADD_PRODUCT = "ERROR_ADD_PRODUCT";

    private final String ERROR_NAME_LENGTH = "Product name must have between 2 and 50 characters.";
    private final String ERROR_DESC_LENGTH = "Description must have between 2 and 250 characters.";
    private final String ERROR_PRICE_FORMAT = "Price must be in valid number format.";
    private final String ERROR_STOCK_FORMAT = "Units in stock must be in valid number format.";
    private final String ERROR_MANUFACT_LENGTH = "Manufacturer must have between 2 and 50 characters.";
    private final String ERROR_CATEGORY_LENGTH = "Category must have between 2 and 50 characters.";
    private final String ERROR_IMG_LENGTH = "Image link must have at least 2 characters.";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String url = ADD_PRODUCT_PAGE;

        String proName = request.getParameter(PARAM_NAME);
        String description = request.getParameter(PARAM_DESC);
        String txtPrice = request.getParameter(PARAM_PRICE);
        String txtStock = request.getParameter(PARAM_STOCK);
        String manufacturer = request.getParameter(PARAM_MANUFACT);
        String category = request.getParameter(PARAM_CATEGORY);
        String txtCondition = request.getParameter(PARAM_CONDITION);
        String imgLink = request.getParameter(PARAM_IMG);

        try {
            HttpSession session = request.getSession();
            if ((session != null) && (session.getAttribute(ATTR_USER) != null)) {
                float price = 0.0f;
                int stock = 0;
                int condition = 0;

                boolean foundErr = false;
                ProductCreateError errors = new ProductCreateError();
                if (proName.trim().length() < 2 || proName.trim().length() > 50) {
                    errors.setProNameLengthErr(ERROR_NAME_LENGTH);
                }
                if (description.trim().length() < 2 || description.trim().length() > 250) {
                    errors.setDescriptionLengthErr(ERROR_DESC_LENGTH);
                }
                if (manufacturer.trim().length() < 2 || manufacturer.trim().length() > 50) {
                    errors.setManufacturerLengthErr(ERROR_MANUFACT_LENGTH);
                }
                if (category.trim().length() < 2 || category.trim().length() > 50) {
                    errors.setCategoryLengthErr(ERROR_CATEGORY_LENGTH);
                }
                if (imgLink.trim().length() < 2) {
                    errors.setImgLengthErr(ERROR_IMG_LENGTH);
                }
                try {
                    price = Float.parseFloat(txtPrice.trim());
                } catch (NumberFormatException ex) {
                    errors.setPriceFormatErr(ERROR_PRICE_FORMAT);
                }
                try {
                    stock = Integer.parseInt(txtStock.trim());
                } catch (NumberFormatException ex) {
                    errors.setStockFormatErr(ERROR_STOCK_FORMAT);
                }
                if (txtCondition != null) {
                    condition = Integer.parseInt(txtCondition);
                }

                foundErr = (errors.toString().trim().length() > 0);
                if (!foundErr) {
                    ProductDAO dao = new ProductDAO();
                    boolean result = dao.InsertProduct(proName, description, price, stock, manufacturer, category, condition, imgLink);
                    if (result) {
                        url = SUCCESS_ADD_PAGE;
                    }
                } // end add product
                else {
                    request.setAttribute(ATTR_ERROR_ADD_PRODUCT, errors);
                }
            } // end check session
            else {
                url = HOME_PAGE;
            } // user not logged in
            request.getRequestDispatcher(url).forward(request, response);
        } catch (SQLException ex) {
            log("AddProductServlet _ SQL: " + ex.getMessage());
            response.sendError(461);
        } catch (NamingException ex) {
            log("AddProductServlet _ Naming: " + ex.getMessage());
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
