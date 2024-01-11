package dev.serhat.customerOrder;

import dev.serhat.customerOrder.model.Customer;
import dev.serhat.customerOrder.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class CustomerOrderApplication implements CommandLineRunner {

	public final CustomerRepository customerRepository;

    public CustomerOrderApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(CustomerOrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Customer customer1=customerRepository.save(new Customer("","Sergen","Turaç","5555555",new HashSet<>()));
		Customer customer2=customerRepository.save(new Customer("","Sevilay","Korkmaz","5555555",new HashSet<>()));
		System.out.println(customer1);
		System.out.println(customer2);


	}
}
