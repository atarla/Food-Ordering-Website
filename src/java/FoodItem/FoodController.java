package FoodItem;

import User.LoginDao;
import User.user;
import Utility.EmailUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet("/FoodController")
public class FoodController extends HttpServlet {
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
        String message="";

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
             case "addfood":{
                 request.setAttribute("user", new_user);
                 String itemname = request.getParameter("itemname");
                 System.out.println("itemname:"+itemname);
                  String itemDesc = request.getParameter("itemDesc");
                  System.out.println("itemDesc:"+itemDesc);
                  String address = request.getParameter("address");
                  System.out.println("address:"+address);
                  String price = request.getParameter("price");
                  System.out.println("price:"+price);
                  String cuisine = request.getParameter("cuisine");
                  fooditem fi1 = new fooditem();
                  fi1.setItem_name(itemname);
                  fi1.setDescription(itemDesc);
                  fi1.setItem_price(Integer.parseInt(price));
                  fi1.setAddress(address);
                  fi1.setPosted_by(username);
                  fi1.setStatus("under review");
                  fi1.setCuisine(cuisine);
                  FoodDao fd = new FoodDao();
        {
            try {
                fd.foodDao(fi1);
            } catch (SQLException ex) {
                Logger.getLogger(FoodController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                String to = "";
                    to = new_user.getEmail();
                    String from = "admin@goodfood.com";
                    String subject = "New Food Item Added";
                    String link = "foodadded.jsp";
                    String emailUrl = "<a href=\"" + link + "\" >" + link + "</a>";
                    String body = "Dear " + new_user.getUsername() + ",\n\n"
                            + itemname+"\n"+itemDesc+"\n Price: "+price+"\nAddress: "+address+ "\n\n"
                            + "Thanks,\n"
                            + "Admin";
                    boolean isBodyHTML = false;

                    try {
                        System.out.println("inside email send");
                        EmailUtil.sendMail(to, from, subject, body, isBodyHTML);
                        message =itemname.toUpperCase()+":"+itemDesc;
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
                  url="/foodadded.jsp";
                  request.getServletContext().getRequestDispatcher(url).forward(request, response);
                 break;}
             case "approve":{
                String question = request.getParameter("approval_value");
                
                System.out.println("question" + question);
                ArrayList<fooditem> obj = new ArrayList<fooditem>();
                ApprovalDao a = new ApprovalDao();
                obj = a.approvalDao("approve", question);
                System.out.println("Admin review size"+obj.size());
                request.setAttribute("list", obj);
                url="/admin.jsp";
                request.getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
            }
             case "disapprove":{
                String question = request.getParameter("approval_value");
                
                System.out.println("question" + question);
                ArrayList<fooditem> obj = new ArrayList<fooditem>();
                ApprovalDao a = new ApprovalDao();
                obj = a.approvalDao("disapprove", question);
                System.out.println("Admin review size"+obj.size());
                request.setAttribute("list", obj);
                url="/admin.jsp";
                request.getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
            }
             case "admin":{
                 ArrayList<fooditem> obj = new ArrayList<fooditem>();
                AdminDao a = new AdminDao();
                obj = a.AdminDao("under review");
                request.setAttribute("list", obj);
                            for (fooditem f:obj) {
                        
                        System.out.println("Element: " + f.getItem_name());
                    }
                url="/admin.jsp";
                request.getServletContext().getRequestDispatcher(url).forward(request, response);
                break;}
        
    }

    }}
