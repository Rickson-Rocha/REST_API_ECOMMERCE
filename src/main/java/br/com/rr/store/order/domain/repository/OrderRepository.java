package br.com.rr.store.order.domain.repository;

import br.com.rr.store.order.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
