package dto;

import lombok.Data;

@Data
public class AuthenticationRequestDTO {

    private String userName;
    private String password;
}
