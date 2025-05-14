package br.com.rr.store.product.domain.repository;

import br.com.rr.store.product.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
