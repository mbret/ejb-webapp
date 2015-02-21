package webapp.servlet.Folder;


import webapp.core.Config;
import webapp.core.ServletAbstract;

/**
 * Created by Maxime on 11/25/2014.
 */
public class Folders extends ServletAbstract {

    public Folders() {
        this.view = Config.getViews().get(Config.ROUTE_FOLDERS);
    }
    
}
