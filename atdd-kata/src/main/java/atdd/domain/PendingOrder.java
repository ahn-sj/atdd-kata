package atdd.domain;

import lombok.Getter;

@Getter
public class PendingOrder {
    private long id;
    private long productId;
    private long quantity;

    public PendingOrder(final long productId, final long quantity)  {
        this.productId = productId;
        this.quantity = quantity;
    }

    public void assignId(final long nextId) {
        this.id = nextId;
    }
}
