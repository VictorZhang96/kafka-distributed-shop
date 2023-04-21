package PaymentApp;

import PaymentApp.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import Order.Order;
import PaymentApp.domain.Customer;
import PaymentApp.service.OrderManageService;

@SpringBootApplication
@EnableKafka
public class PaymentApp {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentApp.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PaymentApp.class);
        app.run(args);
    }

    @Autowired
    OrderManageService orderManageService;

    @KafkaListener(id = "orders", topics = "orders", groupId = "payment")
    public void onEvent(Order o) {
        LOG.info("Received: {}" , o);
        if (o.getStatus().equals("NEW"))
            orderManageService.reserve(o);
        else
            orderManageService.confirm(o);
    }

    @Autowired
    private CustomerRepository repository;

    @PostConstruct
    public void generateData() {
        // generate 100 customer with 100 cash
        for (int i = 0; i < 100; i++) {
            int count = 100;
            Customer c = new Customer(null, "customer" + i, count, 0);
            repository.save(c);
        }
    }
}
