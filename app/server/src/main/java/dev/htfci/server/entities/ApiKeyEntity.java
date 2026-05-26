package dev.htfci.server.entities;

import jakarta.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "api_keys")
public class ApiKeyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "key_hash", nullable = false, unique = true)
    private String keyHash;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", unique = true, nullable = false, updatable = false)
    private UserEntity user;

    public ApiKeyEntity() {}
}
