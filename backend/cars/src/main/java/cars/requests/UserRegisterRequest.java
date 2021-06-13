package cars.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegisterRequest {
    private final String email;
    private final String name;
    private final String surname;
    private final String username;
    private final String password;
}
