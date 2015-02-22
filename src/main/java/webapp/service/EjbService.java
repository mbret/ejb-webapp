package webapp.service;

import javax.naming.InitialContext;

/**
 * Created by Maxime on 2/22/2015.
 */
public class EjbService {
    
    public static Object loadEJB( Class ejbClass ) throws Exception {

        // Load EJB
        InitialContext ctx =  new InitialContext();
        System.out.println("ejbinterface.interfaces." + ejbClass.getSimpleName() + "#ejbinterface.interfaces." + ejbClass.getSimpleName());
        return ctx.lookup("ejbinterface.interfaces." + ejbClass.getSimpleName() + "#ejbinterface.interfaces." + ejbClass.getSimpleName());
        
    }
}
