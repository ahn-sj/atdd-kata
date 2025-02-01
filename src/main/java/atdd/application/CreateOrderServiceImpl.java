package atdd.application;

import atdd.domain.PendingOrder;
import atdd.domain.PendingOrderRepository;
import atdd.infra.PendingOrderInMemoryRepository;

class CreateOrderServiceImpl implements CreateOrderService {
    private PendingOrderRepository pendingOrderRepository = new PendingOrderInMemoryRepository();

    @Override
    public PendingOrder createPendingOrder(final PendingOrderRequest request) {
        PendingOrder pendingOrder = new PendingOrder(request.getProductId(), request.getQuantity());
        return pendingOrderRepository.save(pendingOrder);
    }


}
