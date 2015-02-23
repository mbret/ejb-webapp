package webapp.service;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by Maxime on 2/22/2015.
 */
public class EjbService {
    
    public static Object loadEJB( Class ejbClass ) throws Exception {

        // Load EJB
        InitialContext ctx = null;
        Object ejb = null;
        try {
            ctx = new InitialContext();
            ejb = ctx.lookup("ejbinterface.interfaces." + ejbClass.getSimpleName() + "#ejbinterface.interfaces." + ejbClass.getSimpleName());
        } catch (NamingException e) {
            throw new Exception("Unable to lookup EJB");
        }
        return ejb;

    }
}
