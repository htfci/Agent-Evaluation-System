package dev.htfci.server.identity;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IdentityRepository extends ListCrudRepository<UserEntity, UUID> {}
