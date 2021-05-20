package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.DBConnectionOptions;
import models.User;
import models.UserLogin;

public class Crud {
    
        public ResultSet dbExecute(DBConnectionOptions dbOptions, String sql, UserLogin ul) {        
        Connection conn;
        PreparedStatement ps;
        String url = "jdbc:mysql://" + dbOptions.getHost() + ":" 
                                     + dbOptions.getHostPort() + "/" 
                                     + dbOptions.getDatabase() + "?"
                                     + dbOptions.getDbOptions();
        
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");   
            conn = DriverManager.getConnection(url, dbOptions.getUsername(), dbOptions.getPassword());
            String preStatement = sql;
            ps = conn.prepareStatement(preStatement);
            ps.setString(1, ul.getUsername());
            ps.setString(2, ul.getPassword());

            boolean bReturnValue = ps.execute() && ps.getResultSet().next();
            if (bReturnValue) {
                return(ps.getResultSet());
            }
        } catch(SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return(null);
    }
    
    
}
