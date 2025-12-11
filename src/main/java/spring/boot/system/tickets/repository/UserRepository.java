package spring.boot.system.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.system.tickets.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
