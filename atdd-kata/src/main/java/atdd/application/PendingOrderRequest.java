package atdd.application;

import lombok.Getter;

@Getter
public class PendingOrderRequest {
    private long productId;
    private long quantity;

    private PendingOrderRequest() {
    }

    public PendingOrderRequest(final Long productId, final int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public static PendingOrderRequest of(final Long productId, final int quantity) {
        return new PendingOrderRequest(productId, quantity);
    }
}
