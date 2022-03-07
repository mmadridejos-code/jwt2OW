package cat.itb.damir.autenticaio.basic.jwt.jwt.model.entitats;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class UsuariConsultaDTO {
    private String username;
    private String avatar;
    private String rol;
}
