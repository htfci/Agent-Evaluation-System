package dev.htfci.server.identity;

public interface AuthService {
    public void put(String apiKeyHash);
    public String hash(String rawPassword);
}

