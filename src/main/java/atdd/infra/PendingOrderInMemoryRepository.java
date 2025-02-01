package atdd.infra;

import atdd.domain.PendingOrder;
import atdd.domain.PendingOrderRepository;

import java.util.concurrent.atomic.AtomicLong;

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
