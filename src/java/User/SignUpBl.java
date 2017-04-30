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
public class SignUpBl {
    public boolean SignUpBl(user new_user){
        SignupDao dao=new SignupDao();
    return dao.SignupDao(new_user);
    }
    
}
