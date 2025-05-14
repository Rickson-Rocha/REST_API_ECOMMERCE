package br.com.rr.store.category.domain.repository;

import br.com.rr.store.category.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category,Long> {
}
