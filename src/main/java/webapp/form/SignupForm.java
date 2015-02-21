package webapp.form;

import webapp.core.FormAbstract;

import java.util.ArrayList;

/**
 * Created by Maxime on 11/25/2014.
 */
public class SignupForm extends FormAbstract {

    public static final String FIELD_EMAIL  = "email";
    public static final String FIELD_PASSWORD   = "password";

    static {
        fields = new ArrayList<String>();
        fields.add(FIELD_EMAIL);
        fields.add(FIELD_PASSWORD);
    }

    public boolean validateEmail(String value){
        if(value == null){
            this.errors.put( FIELD_EMAIL, FIELD_EMAIL + " should not be null");
            return false;
        }
        return true;
    }

    public boolean validatePassword(String value){
        if(value == null){
            this.errors.put( FIELD_PASSWORD, FIELD_PASSWORD + " should not be null");
            return false;
        }
        if(value.length() < 2){
            this.errors.put( FIELD_PASSWORD, FIELD_PASSWORD + " should not be as short");
            return false;
        }
        return true;
    }

    public boolean isValid() {

        boolean isValid = true;

        if( ! this.validateEmail(this.values.get(FIELD_EMAIL))){
            isValid = false;
        }
        if( ! this.validatePassword( this.values.get( FIELD_PASSWORD ))){
            isValid = false;
        }

        return isValid;
    }

}
