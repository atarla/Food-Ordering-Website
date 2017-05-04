package Orders;

import FoodItem.AdminDao;
import FoodItem.fooditem;
import User.LoginDao;
import User.user;
import Utility.EmailUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.mail.MessagingException;
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
                 
                     String to = "";
                    to = new_user.getEmail();
                    String from = "admin@goodfood.com";
                    String subject = "Order Confirmed";
                    String link = "buy.jsp";
                    String cp = (String) session.getAttribute("curr_price");
                     String cart_item = "Pizza";
                     String ca ="some address 89urqia some street Charlotte, NC";
                    String emailUrl = "<a href=\"" + link + "\" >" + link + "</a>";
                    String body = "Dear " + new_user.getUsername() + ",\n\n"
                            + cart_item+"\n"+"\n Price is: "+cp+"\nPlease collect it at Address: "+ca+ "\n\n"
                            + "Thanks,\n"
                            + "Admin";
                    System.out.print(body);
                    boolean isBodyHTML = false;

                    try {
                        System.out.println("inside email send");
                        EmailUtil.sendMail(to, from, subject, body, isBodyHTML);String message="";
                        //message =cart_item.toUpperCase();
                        request.setAttribute("message", message);
                        

                    } catch (MessagingException e) {
                        String errorMessage
                                = "ERROR: Unable to send email. "
                                + "Check Tomcat logs for details."
                                + "ERROR MESSAGE: " + e.getMessage();
                        request.setAttribute("message", errorMessage);
                        this.log(
                                "Unable to send email. \n"
                                + "Here is the email you tried to send: \n"
                                + "=====================================\n"
                                //+ "TO: " + to + "\n"
                                + "FROM: " + from + "\n"
                                + "SUBJECT: " + subject + "\n"
                                + "\n"
                                + body + "\n\n");}
                     //end emailing
            
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
                 String cart_item = request.getParameter("curr_item");
                 session.setAttribute("cart_item", cart_item);
                 String cp = request.getParameter("curr_price");
                 session.setAttribute("curr_price", cp);
                 String ca = request.getParameter("curr_address");
                 session.setAttribute("curr address", ca);
                 System.out.println(request.getParameter("curr_item"));
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
