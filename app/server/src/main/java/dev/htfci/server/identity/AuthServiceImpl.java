package dev.htfci.server.identity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;


    protected AuthServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    // Move this to BBL
    private Boolean exists(String apiKeyHash) {
        // todo: check database if key hash already exist
        return null;
    }

    @Override
    public void put(String apiKeyHash) {
        // First: if apiKeyHash already exists do not insert!
        // Second: insert apiKeyHash
    }

    @Override
    public String hash(String rawPassword) {
        Objects.requireNonNull(rawPassword);
        return passwordEncoder.encode(rawPassword);
    }
}
