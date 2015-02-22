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
        Object idString = request.getParameter("id");
        Integer id = Integer.parseInt((String)idString);
        
        // Load article
        ArticleBean articleBean;
        try {
            articleBean = BeanFactory.convert(ArticleBean.class, this.articleRemote.findOne( id ));
        } catch (Exception e) {
            throw new ServletException(e);
        }
        
        // Load comments
        try {
            List<CommentShared> comments = this.commentRemote.findAllByArticle(articleBean.getId());
            articleBean.setComments( BeanFactory.convert(CommentBean.class, comments) );
        } catch (Exception e) {
            throw new ServletException(e);
        }

        request.setAttribute("article", articleBean);
        this.getServletContext().getRequestDispatcher( this.view ).forward(request, response);
    }
}
