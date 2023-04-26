package OrderApp.service;

import org.springframework.stereotype.Service;
import Order.Order;

@Service
public class OrderManageService {


    public Order confirm(Order orderPayment, Order orderStock) {
        Order o = new Order(orderPayment.getId(),
                orderPayment.getCustomerId(),
                orderPayment.getProductId(),
                orderPayment.getProductCount(),
                orderPayment.getPrice());
        if (orderPayment.getStatus().equals("ACCEPT") &&
                orderStock.getStatus().equals("ACCEPT")) {
            o.setStatus("CONFIRMED");
        } else if (orderPayment.getStatus().equals("REJECT")){
                o.setStatus("REJECTED");
                o.setSource("PAYMENT");
        } else {
            o.setStatus("REJECTED");
            o.setSource("STOCK");
        }
//        repository.save(o);
        return o;
    }

}
