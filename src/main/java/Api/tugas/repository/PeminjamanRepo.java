package Api.tugas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Api.tugas.model.Peminjaman;

@Repository
public interface PeminjamanRepo extends JpaRepository<Peminjaman,Integer> {
    
}
