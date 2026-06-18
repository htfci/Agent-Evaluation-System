package dev.htfci.server.identity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RegistrationServiceImplTest {
    private UserEntity user;

    @Mock
    private IdentityRepository repository;

    @InjectMocks
    private RegistrationServiceImpl registrationService;

    @BeforeEach
    void setUp() {
        this.user = new UserEntity("hex", "hex.agon6@hotmail.com", "");
    }

    @AfterEach
    void tearDown() {
        this.user = null;
    }

    @Test
    void shouldSuccessfullyRegisterUser() {
        // Arrange
        UserEntity newUser = new UserEntity("hex", "hex.agon6@hotmail.com","");
        ReflectionTestUtils.setField(newUser, "id", UUID.randomUUID());
        Mockito.when(repository.save(user)).thenReturn(newUser);

        // Act
        UserEntity registeredUser = registrationService.register(user);

        // Assert
        assertNotNull(registeredUser);
        assertInstanceOf(UUID.class, registeredUser.getId());
        assertNotNull(registeredUser.getId());
        assertEquals("hex", registeredUser.getUserName());
        assertEquals("", registeredUser.getPasswordHash());

        // Verify
        Mockito.verify(repository, Mockito.times(1)).save(user);
    }
}
