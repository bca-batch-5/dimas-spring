package Api.tugas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Api.tugas.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {
    
}
