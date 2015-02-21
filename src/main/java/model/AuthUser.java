package model;

/**
 * Created by Maxime on 2/21/2015.
 */
public class AuthUser {

    public Object id;
    public String email;
    public String password;

    public AuthUser(Object id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Object getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
