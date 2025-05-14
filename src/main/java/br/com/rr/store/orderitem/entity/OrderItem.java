package br.com.rr.store.orderitem.entity;

import br.com.rr.store.order.domain.entity.Order;
import br.com.rr.store.product.domain.entity.Product;
import jakarta.persistence.*;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"order_id", "product_id"},name = "tb_order_item")
)
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderItem() {}

    public OrderItem(Integer quantity, Long id, Double price, Order order, Product product) {
        this.quantity = quantity;
        this.id = id;
        this.price = price;
        this.order = order;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getSubTotal() {
        return price * quantity;
    }


}
