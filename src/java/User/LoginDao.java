package User;

import User.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Utility.DBUtility;

/**
 *
 * @author Pooja
 */
public class LoginDao {
    
public user LoginDao(user new_user) {
        int x = 0;

        Connection conn = DBUtility.getConnection();
        boolean output = false;

        try {

           //PreparedStatement pst = conn.prepareStatement("select * from user where email=? and hash=? and saltedHash=? and salt=? and usertype=?");
            PreparedStatement pst = conn.prepareStatement("select * from user where username=?");

            pst.setString(1, new_user.getUsername());
            System.out.println("Query:"+pst.toString());
//            pst.setString(2, new_user.getHash());
//            
//            pst.setString(3,new_user.getSaltedHash());
//            pst.setString(4,new_user.getSalt());
//
//            pst.setString(5, new_user.getUserType());

            ResultSet rs = pst.executeQuery();
            user user1=null;
            if (rs.next()) {

                user1 = new user();
                user1.setUsername(rs.getString("username"));
;
                user1.setEmail(rs.getString("email"));
                //user.setPassWord(rs.getString("password"));
                user1.setUserType(rs.getString("usertype"));
                user1.setHash(rs.getString("hash"));
                user1.setSalt(rs.getString("salt"));
                System.out.println("Salt dao "+user1.getSalt());
                user1.setSaltedHash(rs.getString("saltedHash"));
                output = true;
                
                

            }
            System.out.println("Salt dao outside if"+user1.getSalt());
            DBUtility.closeConnection(conn);
            return user1;
            
            
           // return user1;
        } catch (Exception e) {

            e.printStackTrace();
            return null;

        }

        //return output;
    }
}

