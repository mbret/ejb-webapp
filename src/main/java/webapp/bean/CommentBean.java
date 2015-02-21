package webapp.bean;

import webapp.core.BeanAbstract;

import java.util.Date;

/**
 * Created by Maxime on 2/21/2015.
 */
public class CommentBean extends BeanAbstract {

    public String content;
    public UserBean author;
    public Date date;
    
    public CommentBean() {
    }

    public CommentBean(String content, UserBean author, Date date) {
        this.content = content;
        this.author = author;
        this.date = date;
    }

    public CommentBean(Object id, String content, UserBean author, Date date) {
        super(id);
        this.content = content;
        this.author = author;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public UserBean getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }
}
