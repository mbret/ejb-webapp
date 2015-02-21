package servlet.Folder;


import core.Config;
import core.ServletAbstract;

/**
 * Created by Maxime on 11/25/2014.
 */
public class Folders extends ServletAbstract {

    public Folders() {
        this.view = Config.getViews().get(Config.ROUTE_FOLDERS);
    }
    
}
