package Api.tugas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Api.tugas.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findById(Integer id);
}
