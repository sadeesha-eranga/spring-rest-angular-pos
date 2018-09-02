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

    boolean saveCustomer(CustomerDTO dto);

    boolean updateCustomer(int id, CustomerDTO dto);

    boolean deleteCustomer(int id);

    CustomerDTO findCustomer(int id);

    List<CustomerDTO> findAllCustomers();

    List<CustomerDTO> findCustomersLike(String name);

    long getCustomerCount();

}
