package dev.htfci.server.identity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceImplTest {

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthServiceImpl authService;

    @Test
    void hash() {
        // Arrange
        String password = "htd349#n$";
        String simulatedHash = "simulated_encoded_bcrypt_hash_value";
        Mockito.when(passwordEncoder.encode(password)).thenReturn(simulatedHash);

        // Act
        String hashedPassword = authService.hash(password);

        // Assert
        assertEquals(simulatedHash, hashedPassword);

        // Verify
        Mockito.verify(passwordEncoder, Mockito.times(1)).encode(password);
    }

    @Test
    void put() {
    }
}
