package PaymentApp.repository;

import org.springframework.data.repository.CrudRepository;
import PaymentApp.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
