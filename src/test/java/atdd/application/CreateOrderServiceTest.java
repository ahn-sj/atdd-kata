package atdd.application;

import atdd.domain.PendingOrder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateOrderServiceTest {
    private CreateOrderService createOrderService = new CreateOrderServiceImpl(pendingOrderRepository);

    @Test
    void createPendingOrder() {
        // Given:
        Long productId = 1L;
        int quantity = 2;
        PendingOrderRequest request = PendingOrderRequest.of(productId, quantity);

        // When:
        PendingOrder pendingOrder = createOrderService.createPendingOrder(request);

        // Then:
        Assertions.assertThat(pendingOrder.getId()).isGreaterThan(0);

    }

}
