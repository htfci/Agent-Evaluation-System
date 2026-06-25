package dev.htfci.server.identity;

public interface AuthService {
    String apiKey();
    void remove(String apiKey);
    String hash(String rawPassword);
}

