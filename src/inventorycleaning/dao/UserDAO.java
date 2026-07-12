package inventorycleaning.dao;
import inventorycleaning.model.User;

public class UserDAO {
    public User getByUsername(String username) {
        // TODO: implement SELECT * FROM users WHERE username = ?
        return null;
    }

    public boolean insert(User user) {
        // TODO: implement, used by Register, remember to check for duplicate username/email first
        return false;
    }

    public boolean validateLogin(String username, String password) {
        // TODO: implement, compare against stored password
        return false;
    }

    public boolean usernameExists(String username) {
        // TODO: implement, used to enforce no duplicate usernames 
        return false;
    }
}
