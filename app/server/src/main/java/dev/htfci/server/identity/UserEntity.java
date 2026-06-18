package dev.htfci.server.identity;

import dev.htfci.server.evaluation.RunEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(name = "user_name", nullable = false, length = 32)
    private String userName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "password_hash", nullable = false, length = 64)
    private String passwordHash;

    @Column(name = "apikey_hash", updatable = false)
    private String apiKeyHash = "";

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<RunEntity> runs;

    protected UserEntity() {}

    protected UserEntity(String userName, String email, String passwordHash) {
        this.userName = userName;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public UUID getId() {return this.id;}

    public String getUserName() {return this.userName;}

    public String getEmail() {return this.email;}

    public String getPasswordHash() {return this.passwordHash;}

    public String getApiKeyHash() {return apiKeyHash;}

    public void setApiKeyHash(String apiKeyHash) {
        ApiKey apiKey = new ApiKey(apiKeyHash);
        this.apiKeyHash = apiKey.apiKeyHash;
    }

    // Implicitly 'static'
    private record ApiKey(String apiKeyHash) {
        private ApiKey {
            Objects.requireNonNull(apiKeyHash, "Key hash cannot be null");
            if (apiKeyHash.isBlank()) {
                throw new IllegalArgumentException("Key hash cannot be blank");
            }
        }
    }
}
