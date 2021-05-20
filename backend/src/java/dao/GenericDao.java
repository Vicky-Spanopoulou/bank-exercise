package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenericDao {
    
    private final String url = "jdbc:mysql://ra1.anystream.eu:3012/bank";
    private final String user = "cb13ptjava";
    private final String password = "cb13ptjava";
    protected static Connection conn;
    protected static PreparedStatement pstm;
    protected static ResultSet rs;
    
    
        
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        } 
        return connection;
    }
    
    protected void closeConnections(ResultSet rs, Statement stmt, Connection conn){
        try {
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    protected void closeConnections(PreparedStatement pstm, Connection conn){
        try {
            pstm.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
//    public ResultSet makePreparedStatement(String str,Object[] objArray){
//        conn = getConnection();
//        try {
//            pstm = conn.prepareStatement(str);
//            if(objArray.length>0){
//                for (int i = 0; i < objArray.length; i++) {
//                    if(Integer.class.isInstance(objArray[i])){
//                        pstm.setInt(i+1,(int)objArray[i]);
//                    }
//                    else if(objArray[i] instanceof String){
//                        pstm.setString(i+1, (String)objArray[i]);
//                    }
//                    else if(Double.class.isInstance(objArray[i])){
//                        pstm.setDouble(i+1, (double)objArray[i]);
//                    }
//                    else if(objArray[i] instanceof LocalDateTime){
//                        LocalDateTime x = (LocalDateTime) objArray[i];
//                        pstm.setTimestamp(i, x);
//                    }
//                }
//            }
//            rs = pstm.executeQuery();
//        } catch (SQLException ex) {
//            System.out.println("SOMETHING GET WRONG WITH makeStatement IN GenericDao");
//        }
//        return rs;
//    } 
}
