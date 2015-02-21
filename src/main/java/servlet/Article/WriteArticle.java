package servlet.Article;


import core.Config;
import core.ServletAbstract;
import form.ArticleForm;
import service.FlashService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maxime on 11/25/2014.
 */
public class WriteArticle extends ServletAbstract {

    public WriteArticle() {
        this.view = Config.getViews().get(Config.ROUTE_ARTICLE_WRITE);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        ArticleForm form = new ArticleForm();
        form.populate( request );

        if( ! form.isValid() ){
            request.setAttribute( FlashService.FlashLevel.ERROR, form.getErrors() );
            this.getServletContext().getRequestDispatcher( this.view ).forward( request, response );
        }
        else{
            
            // save article
            // ...
            
            FlashService.addMessage(FlashService.FlashLevel.SUCCESS, Config.MESSAGE_WROTE);
            response.sendRedirect( Config.ROUTE_INDEX );
        }
    }
}
