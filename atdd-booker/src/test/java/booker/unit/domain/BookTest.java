package booker.unit.domain;

import booker.domain.Book;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BookTest {
    @Test
    void BOOK의_absolute는_절대값을_반환한다() {
        // Given
        Book book = new Book("책이름");

        // When
        int result = book.absolute(-1);

        // Then
        assertThat(result).isEqualTo(1);
    }
}
