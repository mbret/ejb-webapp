package webapp.bean;

import ejbinterface.model.ArticleShared;
import webapp.core.BeanAbstract;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Maxime on 2/21/2015.
 */
public class ArticleBean extends BeanAbstract {
    
    public String title;
    public String content;
    public Date date;
    public UserBean author;
    public List<CommentBean> comments = new ArrayList<CommentBean>();
    public String role;
    
    public ArticleBean() {
        
    }

    @Override
    public void loadFromModel(Object model) throws Exception {
        this.id = ((ArticleShared)model).getId();
        this.title = ((ArticleShared)model).getTitre();
        this.content = ((ArticleShared)model).getContenu();
        this.date = ((ArticleShared)model).getDate();
        this.author = BeanFactory.convert(UserBean.class, ((ArticleShared)model).getAuteur());
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

    public List<CommentBean> getComments() {
        return comments;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAuthor(UserBean author) {
        this.author = author;
    }

    public void setComments(List<CommentBean> comments) {
        this.comments = comments;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
