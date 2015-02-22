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

//        UserBean author = new UserBean(12, "user@user.com", true);
        List<ArticleBean> beans;
        
        List<ArticleShared> articles = this.articleRemote.findAll();
        try {
            beans = BeanFactory.convert(ArticleBean.class, articles);
        } catch (Exception e) {
            throw new ServletException(e);
        }
//        beans.add( new ArticleBean(12, "Article 1", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?", new Date(), author) );
//        beans.add( new ArticleBean(12, "Article 2", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?", new Date(), author) );
//        beans.add( new ArticleBean(12, "Article 3", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?", new Date(), author) );

        request.setAttribute("articles", beans);
        this.getServletContext().getRequestDispatcher( this.view ).forward(request, response);

    }
}
