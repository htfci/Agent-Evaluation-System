package dev.htfci.server.identity;

import org.springframework.stereotype.Service;

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

}
