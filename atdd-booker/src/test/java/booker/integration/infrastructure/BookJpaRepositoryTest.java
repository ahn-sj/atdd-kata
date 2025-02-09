package booker.integration.infrastructure;

import booker.common.IntegrationTest;
import booker.domain.Book;
import booker.domain.BookJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class BookJpaRepositoryTest extends IntegrationTest {

    @Autowired
    private BookJpaRepository bookJpaRepository;

    @Test
    void BOOK을_저장한다() {
        // Given
        Book 책 = new Book("책이름");

        // When
        Book save = bookJpaRepository.save(책);

        // Then
        assertThat(save.getId()).isNotNull();
    }

}
