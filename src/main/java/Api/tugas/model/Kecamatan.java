package Api.tugas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table
@Entity
@NoArgsConstructor
public class Kecamatan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "kode_kec", unique = true, length = 50, nullable = false)
    private Integer codeKec;
    @Column(length = 50, nullable = false)
    private String kecamatan;
    @Column()
    private Boolean isDeleted = false;

    public Kecamatan(Integer codeKec, String kecamatan) {
        this.codeKec = codeKec;
        this.kecamatan = kecamatan;
    }

}
