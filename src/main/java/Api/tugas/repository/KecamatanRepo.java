package Api.tugas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Api.tugas.model.Kecamatan;

@Repository
public interface KecamatanRepo extends JpaRepository<Kecamatan,Integer> {
    Kecamatan findByCodeKec(Integer code);
}
