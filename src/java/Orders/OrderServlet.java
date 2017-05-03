package Orders;

import FoodItem.AdminDao;
import FoodItem.fooditem;
import User.LoginDao;
import User.user;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author anusha
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "";
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        String username = "";

        Cookie[] cookies = request.getCookies();
         for (Cookie cookie : cookies) {
            System.out.println("Cookie name : " + cookie.getName());
            System.out.println("Cookie value :" + cookie.getValue());
            if (cookie.getName().equals("userCookie")) {
                username = cookie.getValue();
                System.out.println("username is set to :" + username);
            }

        }
            user new_user =new user();
            new_user.setUsername(username);
            LoginDao ld = new LoginDao();
           new_user = ld.LoginDao(new_user);
         
         switch(action){
             case "buy":{
                 url="/orderconfirm.jsp";
                 request.setAttribute("user", new_user);
                 request.getServletContext().getRequestDispatcher(url).forward(request, response);
                 break;}
             case "view":{
                 url="/buyer.jsp";
                 int item_count=0;
                 session.setAttribute("icount", item_count);
                 ArrayList<fooditem> obj = new ArrayList<fooditem>();
                AdminDao a = new AdminDao();
                obj = a.AdminDao("approved");
                request.setAttribute("list", obj);
                            for (fooditem f:obj) {
                        
                        System.out.println("Element: " + f.getItem_name());
                    }
                
                 request.getServletContext().getRequestDispatcher(url).forward(request, response);
                 break;}
             case "addtocart":{
                 url="/buyer.jsp";
                 int item_count=0;
                 item_count = item_count+1;
                 session.setAttribute("icount", item_count);
                 System.out.println(request.getParameter("item_name"));
                 request.setAttribute("user", new_user);
                 request.getServletContext().getRequestDispatcher(url).forward(request, response);
                 break;}
         } 
        
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
