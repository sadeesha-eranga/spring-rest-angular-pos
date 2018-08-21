package lk.ijse.absd.pos.service.impl;

import lk.ijse.absd.pos.dto.CustomerDTO;
import lk.ijse.absd.pos.entity.Customer;
import lk.ijse.absd.pos.repository.CustomerRepository;
import lk.ijse.absd.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2018-08-21
 * Time: 10:38 AM
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveCustomer(String id, CustomerDTO dto) {
        if (!id.equals(dto.getId())){
            throw new RuntimeException("Customer ID mismatched.");
        }
        customerRepository.save(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateCustomer(String id, CustomerDTO dto) {
        if (!id.equals(dto.getId())){
            throw new RuntimeException("Customer ID mismatched.");
        }
        if (customerRepository.existsById(id)) {
            customerRepository.save(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
        } else {
            throw new RuntimeException("Customer not found.");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerDTO findCustomer(String id) {
        Customer customer = customerRepository.findById(id).get();
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress());
    }

    @Override
    public List<CustomerDTO> findAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDTO> dtoList = new ArrayList<>();
        customerList.forEach(customer -> {
            dtoList.add(new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress()));
        });
        return dtoList;
    }

    @Override
    public List<CustomerDTO> findCustomersLike(String name) {
        List<Customer> list = customerRepository.findCustomersLike("%" + name + "%");
        List<CustomerDTO> dtoList = new ArrayList<>();
        list.forEach(customer -> {
            dtoList.add(new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress()));
        });
        return dtoList;
    }

    @Override
    public long getCustomerCount() {
        return customerRepository.count();
    }
}