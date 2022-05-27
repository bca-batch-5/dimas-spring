package Api.tugas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Api.tugas.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {
    Optional<Book> findById(Integer id);
}
