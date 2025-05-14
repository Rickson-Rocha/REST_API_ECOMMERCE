package br.com.rr.store.payment.domain.entity;

import br.com.rr.store.order.domain.entity.Order;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_payment")
public class Payment {

    @Id
    private Long id;

    private Instant createdAt;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Order order;

    public Payment() {
    }

    public Payment(Long id, Order order, Instant createdAt) {
        this.id = id;
        this.order = order;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Order getOrder() {
        return order;
    }


}
