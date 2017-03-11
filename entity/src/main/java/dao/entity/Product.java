package dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rosh on 05.03.2017.
 */
@Entity
@Table(name="product")

public class Product {

    private int idProduct;
    private String category;
    private String brand;
    private String model;
    private String size;
    private double price;

    private Set<Basket> baskets = new HashSet<Basket>();

    private Set<Comments> comments = new HashSet<Comments>();

    @ManyToMany
    @JoinTable(name = "product_basket",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_basket"))
    public Set<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(Set<Basket> baskets) {
        this.baskets = baskets;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    public Set<Comments> getComments() {
        return comments;
    }

    public void setComments(Set<Comments> comments) {
        this.comments = comments;
    }


    public Product(){

    }


    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="id")
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Column(name="category")
    public String getNameProduct() {
        return category;
    }

    public void setNameProduct(String nameProduct) {
        this.category = nameProduct;
    }

    @Column(name="brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name="model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name="size")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Column(name="price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }




    @Override
    public String toString() {
        return "Product{" +
                "id='" + idProduct + '\'' +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", size='" + size + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public Product(String category, String brand, String model, String size, double price) {
        this.category = category;
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.price = price;
    }

}

