package booker.common;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("test")
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public abstract class AcceptanceTest {
    @LocalServerPort
    private int port;

    @Autowired
    private DatabaseCleanup databaseCleanup;

    private static final String DATABASE_NAME = "booker";
    private static final String DOCKER_IMAGE_NAME = "mysql:8.0.41";
    private static final String SCRIPT_PATH = "db/schema/schema.sql";

    @Container
    @ServiceConnection
    static MySQLContainer<?> mySQLContainer = new MySQLContainer<>(DockerImageName.parse(DOCKER_IMAGE_NAME))
            .withDatabaseName(DATABASE_NAME)
            .withInitScript(SCRIPT_PATH);

    @BeforeEach
    public void setUp() {
        if(RestAssured.UNDEFINED_PORT == port) {
            RestAssured.port = port;
            databaseCleanup.afterPropertiesSet();
        }
        RestAssured.baseURI = "http://localhost:" + port;
        databaseCleanup.execute();
    }
}
