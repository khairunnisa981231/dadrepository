package demo.ftmk.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.ftmk.product.Product;

/**
 * Servlet implementation class OrderRedirectServlet
 */
@WebServlet("/demo/orderRedirectServlet")
public class OrderRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderRedirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
     // Get orderedProducts from session and
     // cast to List of OrderedProduct
        HttpSession session = request.getSession();
        List<OrderedProduct> orderList = (List<OrderedProduct>)session.getAttribute("productList");
        
        
     // Validate list - instantiate new list if list is null
        if(orderList == null)
        {
        	orderList = new ArrayList<OrderedProduct>();
        }
        
     // Get data from web form
        String productName = request.getParameter("product");
        String productQuantity = request.getParameter("quantity");
        
        
     // Wrap data into object of OrderedProduct
        OrderedProduct orderedProduct = new OrderedProduct();
        orderedProduct.setOrderedProduct(productName);
        orderedProduct.setQuantity(Integer.parseInt(productQuantity));
        
        
     // Add object of OrderedProduct into list
        orderList.add(orderedProduct);
        
     
     // Add list to session
        session.setAttribute("productList", orderList);
        
     // Redirect to the same page
        response.sendRedirect("orderRedirectForm.html");
        
       		
	}

}
