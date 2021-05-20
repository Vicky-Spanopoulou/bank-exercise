package dao;

import java.util.List;

public class Account {
    
    private static String FINDBYUSERID = "SELECT balance, d_limit FROM accounts WHERE users_id = ?";
    
    public List<Account> getById(int id) {
        
        return null;
    }
}
