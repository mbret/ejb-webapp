package web.servlet.Comment;


import core.Config;
import core.Servlet;
import form.ArticleForm;
import form.CommentForm;
import web.service.FlashService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maxime on 11/25/2014.
 */
public class WriteComment extends Servlet {

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        CommentForm form = new CommentForm();
        form.populate( request );

        String articleID = request.getParameter("article");
        String redirect = request.getParameter("redirect");
        
        if( ! form.isValid() ){
            FlashService.addMessage( FlashService.FlashLevel.ERROR, form.getErrors());
            response.sendRedirect(redirect);
        }
        else{

            // save comment
            // ...

            FlashService.addMessage(FlashService.FlashLevel.SUCCESS, Config.MESSAGE_COMMENT_POSTED);
            response.sendRedirect( redirect );
        }
    }
}
