package lk.ijse.absd.pos.service;

import lk.ijse.absd.pos.dto.CustomerDTO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2018-08-21
 * Time: 10:38 AM
 */
public interface CustomerService {

    void saveCustomer(String id, CustomerDTO dto);

    void updateCustomer(String id, CustomerDTO dto);

    void deleteCustomer(String id);

    CustomerDTO findCustomer(String id);

    List<CustomerDTO> findAllCustomers();

    List<CustomerDTO> findCustomersLike(String name);

    long getCustomerCount();

}
