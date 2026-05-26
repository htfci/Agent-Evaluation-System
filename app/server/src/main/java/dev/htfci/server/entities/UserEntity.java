package dev.htfci.server.entities;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "user_name", nullable = false, length = 32)
    private String userName;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "user", orphanRemoval = true)
    private ApiKeyEntity apiKey;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "user", orphanRemoval = true)
    private PasswordEntity password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<RunEntity> runs;

    public UserEntity() {}
}
