package atdd.application;

import atdd.domain.PendingOrder;

public interface CreateOrderService {
    PendingOrder createPendingOrder(PendingOrderRequest request);
}
