package lk.ijse.absd.pos.controller;

import lk.ijse.absd.pos.dto.CustomerDTO;
import lk.ijse.absd.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public boolean saveCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.saveCustomer(customerDTO);
    }

    @PostMapping("{id}")
    public boolean updateCustomer(@PathVariable String id, @RequestBody CustomerDTO customerDTO) {
        return customerService.updateCustomer(Integer.parseInt(id), customerDTO);
    }

    @DeleteMapping("{id}")
    public boolean deleteCustomer(@PathVariable int id) {
        return customerService.deleteCustomer(id);
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
