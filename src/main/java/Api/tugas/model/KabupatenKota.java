package Api.tugas.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table
@Entity
@NoArgsConstructor
public class KabupatenKota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 20, unique = true, nullable = false)
    private Integer kabKotCode;
    @Column(length = 50, nullable = false)
    private String kabKot;

    @ManyToOne
    @JoinColumn(name = "prov_code", referencedColumnName = "provCode")
    private Provinsi provinsi;

    @Column
    private Boolean isDeleted = false;



    public KabupatenKota(Integer kabKotCode, String kabKot, Provinsi provinsi) {
        this.kabKotCode = kabKotCode;
        this.kabKot = kabKot;
        this.provinsi =provinsi;
    }

}
