package Utility;

/**
 *
 * @author anusha
 */
import java.sql.*;

public class TestUtility {
    //close sql statement
    public static void closeStatement(Statement s) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //close prepared statement
    public static void closePreparedStatement(Statement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //close result set
    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
