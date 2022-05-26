package Api.tugas.dto.request;
import Api.tugas.model.Provinsi;
import lombok.Data;

@Data
public class KabKotDto {
    private Integer kodeKabupatenKota;
    private String kabupatenKota;
    private Provinsi kodeProvinsi;
}
