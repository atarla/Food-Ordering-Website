package FoodItem;
import FoodItem.fooditem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Utility.DBUtility;
/**
 *
 * @author pooja
 */
public class ApprovalDao {
    public ArrayList<fooditem> approvalDao(String approval_value,String item_name){
       Connection con = DBUtility.getConnection();
        boolean output = false;

        ArrayList<fooditem> a = new ArrayList<fooditem>();
        
        try {
            if(approval_value.equals("approve")){
            PreparedStatement pst = con.prepareStatement("update fooditem set status=? where item_name like ?");
            System.out.println("in Apr dao: "+item_name);
            pst.setString(2, ("%"+item_name+"%"));
            pst.setString(1, "approved");
            int x = pst.executeUpdate();}
            if(approval_value.equals("disapprove")){
            PreparedStatement pst = con.prepareStatement("update fooditem set status=? where item_name like ?");
            pst.setString(2, ("%"+item_name+"%"));
            pst.setString(1, "disapproved");
            int x = pst.executeUpdate();
            }
PreparedStatement pst1 = con.prepareStatement("select * from fooditem where status=?");
            pst1.setString(1,"under review");

            ResultSet rs=pst1.executeQuery();

            while (rs.next()) 
            {fooditem fi = new fooditem();
                fi.setItem_name(rs.getString("item_name"));
                fi.setItem_price(rs.getInt("item_price"));
                fi.setDescription(rs.getString("description"));
                fi.setCuisine(rs.getString("cuisine"));
                fi.setPosted_by(rs.getString("posted_by"));
               // fi.setItem_id(rs.getInt("item_name"));
               fi.setAddress(rs.getString("address"));
               fi.setItem_id(rs.getString("item_name"));
               fi.setStatus(rs.getString("status"));
                a.add(fi);
            }

            DBUtility.closeConnection(con);

        } catch (Exception e) {

            e.printStackTrace();

        }
return a;  
    
    
    }

}
