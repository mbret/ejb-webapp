package webapp.bean;

import ejbinterface.model.CommentShared;
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

    @Override
    public void loadFromModel(Object model) throws Exception {
        this.id = ((CommentShared)model).getId();
        this.content = ((CommentShared)model).getContent();
        this.date = ((CommentShared)model).getDate();
        this.author = BeanFactory.convert(UserBean.class, ((CommentShared)model).getAuteur());
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
