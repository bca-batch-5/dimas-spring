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
public class Kelurahan {
    
    public Kelurahan(Integer codeKel, String kelurahan) {
        this.codeKel = codeKel;
        this.kelurahan = kelurahan;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false, unique = true)
    private Integer codeKel;

    @Column(length = 50, nullable = false)
    private String kelurahan;

    @Column
    private Boolean isDeleted = false;
}
