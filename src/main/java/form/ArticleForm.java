package form;

import core.Form;

import java.util.ArrayList;

/**
 * Created by Maxime on 11/25/2014.
 */
public class ArticleForm extends Form {

    public static final String FIELD_TITLE  = "title";
    public static final String FIELD_CONTENT   = "content";

    static {
        fields = new ArrayList<String>();
        fields.add(FIELD_TITLE);
        fields.add(FIELD_CONTENT);
    }

    public boolean validateTitle( String field ){
        if(field == null || field.equals("")){
            this.errors.put( FIELD_TITLE, FIELD_TITLE + " should not be null");
            return false;
        }
        return true;
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

        if( ! this.validateTitle(this.values.get(FIELD_TITLE))){
            isValid = false;
        }
        if( ! this.validateContent(this.values.get(FIELD_CONTENT))){
            isValid = false;
        }

        return isValid;
    }

}
