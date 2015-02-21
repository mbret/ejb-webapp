package webapp.core;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maxime on 11/25/2014.
 */
abstract  public class FormAbstract {

    protected Map<String, String> errors = new HashMap<String, String>();
    protected Map<String, String> values = new HashMap<String, String>();
    protected static ArrayList<String> fields;
    
    public Map<String, String> getErrors() {
        return this.errors;
    }

    public Map<String, String> getValues() {
        return values;
    }
    
    public void populate( HttpServletRequest request ) {
        for( String field : fields ){
            this.values.put(field, request.getParameter(field));
        }
    }
    
    abstract public boolean isValid();
}
