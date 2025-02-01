package atdd.application;

import atdd.domain.PendingOrder;
import atdd.domain.PendingOrderRepository;
import org.antlr.v4.runtime.misc.LogManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicLong;

public class CreateOrderServiceTest {
    private CreateOrderService createOrderService = new CreateOrderServiceImpl() {
    };

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

    private static class CreateOrderServiceImpl implements CreateOrderService {
        private PendingOrderRepository pendingOrderRepository = new PendingOrderInMemoryRepository();

        @Override
        public PendingOrder createPendingOrder(final PendingOrderRequest request) {
            PendingOrder pendingOrder = new PendingOrder(request.getProductId(), request.getQuantity());
            return pendingOrderRepository.save(pendingOrder);
        }


    }

    private static class PendingOrderInMemoryRepository implements PendingOrderRepository {
        private final AtomicLong atomicId = new AtomicLong(1);

        @Override
        public PendingOrder save(final PendingOrder pendingOrder) {
            pendingOrder.assignId(nextId());
            return pendingOrder;
        }

        private long nextId() {
            return atomicId.getAndIncrement();
        }
    }
}
