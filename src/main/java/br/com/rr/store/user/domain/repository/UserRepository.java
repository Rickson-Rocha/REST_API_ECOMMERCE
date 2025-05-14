package br.com.rr.store.user.domain.repository;

import br.com.rr.store.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
