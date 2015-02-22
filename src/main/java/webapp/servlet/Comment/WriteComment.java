package webapp.servlet.Comment;


import ejbinterface.interfaces.CommentRemote;
import webapp.core.Config;
import webapp.core.ServletAbstract;
import webapp.form.CommentForm;
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
public class WriteComment extends ServletAbstract {

    private CommentRemote commentRemote;

    public WriteComment() throws Exception {
        this.commentRemote = (CommentRemote)EjbService.loadEJB(CommentRemote.class);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        CommentForm form = new CommentForm();
        form.populate( request );

        // Get parameters
        String articleID = request.getParameter("article");
        String redirect = request.getParameter("redirect");
        
        if( ! form.isValid() ){
            FlashService.addMessage(FlashService.FlashLevel.ERROR, form.getErrors());
            response.sendRedirect(redirect);
        }
        else{

            // Save comment
            this.commentRemote.save(
                    form.getValues().get(CommentForm.FIELD_CONTENT),
                    AuthService.getUser(request).getId(),
                    articleID
            );

            FlashService.addMessage(FlashService.FlashLevel.SUCCESS, Config.MESSAGE_COMMENT_POSTED);
            response.sendRedirect( redirect );
        }
    }
}
