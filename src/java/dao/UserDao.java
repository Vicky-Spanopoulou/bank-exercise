package dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import models.User;

public class UserDao extends GenericDao {
    
//    public boolean validate(User uesr) {
//        getConnection();
//            
//    } 
    
    
    
//    public ResultSet dbExecute(DBConnectionOptions dbOptions, String sql, User user) {        
//        Connection conn;
//        PreparedStatement ps;
//        String url = "jdbc:mysql://" + dbOptions.getHost() + ":" 
//                                     + dbOptions.getHostPort() + "/" 
//                                     + dbOptions.getDatabase() + "?"
//                                     + dbOptions.getDbOptions(); 
//        
//        try { 
//            Class.forName("com.mysql.cj.jdbc.Driver");   
//            conn = DriverManager.getConnection(url, dbOptions.getUsername(), dbOptions.getPassword());
//            String preStatement = sql; 
//            ps = conn.prepareStatement(preStatement);
//            ps.setString(1, user.getUsername());
//            ps.setString(2, user.getPassword());
//
//            boolean bReturnValue = ps.execute() && ps.getResultSet().next();
//            if (bReturnValue) {
//                return(ps.getResultSet());
//            }
//        } catch(SQLException | ClassNotFoundException e) {
//            System.out.println(e);
//        }
//        return(null);
//    }
}
