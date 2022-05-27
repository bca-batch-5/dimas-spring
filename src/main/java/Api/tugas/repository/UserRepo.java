package Api.tugas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Api.tugas.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    
}
