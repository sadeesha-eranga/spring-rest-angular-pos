package lk.ijse.absd.pos.controller;

import lk.ijse.absd.pos.dto.CustomerDTO;
import lk.ijse.absd.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2018-08-21
 * Time: 10:37 AM
 */
@RestController
@CrossOrigin
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PutMapping
    public void saveCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.saveCustomer(customerDTO);
    }

    @PostMapping("{id}")
    public void updateCustomer(@PathVariable String id, @RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(Integer.parseInt(id), customerDTO);
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("{id}")
    public CustomerDTO findCustomer(@PathVariable int id) {
        return customerService.findCustomer(id);
    }

    @GetMapping()
    public Object findAllCustomers(@RequestParam(required = false) String action, @RequestParam(required = false) String name) {
        if (null != action) {
            switch (action) {
                case "count": {
                    return customerService.getCustomerCount();
                }

                case "like": {
                    return customerService.findCustomersLike(name);
                }

                default: {
                    return customerService.findAllCustomers();
                }
            }
        } else {
            return customerService.findAllCustomers();
        }
    }

}
