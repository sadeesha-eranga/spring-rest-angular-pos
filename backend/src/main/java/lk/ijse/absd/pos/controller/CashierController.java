package lk.ijse.absd.pos.controller;

import lk.ijse.absd.pos.dto.OrderDTO;
import lk.ijse.absd.pos.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2018-08-22
 * Time: 12:28 PM
 */
@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/orders")
public class CashierController {

    @Autowired
    private CashierService cashierService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveOrder(@RequestBody OrderDTO orderDTO) {
        return cashierService.saveOrder(orderDTO);
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getOrdersCount() {
        return cashierService.getTotalOrders();
    }

}
