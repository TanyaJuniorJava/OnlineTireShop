package dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rosh on 05.03.2017.
 */
@Entity
@Table(name="basket")
public class Basket {

    private int idOrder;
    private int quantity;
    private int total;

    private Set<Product> product = new HashSet<Product>();

    private User user;

    private OrderHistory orderHistory;


    @ManyToMany
    @JoinTable(name = "product_basket",
            joinColumns = @JoinColumn(name = "id_basket"),
            inverseJoinColumns = @JoinColumn(name = "id_product"))
    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn (name = "id_user")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "id_order_history")
    public OrderHistory getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(OrderHistory orderHistory) {
        this.orderHistory = orderHistory;
    }

    public Basket(){

    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="id")
    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    @Column(name="quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name="total")
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }



    public Basket(Set<Product> product, int quantity, int total, OrderHistory orderHistory, User user) {
        this.quantity = quantity;
        this.total = total;
        this.orderHistory = orderHistory;
        this.product = product;
        this.user = user;
    }


    @Override
    public String toString() {
        return "Basket{" +
                "idOrder=" + idOrder + '\'' +
                ", product=" + product + '\'' +
                ", total=" + total + '\'' +
                ", quantity=" + quantity + '\'' +
                ", orderHistory=" + orderHistory + '\'' +
                ", user=" + user + '\'' +
                '}';
    }
}
