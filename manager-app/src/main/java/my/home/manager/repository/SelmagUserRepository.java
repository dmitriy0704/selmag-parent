package my.home.manager.repository;

import my.home.manager.entity.SelmagUser;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface SelmagUserRepository extends CrudRepository<SelmagUser, Long> {
   Optional<SelmagUser> findByUsername(String username);
}
