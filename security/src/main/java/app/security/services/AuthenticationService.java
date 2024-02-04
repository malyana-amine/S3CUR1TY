package app.security.services;


import app.security.dto.requests.AuthenticationRequest;
import app.security.dto.requests.RegisterRequest;
import app.security.dto.responses.AuthenticationResponse;
import org.springframework.stereotype.Component;

@Component
public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest user);

    AuthenticationResponse authenticate(AuthenticationRequest user);

}
