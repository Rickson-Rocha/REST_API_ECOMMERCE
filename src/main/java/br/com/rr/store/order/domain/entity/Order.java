package br.com.rr.store.order.domain.entity;

import br.com.rr.store.order.domain.enums.OrderStatus;
import br.com.rr.store.orderitem.entity.OrderItem;
import br.com.rr.store.payment.domain.entity.Payment;
import br.com.rr.store.user.domain.entity.User;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant moment =  Instant.now();

    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToOne(mappedBy = "order")
    private Payment payment;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();

    public Order() {
    }

    public Order(User client, OrderStatus status, Instant moment, Long id) {
        this.client = client;
        this.status = status;
        this.moment = moment;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public User getClient() {
        return client;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Payment getPayment() {
        return payment;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        this.items.add(item);
    }

    public void removeItem(OrderItem item) {
        this.items.remove(item);
    }

    public Double getTotal() {
        return items.stream()
                .mapToDouble(OrderItem::getSubTotal)
                .sum();
    }

}
