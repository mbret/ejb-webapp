package webapp.core;

/**
 * Created by Maxime on 2/21/2015.
 */
public abstract class BeanAbstract {
    
    public Object id;

    public BeanAbstract() {
    }

    public BeanAbstract(Object id) {
        this.id = id;
    }

    public Object getId() {
        return id;
    }
}
