package atdd.application;

import atdd.domain.PendingOrder;
import lombok.Getter;

@Getter
public class PendingOrderResponse {
    private long id;
    private long productId;
    private long quantity;

    private PendingOrderResponse() {
    }

    public PendingOrderResponse(final PendingOrder pendingOrder) {
        this.id = pendingOrder.getId();
        this.productId = pendingOrder.getProductId();
        this.quantity = pendingOrder.getQuantity();
    }
}
