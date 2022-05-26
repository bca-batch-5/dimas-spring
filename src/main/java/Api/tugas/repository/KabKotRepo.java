package Api.tugas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Api.tugas.model.KabupatenKota;

@Repository
public interface KabKotRepo extends JpaRepository<KabupatenKota,Integer> {
    KabupatenKota findByKabKotCode(Integer code);
}
