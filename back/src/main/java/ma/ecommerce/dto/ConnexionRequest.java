package ma.ecommerce.dto;

import lombok.Data;

@Data
public class ConnexionRequest {
    private String email;
    private String password;
}
