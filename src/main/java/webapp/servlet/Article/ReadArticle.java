package webapp.servlet.Article;


import ejbinterface.interfaces.ArticleRemote;
import ejbinterface.interfaces.CommentRemote;
import ejbinterface.model.CommentShared;
import webapp.bean.ArticleBean;
import webapp.bean.BeanFactory;
import webapp.bean.CommentBean;
import webapp.bean.UserBean;
import webapp.core.Config;
import webapp.core.ServletAbstract;
import webapp.service.EjbService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.events.Comment;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Maxime on 11/25/2014.
 */
public class ReadArticle extends ServletAbstract {
    
    private ArticleRemote articleRemote;
    private CommentRemote commentRemote;
    
    public ReadArticle() throws Exception {
        this.view = Config.getViews().get(Config.ROUTE_ARTICLE);
        this.articleRemote = (ArticleRemote) EjbService.loadEJB(ArticleRemote.class);
        this.commentRemote = (CommentRemote) EjbService.loadEJB(CommentRemote.class);
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        // Get request param
        Object id = request.getParameter("id");

        // Load article
        ArticleBean articleBean;
        try {
            articleBean = BeanFactory.convert(ArticleBean.class, this.articleRemote.findOne(id));
        } catch (Exception e) {
            throw new ServletException(e);
        }
        
        // Load comments
        List<CommentShared> comments = this.commentRemote.findAllByArticle(articleBean.getId());
        try {
            articleBean.setComments( BeanFactory.convert(CommentBean.class, comments) );
        } catch (Exception e) {
            throw new ServletException(e);
        }
        
//        UserBean author = new UserBean(12, "user@user.com", true);
//        ArticleBean article = new ArticleBean(id, "Article 1", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?", new Date(), author);
//        article.getComments().add(
//                new CommentBean(12, "The first comment", author, new Date())
//        );
//        article.getComments().add(
//                new CommentBean(12, "The second comment", author, new Date())
//        );
        request.setAttribute("article", articleBean);
        this.getServletContext().getRequestDispatcher( this.view ).forward(request, response);
    }
}
