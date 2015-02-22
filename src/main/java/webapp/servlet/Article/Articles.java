package webapp.servlet.Article;


import ejbinterface.interfaces.ArticleRemote;
import ejbinterface.interfaces.CommentRemote;
import ejbinterface.model.ArticleShared;
import ejbinterface.model.CommentShared;
import webapp.bean.ArticleBean;
import webapp.bean.BeanFactory;
import webapp.bean.CommentBean;
import webapp.core.Config;
import webapp.core.ServletAbstract;
import webapp.service.EjbService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Maxime on 11/25/2014.
 */
public class Articles extends ServletAbstract {

    private ArticleRemote articleRemote;
    private CommentRemote commentRemote;

    public Articles() throws Exception {
        this.view = Config.getViews().get(Config.ROUTE_ARTICLES);
        this.articleRemote = (ArticleRemote) EjbService.loadEJB(ArticleRemote.class);
        this.commentRemote = (CommentRemote) EjbService.loadEJB(CommentRemote.class);
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        List<ArticleBean> beans;
        
        List<ArticleShared> articles;
        try {
            // Load articles
            articles = this.articleRemote.findAll();
            beans = BeanFactory.convert(ArticleBean.class, articles);
            
            for(ArticleBean articleBean : beans){
                // Load comments
                List<CommentShared> comments = this.commentRemote.findAllByArticle(articleBean.getId());
                articleBean.setComments( BeanFactory.convert(CommentBean.class, comments) );
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }

        request.setAttribute("articles", beans);
        this.getServletContext().getRequestDispatcher( this.view ).forward(request, response);

    }
}
