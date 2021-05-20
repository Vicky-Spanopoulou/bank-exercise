package services;

import dao.Crud;
import dao.GenericDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DBConnectionOptions;
import models.UserLogin;
import models.dto.UserData;

public class UserLoginService extends GenericDao{
       
    
    
    public UserData validateLogin(UserLogin ul) {
        return (dbValidateLogin(ul));
    }

    
    public UserData dbValidateLogin(UserLogin ul) {
        Crud crud = new Crud();
        UserData ud = null;
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        String host = "ra1.anystream.eu";
        String hostPort = "3012";
        String username = "cb13ptjava";
        String password = "cb13ptjava";
        String database = "bank";
        String dbOption = "useSSL=false&serverTimezone=Europe/Athens";
        DBConnectionOptions dbOptions = new DBConnectionOptions(host, hostPort, username, password, database, dbOption);
        if (crud.dbExecute(dbOptions, sql, ul) != null) {    
            ResultSet rs = crud.dbExecute(dbOptions, sql, ul);
            ud = new UserData();
                
            try {
                
                ud.setId(rs.getInt(1));
                ud.setUsername(rs.getString(2));
                ud.setPassword(rs.getString(3));
                ud.setfName(rs.getString(4));
                ud.setlName(rs.getString(5));

                return (ud);
            } catch (SQLException ex) {
                Logger.getLogger(UserLoginService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (null);
    }    
    
}
