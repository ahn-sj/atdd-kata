package booker.common;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@ActiveProfiles("test")
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IntegrationTest {

    private static final String DATABASE_NAME = "booker_integration";
    private static final String DOCKER_IMAGE_NAME = "mysql:8.0.36";
    private static final String SCRIPT_PATH = "db/schema/schema.sql";

    @Autowired
    private DatabaseCleanup databaseCleanup;

    @Container
    @ServiceConnection
    private static final MySQLContainer<?> INTEGRATION_CONTAINER = new MySQLContainer<>(DockerImageName.parse(DOCKER_IMAGE_NAME))
            .withDatabaseName(DATABASE_NAME)
            .withInitScript(SCRIPT_PATH);

    @BeforeEach
    public void cleanup() {
        databaseCleanup.afterPropertiesSet();
        databaseCleanup.execute();
    }
}
