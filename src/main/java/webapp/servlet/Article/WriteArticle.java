package webapp.servlet.Article;


import ejbinterface.interfaces.ArticleRemote;
import webapp.core.Config;
import webapp.core.ServletAbstract;
import webapp.form.ArticleForm;
import webapp.service.AuthService;
import webapp.service.EjbService;
import webapp.service.FlashService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maxime on 11/25/2014.
 */
public class WriteArticle extends ServletAbstract {

    private ArticleRemote articleRemote;
    
    public WriteArticle() throws Exception {
        this.view = Config.getViews().get(Config.ROUTE_ARTICLE_WRITE);
        this.articleRemote = (ArticleRemote) EjbService.loadEJB(ArticleRemote.class);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        ArticleForm form = new ArticleForm();
        form.populate( request );

        if( ! form.isValid() ){
            request.setAttribute( FlashService.FlashLevel.ERROR, form.getErrors() );
            this.getServletContext().getRequestDispatcher( this.view ).forward( request, response );
        }
        else{

            // Create article
            try {
                this.articleRemote.save(
                        form.getValues().get(ArticleForm.FIELD_TITLE),
                        form.getValues().get(ArticleForm.FIELD_CONTENT),
                        AuthService.getUser(request).getId()
                );
            } catch (Exception e) {
                throw new ServletException(e);
            }

            FlashService.addMessage(FlashService.FlashLevel.SUCCESS, Config.MESSAGE_WROTE);
            response.sendRedirect( Config.ROUTE_INDEX );
        }
    }
}
