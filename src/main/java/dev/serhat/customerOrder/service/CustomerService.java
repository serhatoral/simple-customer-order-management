package dev.serhat.customerOrder.service;


import dev.serhat.customerOrder.exception.CustomerNotFoundException;
import dev.serhat.customerOrder.model.Customer;
import dev.serhat.customerOrder.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {


    /* Burada @Autowired kullanmadım çünkü SpringBoot servis sınıflarının altında final olan bağımlılıkları
        otomatik olarak bulup,oluşturuyor. Yani DI ve IOC container'ı işletiyor. Proje küçük çaplı olduğundan ve
        DI gerçekleştiğinden servisin interface'ini oluşturmadım.
     */
    private final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findById(String id) {
        return customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException(id +"'li kullanıcı bulunamdı!"));
    }
}
