package vlv.springframework.spring6restmvc.controller;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import vlv.springframework.spring6restmvc.entities.Beer;
import vlv.springframework.spring6restmvc.entities.Customer;
import vlv.springframework.spring6restmvc.model.BeerDTO;
import vlv.springframework.spring6restmvc.model.CustomerDTO;
import vlv.springframework.spring6restmvc.repositories.CustomerRepository;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerControllerIT {

    @Autowired
    CustomerController customerController;

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void testGetByIdNotFound() {
        assertThrows(NotFoundException.class, () -> {
            customerController.getCustomerById(UUID.randomUUID());
        });
    }

    @Test
    void testGetById() {
        Customer customer = customerRepository.findAll().get(0);

        CustomerDTO dtos = customerController.getCustomerById(customer.getId());

        assertThat(dtos).isNotNull();
    }

    @Test
    void testListAll() {
        List<CustomerDTO> dtos = customerController.listAllCustomers();

        assertThat(dtos.size()).isEqualTo(3);
    }

    @Rollback
    @Transactional
    @Test
    void testListAllEmptyList() {
        customerRepository.deleteAll();
        List<CustomerDTO> dtos = customerController.listAllCustomers();

        assertThat(dtos.size()).isEqualTo(0);

        }

}