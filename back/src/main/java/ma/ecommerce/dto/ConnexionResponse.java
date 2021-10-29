package ma.ecommerce.dto;

import lombok.Data;
import ma.ecommerce.beans.User;

@Data
public class ConnexionResponse {
    private String jwt;
    private User user;

    public ConnexionResponse(String jwt, User user) {
        this.jwt = jwt;
        this.user = user;
    }
}
