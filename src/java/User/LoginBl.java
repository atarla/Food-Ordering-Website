/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;
import User.user;
/**
 *
 * @author Pooja
 */
public class LoginBl {
    public user LoginBl(user new_user){
        LoginDao dao=new LoginDao();
        System.out.println("Salt Bl "+new_user.getSalt());
    return dao.LoginDao(new_user);
    }

}
