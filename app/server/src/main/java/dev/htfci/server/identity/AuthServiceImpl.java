package dev.htfci.server.identity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final IdentityRepository identityRepository;


    protected AuthServiceImpl(PasswordEncoder passwordEncoder, IdentityRepository identityRepository) {
        this.passwordEncoder = passwordEncoder;
        this.identityRepository = identityRepository;
    }

    // todo
    @Override
    public String apiKey() {
        return "";
    }

    @Override
    public void remove(String apiKey) {

    }

    @Override
    public String hash(String rawPassword) {
        Objects.requireNonNull(rawPassword);
        return passwordEncoder.encode(rawPassword);
    }
}
