package dev.htfci.server.identity;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(path = "/identity")
class IdentityController {
    private final AuthService authService;
    private final RegistrationService registrationService;


    protected IdentityController(AuthService authService, RegistrationService registrationService) {
        this.authService = authService;
        this.registrationService = registrationService;
    }

    // todo: If user already exist..
    @PostMapping(path = "/users")
    public ResponseEntity<Void> register(@Valid @RequestBody UserDto userDto) {
        String hashedPassword = authService.hash(userDto.rawPassword());
        UserEntity registeredUser = registrationService.register(new UserEntity(userDto.userName(), userDto.email(), hashedPassword));
        URI uri = registrationService.getUriFrom(registeredUser);
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "")
    public ResponseEntity<ApiKeyDto> apiKey() {
        return null;
    }
}
