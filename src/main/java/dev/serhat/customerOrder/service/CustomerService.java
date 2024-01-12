package dev.serhat.customerOrder.service;


import dev.serhat.customerOrder.dto.CustomerDto;
import dev.serhat.customerOrder.dto.converter.CustomerDtoConverter;
import dev.serhat.customerOrder.exception.CustomerNotFoundException;
import dev.serhat.customerOrder.model.Customer;
import dev.serhat.customerOrder.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {


    /* Burada @Autowired kullanmadım çünkü SpringBoot servis sınıflarının altında final olan bağımlılıkları
        otomatik olarak bulup,oluşturuyor. Yani DI ve IOC container'ı işletiyor. Proje küçük çaplı olduğundan ve
        DI gerçekleştiğinden servisin interface'ini oluşturmadım.
     */
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;
    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }

    public Customer findById(String id) {
        return customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException(id +"'li kullanıcı bulunamdı!"));
    }

    public CustomerDto getCustomerDtoById(String id){
        return customerDtoConverter.customerDtoFromCustomer(Optional.of(findById(id)));
    }
}
