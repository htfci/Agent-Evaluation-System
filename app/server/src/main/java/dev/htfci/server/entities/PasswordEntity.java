package dev.htfci.server.entities;

import jakarta.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "passwords")
public class PasswordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "password_hash", unique = true, nullable = false)
    private String passwordHash;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", unique = true, nullable = false, updatable = false)
    private UserEntity user;

    public PasswordEntity() {}
}
