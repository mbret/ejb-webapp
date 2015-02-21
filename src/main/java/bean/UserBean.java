package bean;

import core.BeanAbstract;

/**
 * Created by Maxime on 2/21/2015.
 */
public class UserBean extends BeanAbstract {
    
    public String email;
    public boolean subscriber;
    
    public UserBean() {
    }

    public UserBean(String email, boolean subscriber) {
        this.email = email;
        this.subscriber = subscriber;
    }

    public UserBean(Object id, String email, boolean subscriber) {
        super(id);
        this.email = email;
        this.subscriber = subscriber;
    }

    public String getEmail() {
        return email;
    }

    public boolean isSubscriber() {
        return subscriber;
    }
}
