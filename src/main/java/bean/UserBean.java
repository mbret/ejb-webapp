package bean;

import core.Bean;

/**
 * Created by Maxime on 2/21/2015.
 */
public class UserBean extends Bean {
    
    public String email;

    public UserBean() {
    }

    public UserBean(Object id, String email) {
        super(id);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
