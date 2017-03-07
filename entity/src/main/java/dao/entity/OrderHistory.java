package dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rosh on 05.03.2017.
 */
@Entity
@Table(name = "orderHistory")
public class OrderHistory {

    private int idOrderHistory;
    private int dateOrder;

    private Set<Basket> basket = new HashSet<Basket>();

    private User user;

    public OrderHistory() {
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderHistory")
    //@JoinTable(name = "id_basket", joinColumns = @JoinColumn(name = "order_history_id"), inverseJoinColumns = @JoinColumn(name = "basket_id"))
    public Set<Basket> getBasket() {
        return basket;
    }

    public void setBasket(Set<Basket> basket) {
        this.basket = basket;
    }


    @OneToOne
    //@MapsId
    @JoinColumn(name = "id_user")
    //@PrimaryKeyJoinColumn
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    public int getIdOrder() {
        return idOrderHistory;
    }

    public void setIdOrder(int idOrder) {
        this.idOrderHistory = idOrder;
    }

    @Column(name = "date")
    public int getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(int dateOrder) {
        this.dateOrder = dateOrder;
    }

    public OrderHistory(int dateOrder, User user) {
        this.dateOrder = dateOrder;
        this.user = user;
    }


    @Override
    public String toString() {
        return "OrderHistory{" +
                "idOrderHistory=" + idOrderHistory +
                ", dateOrder=" + dateOrder +
                ", basket=" + basket +
                ", user=" + user +
                '}';
    }
}

