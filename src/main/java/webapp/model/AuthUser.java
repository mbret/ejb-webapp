package webapp.model;

/**
 * Created by Maxime on 2/21/2015.
 */
public class AuthUser {

    public Object id;
    public String email;
    public String password;
    public boolean subscriber;
    
    public AuthUser(Object id, String email, String password, boolean subscriber) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.subscriber = subscriber;
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

    public void setId(Object id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSubscriber() {
        return subscriber;
    }

    public void setSubscriber(boolean subscriber) {
        this.subscriber = subscriber;
    }
}
