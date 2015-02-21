package webapp.form;

import webapp.core.FormAbstract;

import java.util.ArrayList;

/**
 * Created by Maxime on 11/25/2014.
 */
public class CommentForm extends FormAbstract {

    public static final String FIELD_CONTENT   = "content";

    static {
        fields = new ArrayList<String>();
        fields.add(FIELD_CONTENT);
    }

    public boolean validateContent( String field ){
        if(field == null || field.equals("")){
            this.errors.put( FIELD_CONTENT, FIELD_CONTENT + " should not be null");
            return false;
        }
        if(field.length() < 2){
            this.errors.put( FIELD_CONTENT, FIELD_CONTENT + " should not be as short");
            return false;
        }
        return true;
    }

    public boolean isValid() {

        boolean isValid = true;

        if( ! this.validateContent(this.values.get(FIELD_CONTENT))){
            isValid = false;
        }

        return isValid;
    }

}
