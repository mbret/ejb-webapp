package webapp.servlet.Article;


import ejbinterface.interfaces.ArticleRemote;
import ejbinterface.model.ArticleShared;
import webapp.bean.ArticleBean;
import webapp.bean.BeanFactory;
import webapp.core.Config;
import webapp.core.ServletAbstract;
import webapp.service.EjbService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 11/25/2014.
 */
public class Articles extends ServletAbstract {

    private ArticleRemote articleRemote;
    
    public Articles() throws Exception {
        this.view = Config.getViews().get(Config.ROUTE_ARTICLES);
        this.articleRemote = (ArticleRemote) EjbService.loadEJB(ArticleRemote.class);
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        List<ArticleBean> beans;
        
        List<ArticleShared> articles;
        try {
            articles = this.articleRemote.findAll();
            beans = BeanFactory.convert(ArticleBean.class, articles);
        } catch (Exception e) {
            throw new ServletException(e);
        }

        request.setAttribute("articles", beans);
        this.getServletContext().getRequestDispatcher( this.view ).forward(request, response);

    }
}
