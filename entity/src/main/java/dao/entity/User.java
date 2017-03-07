package dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rosh on 05.03.2017.
 */
@Entity
@Table(name="user")
public class User {

    private int idUser;
    private String name;
    private String email;
    private String password;


    private Set<Comments> comments = new HashSet<Comments>();

    private Set<Basket> basket = new HashSet<Basket>();

    private OrderHistory orderHistory;// нужно создавать??? или просто указываем id?


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<Comments> getComments() {
        return comments;
    }

    public void setComments(Set<Comments> comments) {
        this.comments = comments;
    }

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "user")
    public Set<Basket> getBasket() {
        return basket;
    }

    public void setBasket(Set<Basket> basket) {
        this.basket = basket;
    }

    @OneToOne //(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public OrderHistory getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(OrderHistory orderHistory) {
        this.orderHistory = orderHistory;
    }

    public User(){

    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password, Set<Comments> comments, Set<Basket> basket, OrderHistory orderHistory) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.comments = comments;
        this.basket = basket;
        this.orderHistory = orderHistory;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="id")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", comments=" + comments +
                ", basket=" + basket +
                ", orderHistory=" + orderHistory +
                '}';
    }
}
