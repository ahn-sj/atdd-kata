package atdd.api;

import atdd.application.CreateOrderService;
import atdd.application.PendingOrderRequest;
import atdd.application.PendingOrderResponse;
import atdd.domain.PendingOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderApi {
    private final CreateOrderService createOrderService;

    public OrderApi(final CreateOrderService createOrderService) {
        this.createOrderService = createOrderService;
    }

    @PostMapping("/orders/pendingOrder")
    public ResponseEntity<PendingOrderResponse> createPendingOrder(
            @RequestBody PendingOrderRequest request
    ) {
        PendingOrder pendingOrder = createOrderService.createPendingOrder(request);
        PendingOrderResponse response = new PendingOrderResponse(pendingOrder);
        return ResponseEntity.ok(response);
    }
}
