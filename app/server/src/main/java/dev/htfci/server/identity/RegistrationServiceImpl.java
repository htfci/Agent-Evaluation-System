package dev.htfci.server.identity;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Objects;

@Service
class RegistrationServiceImpl implements RegistrationService {
    private final IdentityRepository identityRepository;


    protected RegistrationServiceImpl(IdentityRepository repository) {
        this.identityRepository = repository;
    }


    @Override
    public UserEntity register(UserEntity user) {
        Objects.requireNonNull(user);
        return identityRepository.save(user);
    }

    public URI getUriFrom(UserEntity user) {
        Objects.requireNonNull(user);
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
    }
}
