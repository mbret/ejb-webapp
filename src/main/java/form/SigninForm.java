package form;

import core.Form;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by Maxime on 11/25/2014.
 */
public class SigninForm extends Form {

    public static final String FIELD_EMAIL  = "email";
    public static final String FIELD_PASSWORD   = "password";

    static {
        fields = new ArrayList<String>();
        fields.add(FIELD_EMAIL);
        fields.add(FIELD_PASSWORD);
    }
    
    /**
     * Not null, Not empty
     * @param username
     * @return
     */
    public boolean validateUsername( String username ){
        System.out.println("Check username : " + username);
        if(username == null){
            this.errors.put( FIELD_EMAIL, FIELD_EMAIL + " should not be null");
            return false;
        }
        return true;
    }

    public boolean validatePassword( String password ){
        if(password == null){
            this.errors.put( FIELD_PASSWORD, FIELD_PASSWORD + " should not be null");
            return false;
        }
        if(password.length() < 2){
            this.errors.put( FIELD_PASSWORD, FIELD_PASSWORD + " should not be as short");
            return false;
        }
        return true;
    }

    public boolean isValid() {

        boolean isValid = true;

        if( ! this.validateUsername( this.values.get( FIELD_EMAIL ))){
            isValid = false;
        }
        if( ! this.validatePassword( this.values.get( FIELD_PASSWORD ))){
            isValid = false;
        }

        return isValid;
    }

}
