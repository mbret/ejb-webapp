package webapp.servlet.Article;


import webapp.bean.ArticleBean;
import webapp.bean.CommentBean;
import webapp.bean.UserBean;
import webapp.core.Config;
import webapp.core.ServletAbstract;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Maxime on 11/25/2014.
 */
public class ReadArticle extends ServletAbstract {

    public ReadArticle(){
        this.view = Config.getViews().get(Config.ROUTE_ARTICLE);
    }
    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        Object id = request.getParameter("id");
        UserBean author = new UserBean(12, "user@user.com", true);
        ArticleBean article = new ArticleBean(id, "Article 1", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?", new Date(), author);
        article.getComments().add(
                new CommentBean(12, "The first comment", author, new Date())
        );
        article.getComments().add(
                new CommentBean(12, "The second comment", author, new Date())
        );
        request.setAttribute("article", article);
        this.getServletContext().getRequestDispatcher( this.view ).forward(request, response);
    }
}
