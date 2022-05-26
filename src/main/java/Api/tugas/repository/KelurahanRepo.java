package Api.tugas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Api.tugas.model.Kelurahan;

@Repository
public interface KelurahanRepo extends JpaRepository<Kelurahan, Integer> {
    Kelurahan findByCodeKel(Integer code);
}
