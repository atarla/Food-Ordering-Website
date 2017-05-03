package FoodItem;
import FoodItem.fooditem;
import Utility.DBUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author anusha
 */
public class FoodDao {
    public boolean foodDao(fooditem f1) throws SQLException{
    int x=0;
    Connection conn = DBUtility.getConnection();
    boolean output = false;
    PreparedStatement pst1 = conn.prepareStatement("insert into fooditem(item_name,description,posted_by,address,item_price,status,cuisine) values (?,?,?,?,?,?,?) ");
    pst1.setString(1,f1.getItem_name());
    pst1.setString(2,f1.getDescription());
    pst1.setString(3,f1.getPosted_by());
    pst1.setString(4,f1.getAddress());
    pst1.setInt(5,f1.getItem_price());
    pst1.setString(6,f1.getStatus());
    pst1.setString(7, f1.getCuisine());
    x=pst1.executeUpdate();
    output = true;
    DBUtility.closeConnection(conn);
    
    return output;
    }
}
