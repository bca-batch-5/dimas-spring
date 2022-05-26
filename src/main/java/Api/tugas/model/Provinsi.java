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
public class Provinsi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 20, unique = true , nullable = false)
    private Integer provCode;
    @Column(length = 50, nullable = false)
    private String provinsi;
    @Column
    private Boolean isDeleted = false;

    public Provinsi(Integer provCode, String provinsi) {
        this.provCode = provCode;
        this.provinsi = provinsi;
    }
}
