package br.com.rr.store.category.domain.entity;


import br.com.rr.store.product.domain.entity.Product;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "Category_Product",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products =  new ArrayList<>();

    public Category() {
    }

    public Category(String name, Long id) {
        this.name = name;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }
}
