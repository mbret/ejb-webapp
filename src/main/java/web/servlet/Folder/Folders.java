package web.servlet.Folder;


import core.Config;
import core.Servlet;

/**
 * Created by Maxime on 11/25/2014.
 */
public class Folders extends Servlet {

    public Folders() {
        this.view = Config.getViews().get(Config.ROUTE_FOLDERS);
    }
    
}
