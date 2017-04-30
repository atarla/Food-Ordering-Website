/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;


import User.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Utility.DBUtility;

/**
 *
 * @author pooja
 */
public class SignupDao {
    public boolean SignupDao(user new_user){
            int x=0;

		Connection conn=DBUtility.getConnection();
   boolean output=false;


		try{

			

		PreparedStatement pst = conn.prepareStatement("select * from user where email=? and hash=? and saltedHash=? and salt=? ");


		pst.setString(1, new_user.getEmail());
		pst.setString(2, new_user.getHash());
                pst.setString(3, new_user.getSaltedHash());
                pst.setString(4, new_user.getSalt());
                


                PreparedStatement pst1 = conn.prepareStatement("insert into user(username,usertype,email,hash,saltedHash,salt) values (?,?,?,?,?,?) ");
                pst1.setString(1,new_user.getUsername());
		ResultSet rs = pst.executeQuery();
             
		if(rs.next()){
                    System.out.println("signUp.signUpDao.signUpDao()");
		

		}
                else{
                    pst1.setString(2, new_user.getUserType());
                pst1.setString(3, new_user.getEmail());
                pst1.setString(4, new_user.getHash());
                pst1.setString(5, new_user.getSaltedHash());
                pst1.setString(6, new_user.getSalt());
                x = pst1.executeUpdate();
		output=true;}
		DBUtility.closeConnection(conn);



		}

		catch(Exception e){

		e.printStackTrace();

		}

		return output;
    }
}

