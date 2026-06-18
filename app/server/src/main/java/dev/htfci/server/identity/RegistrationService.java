package dev.htfci.server.identity;


import java.net.URI;

public interface RegistrationService {
    UserEntity register(UserEntity user);
    URI getUriFrom(UserEntity user);
}
