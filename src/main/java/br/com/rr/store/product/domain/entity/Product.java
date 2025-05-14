package br.com.rr.store.product.domain.entity;

import br.com.rr.store.category.domain.entity.Category;
import br.com.rr.store.orderitem.entity.OrderItem;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double price;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToMany(mappedBy = "products")
    private List<Category> categories =  new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();


    public Product() {
    }

    public Product( Long id, String name,String description, Double price,String imageUrl) {
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void addCategory(Category category) {
        if (!categories.contains(category)) {
            categories.add(category);
        }
    }

    public void removeCategory(Category category) {
        this.categories.remove(category);
    }

    public int getTotalUnitsSold() {
        int totalUnitsSold = 0;
        for(OrderItem orderItem : items) {
            totalUnitsSold += orderItem.getQuantity();
        }
        return totalUnitsSold;
    }
}

