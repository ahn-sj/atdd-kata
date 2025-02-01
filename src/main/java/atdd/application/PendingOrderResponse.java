package atdd.application;

import lombok.Getter;

@Getter
public class PendingOrderResponse {
    private long id;
    private long productId;
    private long quantity;

    public PendingOrderResponse(final long productId, final long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
