package User;

import Utility.PasswordUtil;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
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

@WebServlet("/UserController")
public class UserController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("com.libraryApp.servlets.LoginServlet.doPost()");
        //Variables declaration
        HttpSession session = request.getSession();
        String url = "/home.jsp";
        String message = "";
        
        //Get request parameters
        String action = request.getParameter("action");
        System.out.println("action : " + action);
        if (action == null) {
            action = "dummy";
        }

        if (action.equals("login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            user new_user =new user();
            new_user.setUsername(username);
            new_user.setPassword(password);
            
           // LoginBl lb = new LoginBl();
            //boolean result = 
           // lb.LoginBl(new_user);
           LoginDao ld = new LoginDao();
           new_user = ld.LoginDao(new_user);
            System.out.println("UserController.doPost()" + "username " + username);
            System.out.println("UserController.doPost()" + "password " + password);
            
//            if (result != true) {
            if (username==null) {   //change to check if user exists, add method in login dao or bl ?
                System.out.println("UserController.doPost()" + "User Does not exist");

                message = "User Does not exist";
                request.setAttribute("message", message);
                url = "/home.jsp";

                request.getServletContext().getRequestDispatcher(url).forward(request, response);
            } else {
                //user is registered
                if ("Admin".equals(new_user.getUserType())) {
                    url = "/admin.jsp";
                } 
                if ("Buyer".equals(new_user.getUserType())) {
                    url = "/buyer.jsp";}
                    else {
                         
                       
                    url = "/home.jsp";
                }
                //set salt hash and salted password
                String salt = "";
                String hashPwd = "";
                String saltedHash = "";
                
                try {
                    salt = new_user.getSalt();
                    System.out.println("salt at db :" + salt);
                    hashPwd = PasswordUtil.hashPassword(password);
                    System.out.println("hashPwd :" + hashPwd);
                    saltedHash = PasswordUtil.hashAndSaltPassword(password, salt);
                    System.out.println("saltedHash"+saltedHash);
                    System.out.println("password"+new_user.getPassword());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                if (new_user.getSaltedHash().equals(saltedHash)) {
                    System.out.println("Password matches");
                    Cookie userCookie = new Cookie("userCookie", username);
                    userCookie.setMaxAge(1 * 60 * 60);
                    userCookie.setPath("/");
                    response.addCookie(userCookie);
                    
                    Cookie userTypeCookie = new Cookie("userTypeCookie",new_user.getUserType());
                    userCookie.setMaxAge(1 * 60 * 60);
                    userCookie.setPath("/");
                    response.addCookie(userTypeCookie);
                    System.out.println("userType cookie value set to : " + new_user.getUserType());
                    request.setAttribute("user", new_user);
                    session.setAttribute("user", new_user);
                    session.setAttribute("username", new_user.getUsername());
                    session.setAttribute("usertype", new_user.getUserType());
                    request.getServletContext().getRequestDispatcher(url).forward(request, response);
                } else {
                    System.out.println("passwords don't match");
                    url = "/home.jsp";
                    message = "Incorrect username or password";
                    request.setAttribute("message", message);
                    request.setAttribute("user", new_user);
                    request.getServletContext().getRequestDispatcher(url).forward(request, response);
                }
            }

        } else if (action.equals("register")) {
            request.getServletContext().getRequestDispatcher(url).forward(request, response);
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String rePassword = request.getParameter("rePassword");
            String email = request.getParameter("email");
            
            String usertype = request.getParameter("usertype");
            System.out.println("UserController.doPost()" + username);

            System.out.println("UserController.doPost()" + password);
            System.out.println("UserController.doPost()" + rePassword);
           System.out.println("UserController.doPost()" + email);
            System.out.println("UserController.doPost()" + usertype);

           if (password.equals(rePassword)) {
                //Hash salt password
                boolean passwordStrong = false;
                String hashPassword = "";
                String salt = "";
                String hashSaltPassword = "";
                try {
                    PasswordUtil.checkPasswordStrength(password);
                    passwordStrong = true;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                if (passwordStrong) {
                    try {
                        hashPassword = PasswordUtil.hashPassword(password);
                        salt = PasswordUtil.getSalt();
                        hashSaltPassword = PasswordUtil.hashAndSaltPassword(password, salt);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("");
                    System.out.println(password);
                    System.out.println(hashPassword);
                    System.out.println(salt);
                    System.out.println(hashSaltPassword);

                    user newUser = new user(username, password, email, usertype);
                    newUser.setSalt(salt);
                    newUser.setHash(hashPassword);
                    newUser.setSaltedHash(hashSaltPassword);
                    SignUpBl sbl = new SignUpBl();
                   
                    boolean status = sbl.SignUpBl(newUser);
                    if (status == false) {
                        url = "/home.jsp";
                        message = "Something went wrong while register";
                        request.setAttribute("message", message);
                        request.getServletContext().getRequestDispatcher(url).forward(request, response);
                    } else {
                        System.out.println("here");
                       
                        url = "/home.jsp";
                        
                    session.setAttribute("user", newUser.getEmail());
                    RequestDispatcher rd = request.getRequestDispatcher("home.jsp?user"+newUser.getEmail());
                   rd.forward(request, response);
                    Cookie userCookie = new Cookie("userCookie", username);    
                    userCookie.setMaxAge(1 * 60 * 60);
                        userCookie.setPath("/");
                        response.addCookie(userCookie);
                        request.setAttribute("user", newUser);
                        getServletContext().getRequestDispatcher(url).forward(request, response);
                    }

                } else {
                    url = "/home.jsp";
                    message = "Not strong password.\n Password should be 8 characters minimum";
                    request.setAttribute("message", message);
                    request.getServletContext().getRequestDispatcher(url).forward(request, response);
                }

            }
        }
        else if (action.equals("logout")) {
            request.getSession().invalidate();
            response.sendRedirect("home.jsp");
        } else if (action.equals("home")) {
            url = "/home.jsp";
            String username = request.getParameter("username");
            Cookie[] cookies = request.getCookies();
            user user = null;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    System.out.println("Cookie : " + cookie.getName() + " - " + cookie.getValue());
                    if (cookie.getName().equals("userCookie")) {
                        username = cookie.getValue();
                        LoginBl lbl = new LoginBl();
                        lbl.LoginBl(user);
                    }
                }
            }
            request.setAttribute("username", username);
            request.setAttribute("user", user);
            System.out.println("Back to homepage");
            request.getServletContext().getRequestDispatcher(url).forward(request, response);

        }

    }
}
