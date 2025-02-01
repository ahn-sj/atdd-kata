package atdd.infra;

import atdd.domain.PendingOrder;
import atdd.domain.PendingOrderRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PendingOrderInMemoryRepository implements PendingOrderRepository {
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
