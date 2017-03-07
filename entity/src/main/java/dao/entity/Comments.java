package dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Rosh on 05.03.2017.
 */
@Entity
@Table(name = "comments")
public class Comments {

    private int idComment;
    private int dateComment;
    private String content;

    private User user;

    @ManyToOne
    @JoinColumn(name = "id_product")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private Product product;

    @ManyToOne
    @JoinColumn (name="id_user")
    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="id")
    public int getIdComment(){
        return idComment;
    }

    public void setIdComment(int idComment){
        this.idComment = idComment;
    }

    @Column(name="date")
    public int getDateComment(){
        return dateComment;
    }

    public void setDateComment(int dateComment){
        this.dateComment = dateComment;
    }

    @Column(name="content")
    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "idComment=" + idComment +
                ", dateComment=" + dateComment +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", product=" + product +
                '}';
    }

    public Comments(int dateComment, String content, User user, Product product) {
        this.dateComment = dateComment;
        this.content = content;
        this.user = user;
        this.product = product;
    }
}
