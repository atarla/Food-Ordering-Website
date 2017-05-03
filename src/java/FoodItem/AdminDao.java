package FoodItem;

import FoodItem.fooditem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Utility.DBUtility;

/**
 *
 * @author sadiq
 */
public class AdminDao {
    public ArrayList<fooditem> AdminDao(String val){
       Connection conn = DBUtility.getConnection();
        boolean result = false;

        ArrayList<fooditem> a = new ArrayList<fooditem>();
        
        try {

            PreparedStatement pst = conn.prepareStatement("select * from fooditem where status=?");

            
            pst.setString(1,val);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {fooditem fi = new fooditem();
                fi.setItem_name(rs.getString("item_name"));
                fi.setItem_price(rs.getInt("item_price"));
                fi.setDescription(rs.getString("description"));
                fi.setCuisine(rs.getString("cuisine"));
                fi.setPosted_by(rs.getString("posted_by"));
               // fi.setItem_id(rs.getInt("item_name"));
               fi.setAddress(rs.getString("address"));
               fi.setItem_id(rs.getString("item_id"));
                a.add(fi);
            }

            DBUtility.closeConnection(conn);

        } catch (Exception e) {

            e.printStackTrace();

        }
return a;
    
    }
    
}
