package Api.tugas.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Api.tugas.model.Provinsi;

@Repository
public interface ProvinsiRepo extends JpaRepository<Provinsi,Integer> {
    Provinsi findByprovCode(Provinsi code);
}
