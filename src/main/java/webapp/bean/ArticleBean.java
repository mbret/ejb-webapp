package webapp.bean;

import webapp.core.BeanAbstract;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Maxime on 2/21/2015.
 */
public class ArticleBean extends BeanAbstract {
    
    public String title;
    public String content;
    public Date date;
    public UserBean author;
    public ArrayList<CommentBean> comments = new ArrayList<CommentBean>();
    public String role;
    
    public ArticleBean() {
        
    }

    public ArticleBean(Object id, String title, String content, Date date, UserBean author) {
        super(id);
        this.title = title;
        this.content = content;
        this.date = date;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    public UserBean getAuthor() {
        return author;
    }

    public ArrayList<CommentBean> getComments() {
        return comments;
    }
}
